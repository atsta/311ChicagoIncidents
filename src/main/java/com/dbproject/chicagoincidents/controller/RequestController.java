package com.dbproject.chicagoincidents.controller;

import com.dbproject.chicagoincidents.domain.Request;
import com.dbproject.chicagoincidents.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping
    ModelAndView home() {
        Optional<Request> dbRequest = requestService.getRequestRepository((long) 0);

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
