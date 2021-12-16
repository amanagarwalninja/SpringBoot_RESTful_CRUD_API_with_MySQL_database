package com.projectdemo.stproject.app.repository;

import com.projectdemo.stproject.app.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Triprepository extends JpaRepository<Trip,Integer> {

    Trip findByName(String name);
}
