package com.riwi.vacants.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRepository companyRepository;  
    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        
        /*1. Configuramos la paginacion */
        if (page < 0)
        page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.companyRepository.findAll(pagination)
        .map(company -> this.entityToResponse(company));
    }


    @Override
    public CompanyResponse create(CompanyRequest request) {

    Company company = this.requestToEntity(request, new Company());

    return this.entityToResponse(this.companyRepository.save(company));


    }

    @Override
    public CompanyResponse update(CompanyRequest request, String id) {

       Company companyToUpdate = this.find(id);

       Company company = this.requestToEntity(request,companyToUpdate);
       return this.entityToResponse(this.companyRepository.save(company));
    }

    @Override
    public void delete(String id) {
//Buscamos la compañia a la que corresponde el id
        Company company = this.find(id);
        //Eliminamos
        this.companyRepository.delete(company);
    }

    @Override
    public CompanyResponse getById(String id) {
//Buscamos la compañia con el id
        Company company = this.find(id);
        //COnvertimos la entidad al dto de respuesta y lo retornamos
        return this.entityToResponse(company);
    } 

    /*
     * Este Metodo se encargará de convertir una entidad en el dto de repuesta
     * de la entidad
     */

    private CompanyResponse entityToResponse(Company entity){

        CompanyResponse response = new CompanyResponse();

        /*response.setId(entity.getId());
        response.setName(entity.getName());
        response.setLocation(entity.getLocation());
        response.setContact(entity.getContact());*/

        /*BeansUtils Nos permite hacer una copia de una clase
         * en otra En este caso toda la entidad de tipo company sera
         * copiada con la informacion requerida por la variable tipo CompanyResponse
         */
        BeanUtils.copyProperties(entity, response);

        /**
         * Stream -> Convierte la lista en coleccion para poder iterarse
         * map-> Itera toda la lista y retorna cambios
         * collect -> Crea de nuevo toda la lista que se habia transformado en 
         */
        response.setVacants(entity.getVacants().stream()
        .map(Vacant -> this.VacantToResponse(Vacant))
        .collect(Collectors.toList()));
        return response;
    }

    private VacantToCompanyResponse VacantToResponse(Vacant entity){ 

        VacantToCompanyResponse response = new VacantToCompanyResponse();
    BeanUtils.copyProperties(entity, response);
    return response;
}

private Company requestToEntity(CompanyRequest entity, Company company){

    company.setContact(entity.getContact());
    company.setLocation(entity.getLocation());
    company.setName(entity.getName());
    company.setVacants(new ArrayList<>());
    return company;
}

private Company find(String id){
    return this.companyRepository.findById(id).orElseThrow(()-> new IdNotFoundException("Company"));
}
    
}
