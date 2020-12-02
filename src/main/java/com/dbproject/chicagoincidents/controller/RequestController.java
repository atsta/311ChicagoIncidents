package com.dbproject.chicagoincidents.controller;

import com.dbproject.chicagoincidents.domain.Request;
import com.dbproject.chicagoincidents.repository.RequestRepository;
import com.dbproject.chicagoincidents.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
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

    /*
    ModelAndView home() {
        List<String> dbRequest = requestService.getRequestsById();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("requests", dbRequest);
        return modelAndView;
    }*/

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
