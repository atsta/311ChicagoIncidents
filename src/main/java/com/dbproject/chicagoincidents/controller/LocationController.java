package com.dbproject.chicagoincidents.controller;

import com.dbproject.chicagoincidents.domain.Location;
import com.dbproject.chicagoincidents.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("/zipcode")
    ModelAndView zipcode() {
        ModelAndView modelAndView = new ModelAndView("zipcode");
        return modelAndView;
    }

    @PostMapping(value = "zipcode")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView zipcode(@RequestParam Integer zipcode) throws Exception {
        ModelAndView modelAndView = new ModelAndView("zipcode");
        Iterable<Location> dbLocation = locationService.getLocationsByZipcode(zipcode);
        modelAndView.addObject("requests", dbLocation);
        return modelAndView;
    }

    @GetMapping("/address")
    ModelAndView address() {
        ModelAndView modelAndView = new ModelAndView("address");
        return modelAndView;
    }

    @PostMapping(value = "address")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView address(@RequestParam String address) throws Exception {
        ModelAndView modelAndView = new ModelAndView("address");
        Iterable<Location> dbLocation = locationService.getLocationsByAddress(address);
        modelAndView.addObject("requests", dbLocation);
        return modelAndView;
    }

}
