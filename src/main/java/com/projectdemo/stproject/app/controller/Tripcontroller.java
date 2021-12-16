package com.projectdemo.stproject.app.controller;

import com.projectdemo.stproject.app.entity.Trip;
import com.projectdemo.stproject.app.service.Tripservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Tripcontroller {
    @Autowired
    private Tripservice service;
    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip){
        return service.saveTrip(trip);
    }
    @PostMapping("/addTrips")
    public List<Trip> addTrips(@RequestBody List<Trip> trips){
        return service.saveTrips(trips);
    }
    @GetMapping("/trips")
    public List<Trip> findAllTrips(){
        return service.getTrips();
    }
    @GetMapping("/tripById/{id}")
    public Trip findTripById(@PathVariable int id){
        return service.getTripById(id);
    }
    @GetMapping("/trip/{name}")
    public  Trip findTripByName(@PathVariable String name){
        return service.getTripByName(name);
    }
    @PutMapping("/update")
    public Trip updateTrip(@RequestBody Trip trip){
        return service.updateTrip(trip);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTrip(@PathVariable int id){
        return service.deleteTrip(id);
    }

}
