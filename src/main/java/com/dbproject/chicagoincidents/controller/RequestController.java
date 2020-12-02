package com.dbproject.chicagoincidents.controller;

import com.dbproject.chicagoincidents.domain.Location;
import com.dbproject.chicagoincidents.domain.Request;
import com.dbproject.chicagoincidents.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping
    ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("/query1")
    ModelAndView query1() {
        ModelAndView modelAndView = new ModelAndView("query1");
        return modelAndView;
    }

    @PostMapping(value = "query1")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query1(@RequestParam String dayfrom, @RequestParam String dayto) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query1");
        List<Long> query1Result = requestService.getQuery1(dayfrom, dayto);
        modelAndView.addObject("requests", query1Result);
        return modelAndView;
    }

    @GetMapping("/query2")
    ModelAndView query2() {
        ModelAndView modelAndView = new ModelAndView("query2");
        return modelAndView;
    }

    @PostMapping(value = "query2")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query2(@RequestParam String dayfrom, @RequestParam String dayto, @RequestParam String type) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query2");
        List<Long> query2Result = requestService.getQuery2(dayfrom, dayto, type);
        modelAndView.addObject("requests", query2Result);
        return modelAndView;
    }

    @GetMapping("/request")
    ModelAndView request() {
        Optional<Request> dbRequest = requestService.getRequestRepository((long) 3);

        if(dbRequest.isPresent()) {
            Request existingRequest = dbRequest.get();
            ModelAndView modelAndView = new ModelAndView("request");
            modelAndView.addObject("request", existingRequest);
            return modelAndView;
        } else {
            //there is no Request in the repo with 'id'
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }


}
