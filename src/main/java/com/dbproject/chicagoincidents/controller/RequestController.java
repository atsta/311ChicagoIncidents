package com.dbproject.chicagoincidents.controller;

import com.dbproject.chicagoincidents.domain.*;
import com.dbproject.chicagoincidents.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

    @GetMapping("/query7")
    ModelAndView query7() {
        ModelAndView modelAndView = new ModelAndView("query6_7_8_12");
        List<String> query7Result = requestService.getQuery7();
        modelAndView.addObject("items", query7Result);
        return modelAndView;
    }

    @GetMapping("/query8")
    ModelAndView query8() {
        ModelAndView modelAndView = new ModelAndView("query6_7_8_12");
        String query8Result = requestService.getQuery8();
        modelAndView.addObject("items", query8Result);
        return modelAndView;
    }

    @GetMapping("/query9")
    ModelAndView query9() {
        ModelAndView modelAndView = new ModelAndView("query9_10_11");
        return modelAndView;
    }

    @PostMapping(value = "query9")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query9(@RequestParam Integer num) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query9_10_11");
        List<Long> query9Result = requestService.getQuery9(num);
        modelAndView.addObject("requests", query9Result);
        return modelAndView;
    }

    @GetMapping("/query10")
    ModelAndView query10() {
        ModelAndView modelAndView = new ModelAndView("query9_10_11");
        return modelAndView;
    }

    @PostMapping(value = "query10")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query10(@RequestParam Integer num) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query9_10_11");
        List<Long> query10Result = requestService.getQuery10(num);
        modelAndView.addObject("requests", query10Result);
        return modelAndView;
    }

    @GetMapping("/query11")
    ModelAndView query11() {
        ModelAndView modelAndView = new ModelAndView("query9_10_11");
        return modelAndView;
    }

    @PostMapping(value = "query11")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query11(@RequestParam Integer num) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query9_10_11");
        List<Long> query11Result = requestService.getQuery11(num);
        modelAndView.addObject("requests", query11Result);
        return modelAndView;
    }

    @GetMapping("/query12")
    ModelAndView query12() {
        ModelAndView modelAndView = new ModelAndView("query6_7_8_12");
        List<Integer> query12Result = requestService.getQuery12();
        modelAndView.addObject("items", query12Result);
        return modelAndView;
    }

    @GetMapping("/vehicle")
    ModelAndView vehicle() {
        ModelAndView modelAndView = new ModelAndView("vehicle");
        return modelAndView;
    }

    @PostMapping(value = "vehicle")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView addVehicleRequest(@RequestParam String lic_plate,
                                    @RequestParam String maker,
                                    @RequestParam String color,
                                    @RequestParam Double days_abandoned,
                                    @RequestParam String address,
                                    @RequestParam Integer zipcode,
                                    @RequestParam Double x_coord,
                                    @RequestParam Double y_coord,
                                    @RequestParam Double lat,
                                    @RequestParam Double longit,
                                    @RequestParam Integer ssa) throws Exception {
        ModelAndView modelAndView = new ModelAndView("vehicle");
        try {
            Request request = new Request();
            request.setID(requestService.getNextSeriesId());
            request.setSrn();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd");
            Date date= formatter.parse(formatter.format(new Date()));
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            request.setCreationdate(ts);
            request.setType("Abandoned Vehicle Complaint");
            request.setStatus("Open");
            requestService.addRequest(request);

            Location location = new Location();
            location.setRequest(request);
            location.setAddress(address);
            location.setZipcodes(zipcode);
            location.setLatitude(lat);
            location.setLongitude(longit);
            location.setXcoordinate(x_coord);
            location.setYcoordinate(y_coord);
            request.setLocation(location);;

            HasSSA hasSSA = new HasSSA();
            hasSSA.setRequest(request);
            hasSSA.setSsavalue(ssa);
            request.setHasSSA(hasSSA);

            Vehicle vehicle = new Vehicle();
            vehicle.setRequest(request);
            vehicle.setDaysabandoned(days_abandoned);
            vehicle.setModel(maker);
            vehicle.setColor(color);
            vehicle.setLicenseplate(lic_plate);
            request.setVehicle(vehicle);
            requestService.addRequest(request);

        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add incident: " + ex.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/quantitative")
    ModelAndView quantitative() {
        ModelAndView modelAndView = new ModelAndView("quantitative");
        return modelAndView;
    }

    @PostMapping(value = "quantitative")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView quantitative(@RequestParam String quantity_type,
                              @RequestParam Double quantity,
                              @RequestParam String address,
                               @RequestParam Integer zipcode,
                               @RequestParam Double x_coord,
                               @RequestParam Double y_coord,
                               @RequestParam Double lat,
                               @RequestParam Double longit,
                               @RequestParam Integer ssa) throws Exception {
        ModelAndView modelAndView = new ModelAndView("quantitative");
        try {
            Request request = new Request();
            request.setID(requestService.getNextSeriesId());
            request.setSrn();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy-MM-dd");
            Date date= formatter.parse(formatter.format(new Date()));
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            request.setCreationdate(ts);
            switch (quantity_type) {
                case "Potholes filled on block":
                    request.setType("Pothole in Street");
                    break;
                case "Number of Black Carts Delivered":
                    request.setType("Garbage Cart Black Maintenance/Replacement");
                    break;
            }
            request.setStatus("Open");
            requestService.addRequest(request);

            Location location = new Location();
            location.setRequest(request);
            location.setAddress(address);
            location.setZipcodes(zipcode);
            location.setLatitude(lat);
            location.setLongitude(longit);
            location.setXcoordinate(x_coord);
            location.setYcoordinate(y_coord);
            request.setLocation(location);;

            HasSSA hasSSA = new HasSSA();
            hasSSA.setRequest(request);
            hasSSA.setSsavalue(ssa);
            request.setHasSSA(hasSSA);

            requestService.addRequest(request);

            Quantitative quantitative = new Quantitative();
            quantitative.setQuantitativeid(requestService.getNextSeriesQuantitativeId());
            quantitative.setRequest(request);
            quantitative.setQuantitytype(quantity_type);
            quantitative.setQuantity(quantity);
            request.getQuantitative().add(quantitative);

            requestService.addRequest(request);
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add incident: " + ex.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/request")
    ModelAndView request() {
        Optional<Request> dbRequest = requestService.getRequest((long) 3);

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
