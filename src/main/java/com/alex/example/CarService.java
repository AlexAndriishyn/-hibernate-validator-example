package com.alex.example;

import com.alex.example.model.Car;
import com.alex.example.model.Engine;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by alex.
 */
@Service
public class CarService {

    private final CarRepository carRepository;
    private final ValidatorFactory validatorFactory;

    @Inject
    public CarService(
        CarRepository carRepository,
        ValidatorFactory validatorFactory
    ) {
        this.carRepository = carRepository;
        this.validatorFactory = validatorFactory;
    }

    public Car createCar() {
        Car car = new Car();

        car.setManufacturer("alex");
        car.setSeatCount(1);
        car.setLicensePlate("iscool");
        car.setEngine(new Engine());

        validate(car);

        return carRepository.save(car);
    }

    private void validate(Car car) {
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        System.out.println(constraintViolations);
    }
}
