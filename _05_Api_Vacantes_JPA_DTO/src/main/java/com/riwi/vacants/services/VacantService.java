package com.riwi.vacants.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.repositories.VacantRepository;
import com.riwi.vacants.services.interfaces.IVacantsService;
import com.riwi.vacants.utils.dto.request.VacantRequest;
import com.riwi.vacants.utils.dto.response.CompanyToVacantResponse;
import com.riwi.vacants.utils.dto.response.VacantResponse;
import com.riwi.vacants.utils.enums.StatusVacant;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacantService implements IVacantsService {

    @Autowired
    private final VacantRepository vacantRepository;
    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public Page<VacantResponse> getAll(int page, int size) {

        if (page < 0) page = 0; 

        PageRequest pagination = PageRequest.of(page,size);

            /*Obtenemos todas las vacantes, las iteramos para convertir cada una a el dto de respuesta */

        return this.vacantRepository.findAll(pagination).map(vacant -> this.entityToResponse(vacant));

        
    }

    @Override
    public VacantResponse create(VacantRequest request) {
    /*
     *Buscamos la compañia que corresponda con el id que esta dentro del request
    */
        Company company = this.companyRepository.findById(request.getCompanyId()).orElseThrow(()-> new IdNotFoundException("Company"));
        /*Convertimos el request a una instancia de vacante */
        Vacant vacant = this.requestToVacant(request, new Vacant());
        vacant.setCompany(company);
/*Guardamos en la BD y convertimos */
        return this.entityToResponse(this.vacantRepository.save(vacant));
    }

    @Override
    public VacantResponse update(VacantRequest request, Long id) {
        Vacant vacant = this.find(id);
        Company company = this.companyRepository.findById(request.getCompanyId())
        .orElseThrow(() -> new IdNotFoundException("company"));

        //Convertimos el dto request 
        vacant = this.requestToVacant(request, vacant);
        vacant .setCompany(company);
        vacant.setStatus(request.getStatus());
        //Agregamos la vacante
        vacant.setCompany(company);
        //Agregamos el nuevo status
        vacant.setStatus(request.getStatus());

        return this.entityToResponse(this.vacantRepository.save(vacant));
    }

    @Override
    public void delete(Long id) {

        Vacant vacant = this.find(id);
        this.vacantRepository.delete(vacant);
    }

    @Override
    public VacantResponse getById(Long id) {

        return this.entityToResponse(this.find(id));
    }

    private VacantResponse entityToResponse(Vacant entity){
        /*Creamos instacion del dto de vacante */
        VacantResponse response = new VacantResponse();

        /*Copiar toda la entidad en el DTO */

        BeanUtils.copyProperties(entity, response);

        /*Creamos instancio del dto de compañia dentro de la vacante */

        CompanyToVacantResponse companyDto = new CompanyToVacantResponse();

        /*Copiar todas las propiedades de la compañia que se encuentra dentro de
         * la entidad (vacante) en el dto de respuesta
         */
        BeanUtils.copyProperties(entity.getCompany(), companyDto);

        /*Agrego el dto lleno a la respuesta final */
        response.setCompany(companyDto);

        return response;


    }

    private Vacant requestToVacant (VacantRequest request, Vacant entity){

        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setStatus(StatusVacant.ACTIVE);

        return entity;
    }

    private Vacant find(Long id){
        return this.vacantRepository.findById(id)
        .orElseThrow(() -> new IdNotFoundException("Vacant"));
    }
}
