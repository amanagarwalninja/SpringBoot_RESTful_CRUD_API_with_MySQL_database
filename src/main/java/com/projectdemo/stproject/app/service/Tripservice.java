package com.projectdemo.stproject.app.service;

import com.projectdemo.stproject.app.entity.Trip;
import com.projectdemo.stproject.app.repository.Triprepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tripservice {
    @Autowired
    private Triprepository repository;

    public Trip saveTrip(Trip trip) {
        return repository.save(trip);
    }
    public List <Trip> saveTrips(List<Trip>trips){
        return repository.saveAll(trips);
    }
    public List<Trip> getTrips(){
        return repository.findAll();
    }
    public Trip getTripById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Trip getTripByName(String name) {
        return repository.findByName(name);
    }
    public String deleteTrip(int id){
        repository.deleteById(id);
        return "trip deleted !!" + id;
    }
    public Trip updateTrip(Trip trip){
//        based on the incoming trip object we are first fetching the existing trip object available in db then we are using existingproduct to update
        Trip existingTrip=repository.findById(trip.getId()).orElse(null);
        existingTrip.setName(trip.getName());
        existingTrip.setQuantity(trip.getQuantity());
        existingTrip.setPrice(trip.getPrice());
        return repository.save(existingTrip);
    }
}

