package com.alex.example.model.validation;

import com.alex.example.model.Car;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarValidator implements ConstraintValidator<CarConstraint, Car> {

    @Override
    public void initialize(CarConstraint constraintAnnotation) {
        // Access constraint properties: message, payload, groups or custom ones
    }

    @Override
    public boolean isValid(Car car, ConstraintValidatorContext constraintValidatorContext) {
        if (car == null) {
            return true;
        }

        return false;
    }
}
