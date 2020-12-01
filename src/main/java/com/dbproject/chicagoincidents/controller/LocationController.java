package com.dbproject.chicagoincidents.controller;

import com.dbproject.chicagoincidents.domain.Location;
import com.dbproject.chicagoincidents.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("/zipcode")
    ModelAndView zipcode() {
        Iterable<Location> dbLocation = locationService.getLocationsByZipcode(60613);
        ModelAndView modelAndView = new ModelAndView("location");
        modelAndView.addObject("requests", dbLocation);
        return modelAndView;
    }

    @GetMapping("/address")
    ModelAndView address() {
        Iterable<Location> dbLocation = locationService.getLocationsByAddress("628 W ADDISON ST");
        ModelAndView modelAndView = new ModelAndView("location");
        modelAndView.addObject("requests", dbLocation);
        return modelAndView;
    }
}
