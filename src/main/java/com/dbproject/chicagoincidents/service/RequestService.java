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
    private Long id;

    public List<Long> getQuery1(String dayfrom, String dayto) {
        return requestRepository.query1(dayfrom, dayto);
    }

    public List<Long> getQuery2(String dayfrom, String dayto, String type) {
        return requestRepository.query2(dayfrom, dayto, type);
    }

    public List<Long> getQuery9(Integer num) {
        return requestRepository.query9(num);
    }

    public List<Long> getQuery10(Integer num) {
        return requestRepository.query10(num);
    }

    public List<Long> getQuery11(Integer num) {
        return requestRepository.query11(num);
    }

    public Request addRequest(Request request) {
        requestRepository.save(request);
        return request;
    }

    public Iterable<Request> getRequests(){
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestRepository(Long id) {
        this.id = id;
        return requestRepository.findById(id);
    }

    public List<String> getRequestsById(){
        List<String> dbRequest = requestRepository.queryAnnotationTest1();
        return dbRequest;
    }

}
