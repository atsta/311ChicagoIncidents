package com.dbproject.chicagoincidents.service;

import com.dbproject.chicagoincidents.domain.Location;
import com.dbproject.chicagoincidents.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Iterable<Location> getLocationsByZipcode(Integer zipcodes){
        Iterable<Location> dblocations = locationRepository.findByZipcodes(zipcodes);
        return dblocations;
    }

    public Iterable<Location> getLocationsByAddress(String address){
        Iterable<Location> dblocations = locationRepository.findByAddress(address);
        return dblocations;
    }
}
