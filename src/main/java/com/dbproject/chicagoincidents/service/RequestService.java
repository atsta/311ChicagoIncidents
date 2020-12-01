package com.dbproject.chicagoincidents.service;

import com.dbproject.chicagoincidents.domain.Request;
import com.dbproject.chicagoincidents.repository.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public Request addRequest(Request request) {
        requestRepository.save(request);
        return request;
    }

    public Iterable<Request> getRequests(){
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestRepository(Long id) {
        return requestRepository.findById(id);
    }

    public List<String> getRequestsById(){
        List<String> dbRequest = requestRepository.queryAnnotationTest1();
        return dbRequest;
    }

}
