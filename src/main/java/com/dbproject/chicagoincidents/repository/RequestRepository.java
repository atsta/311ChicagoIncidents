package com.dbproject.chicagoincidents.repository;

import com.dbproject.chicagoincidents.domain.Request;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long>{
}

