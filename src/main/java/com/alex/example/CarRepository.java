package com.alex.example;

import com.alex.example.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by alex.
 */
@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Integer> {

}
