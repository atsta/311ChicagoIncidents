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
    public List<String> getQuery3(String day) {
        return requestRepository.query3(day);
    }
    public List<String> getQuery4(String dayfrom, String dayto) {
        return requestRepository.query4(dayfrom, dayto);
    }
    public List<String> getQuery5(String day, Double xlow, Double ylow, Double xhigh, Double yhigh) {
        return requestRepository.query5(day, xlow, ylow, xhigh, yhigh);
    }

    public List<Integer> getQuery6(String dayfrom, String dayto) {
        return requestRepository.query6(dayfrom, dayto);
    }

    public List<String> getQuery7() {
        return requestRepository.query7();
    }

    public List<Long> getQuery9(Integer num) {
        return requestRepository.query9(num);
    }

    public String getQuery8() {
        return requestRepository.query8();
    }

    public List<Long> getQuery10(Integer num) {
        return requestRepository.query10(num);
    }

    public List<Long> getQuery11(Integer num) {
        return requestRepository.query11(num);
    }

    public List<Integer> getQuery12() {
        return requestRepository.query12();
    }

    public Iterable<Request> getRequests(){
        return requestRepository.findAll();
    }

    public Optional<Request> getRequest(Long id) {
        this.id = id;
        return requestRepository.findById(id);
    }

    public Request addRequest(Request request) {
        requestRepository.save(request);
        return request;
    }

    public List<String> getRequestsById(){
        List<String> dbRequest = requestRepository.queryAnnotationTest1();
        return dbRequest;
    }

    public Long getNextSeriesId() {
        return requestRepository.getNextSeriesId();
    }

    public Long getNextSeriesQuantitativeId() {
        return requestRepository.getNextSeriesQuantitativeId();
    }
}
