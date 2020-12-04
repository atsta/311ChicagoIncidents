package com.dbproject.chicagoincidents.repository;

import com.dbproject.chicagoincidents.domain.Location;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    Iterable<Location> findByZipcodes(Integer zipcodes);
    Iterable<Location> findByAddress(String address);
}
