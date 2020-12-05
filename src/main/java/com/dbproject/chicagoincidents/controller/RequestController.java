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
import java.util.*;

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
        List<String> query1Result = requestService.getQuery1(dayfrom, dayto);
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
        List<String> query2Result = requestService.getQuery2(dayfrom, dayto, type);
        modelAndView.addObject("requests", query2Result);
        return modelAndView;
    }

    @GetMapping("/query3")
    ModelAndView query3() {
        ModelAndView modelAndView = new ModelAndView("query3");
        return modelAndView;
    }

    @PostMapping(value = "query3")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query3(@RequestParam String day) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query3");
        List<String> query3Result = requestService.getQuery3(day);
        modelAndView.addObject("items", query3Result);
        return modelAndView;
    }

    @GetMapping("/query4")
    ModelAndView query4() {
        ModelAndView modelAndView = new ModelAndView("query4_6");
        return modelAndView;
    }

    @PostMapping(value = "query4")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query4(@RequestParam String dayfrom, @RequestParam String dayto) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query4_6");
        List<String> query4Result = requestService.getQuery4(dayfrom, dayto);
        modelAndView.addObject("items", query4Result);
        return modelAndView;
    }

    @GetMapping("/query5")
    ModelAndView query5() {
        ModelAndView modelAndView = new ModelAndView("query5");
        return modelAndView;
    }

    @PostMapping(value = "query5")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query5(@RequestParam String day, @RequestParam Double xlow, @RequestParam Double xhigh, @RequestParam Double ylow, @RequestParam Double yhigh ) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query5");
        List<String> query5Result = requestService.getQuery5(day, xlow, ylow, xhigh, yhigh);
        modelAndView.addObject("items", query5Result);
        return modelAndView;
    }

    @GetMapping("/query6")
    ModelAndView query6() {
        ModelAndView modelAndView = new ModelAndView("query4_6");
        return modelAndView;
    }

    @PostMapping(value = "query6")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView query6(@RequestParam String dayfrom, @RequestParam String dayto) throws Exception {
        ModelAndView modelAndView = new ModelAndView("query4_6");
        List<Integer> query6Result = requestService.getQuery6(dayfrom, dayto);
        modelAndView.addObject("items", query6Result);
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

            Activities act = new Activities();
            act.setRequest(request);
            act.setCurrentactivity(null);
            act.setMostrecentaction(null);
            request.setActivities(act);
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

            Quantitative quantitative = new Quantitative();
            quantitative.setQuantitativeid(requestService.getNextSeriesQuantitativeId());
            quantitative.setRequest(request);
            quantitative.setQuantitytype(quantity_type);
            quantitative.setQuantity(quantity);
            request.getQuantitative().add(quantitative);

            Activities act = new Activities();
            act.setRequest(request);
            act.setCurrentactivity(null);
            act.setMostrecentaction(null);
            request.setActivities(act);
            requestService.addRequest(request);
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add incident: " + ex.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/rodent")
    ModelAndView rodent() {
        ModelAndView modelAndView = new ModelAndView("rodent");
        return modelAndView;
    }

    @PostMapping(value = "rodent")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView rodent(@RequestParam Double rats,
                        @RequestParam Double garbage,
                        @RequestParam Double baited,
                        @RequestParam String address,
                          @RequestParam Integer zipcode,
                          @RequestParam Double x_coord,
                          @RequestParam Double y_coord,
                          @RequestParam Double lat,
                          @RequestParam Double longit) throws Exception {
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
            request.setType("Rodent Baiting/Rat Complaint");
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

            Quantitative rat = new Quantitative();
            rat.setQuantitativeid(requestService.getNextSeriesQuantitativeId());
            rat.setRequest(request);
            rat.setQuantitytype("Number of Premises with Rats");
            rat.setQuantity(rats);
            request.getQuantitative().add(rat);

            Quantitative qgarbage = new Quantitative();
            qgarbage.setQuantitativeid(requestService.getNextSeriesQuantitativeId());
            qgarbage.setRequest(request);
            qgarbage.setQuantitytype("Number of Premises with Garbage");
            qgarbage.setQuantity(garbage);
            request.getQuantitative().add(qgarbage);

            Quantitative bait = new Quantitative();
            bait.setQuantitativeid(requestService.getNextSeriesQuantitativeId());
            bait.setRequest(request);
            bait.setQuantitytype("Number of Premises Baited");
            bait.setQuantity(baited);
            request.getQuantitative().add(bait);

            Activities act = new Activities();
            act.setRequest(request);
            act.setCurrentactivity(null);
            act.setMostrecentaction(null);
            request.setActivities(act);
            requestService.addRequest(request);
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add incident: " + ex.getMessage());
        }
        return modelAndView;
    }


    @GetMapping("/light")
    ModelAndView light() {
        ModelAndView modelAndView = new ModelAndView("light");
        return modelAndView;
    }

    @PostMapping(value = "light")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView light(@RequestParam String comp_type,
                       @RequestParam String address,
                        @RequestParam Integer zipcode,
                        @RequestParam Double x_coord,
                        @RequestParam Double y_coord,
                        @RequestParam Double lat,
                        @RequestParam Double longit) throws Exception {
        ModelAndView modelAndView = new ModelAndView("light");
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
            request.setType(comp_type);
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
            request.setLocation(location);
            requestService.addRequest(request);
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add incident: " + ex.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/tree")
    ModelAndView tree() {
        ModelAndView modelAndView = new ModelAndView("tree");
        return modelAndView;
    }

    @PostMapping(value = "tree")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView tree(@RequestParam String comp_type,
                      @RequestParam String loc,
                      @RequestParam String address,
                       @RequestParam Integer zipcode,
                       @RequestParam Double x_coord,
                       @RequestParam Double y_coord,
                       @RequestParam Double lat,
                       @RequestParam Double longit) throws Exception {
        ModelAndView modelAndView = new ModelAndView("tree");
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
            request.setType(comp_type);
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
            request.setLocation(location);

            RelativeLocation rloc = new RelativeLocation();
            rloc.setRequest(request);
            rloc.setRelativelocation(loc);
            request.setRelativeLocation(rloc);

            Activities act = new Activities();
            act.setRequest(request);
            act.setCurrentactivity(null);
            act.setMostrecentaction(null);
            request.setActivities(act);
            requestService.addRequest(request);
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add incident: " + ex.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/graffiti")
    ModelAndView graffiti() {
        ModelAndView modelAndView = new ModelAndView("graffiti");
        return modelAndView;
    }

    @PostMapping(value = "graffiti")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView graffiti(@RequestParam String sur,
                      @RequestParam String loc,
                      @RequestParam String address,
                      @RequestParam Integer zipcode,
                      @RequestParam Double x_coord,
                      @RequestParam Double y_coord,
                      @RequestParam Double lat,
                      @RequestParam Double longit) throws Exception {
        ModelAndView modelAndView = new ModelAndView("graffiti");
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
            request.setType("Graffiti Removal");
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
            request.setLocation(location);

            RelativeLocation rloc = new RelativeLocation();
            rloc.setRequest(request);
            rloc.setRelativelocation(loc);
            request.setRelativeLocation(rloc);

            Specification surface = new Specification();
            surface.setRequest(request);
            surface.setSpecification(sur);
            request.setSpecification(surface);
            requestService.addRequest(request);
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add incident: " + ex.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/sanitation")
    ModelAndView sanitation() {
        ModelAndView modelAndView = new ModelAndView("sanitation");
        return modelAndView;
    }

    @PostMapping(value = "sanitation")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView sanitation(@RequestParam String nat,
                          @RequestParam String address,
                          @RequestParam Integer zipcode,
                          @RequestParam Double x_coord,
                          @RequestParam Double y_coord,
                          @RequestParam Double lat,
                          @RequestParam Double longit) throws Exception {
        ModelAndView modelAndView = new ModelAndView("sanitation");
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
            request.setType("Sanitation Code Violation");
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
            request.setLocation(location);

            Specification nature = new Specification();
            nature.setRequest(request);
            nature.setSpecification(nat);
            request.setSpecification(nature);
            requestService.addRequest(request);
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add incident: " + ex.getMessage());
        }
        return modelAndView;
    }
}
