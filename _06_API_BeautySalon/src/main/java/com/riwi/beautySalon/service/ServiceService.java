package com.riwi.beautySalon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.beautySalon.api.dto.request.ServiceReq;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.domain.repositories.ServiceRepository;
import com.riwi.beautySalon.infrastructure.abstract_services.IServiceService;
import com.riwi.beautySalon.utils.enums.SortType;


import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor

public class ServiceService implements IServiceService {

    @Autowired
    private final ServiceRepository serviceRepository;

    @Override
    public ServiceResp create(ServiceReq request) {

        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ServiceResp get(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ServiceResp update(ServiceReq request, Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<ServiceResp> getAll(int page, int size, SortType SortType) {

        if (page < 0) page = 0;

        PageRequest pagination = null;
        
        switch (SortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        this.serviceRepository.findAll(pagination);

        return null;
    }

    @Override
    public List<ServiceResp> search(String name) {

        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}