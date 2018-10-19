package com.alex.example;

import com.alex.example.model.Car;
import com.alex.example.model.CarRepository;
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
//    private final ValidatorFactory validatorFactory;
    private final Validator validator;

    @Inject
    public CarService(
        CarRepository carRepository,
//        ValidatorFactory validatorFactory,
        Validator validator
    ) {
        this.carRepository = carRepository;
//        this.validatorFactory = validatorFactory;
        this.validator = validator;
    }

    public Car createCar(Car car) {
        validate(car);

        return carRepository.save(car);
    }

    private void validate(Car car) {
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        for (ConstraintViolation<Car> constraintViolation: constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}
