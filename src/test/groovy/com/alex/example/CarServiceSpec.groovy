package com.alex.example

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.inject.Inject

/**
 * Created by alex.
 */
@SpringBootTest
class CarServiceSpec extends Specification {

    @Inject CarService carService
    @Inject CarRepository carRepository

    def 'validate'() {
        expect:
        carService.createCar()
    }
}
