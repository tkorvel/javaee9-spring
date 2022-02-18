package com.sda.javaee9spring.homework.solution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record Car(Wheel rightFront,
                  Wheel leftFront,
                  Wheel rightRear,
                  Wheel leftRear,
                  CarBody carBody,
                  Engine engine) {
//    public Car(Wheel rightFront, Wheel leftFront, Wheel rightRear, Wheel leftRear, CarBody carBody, Engine engine) {
//        this.rightFront = rightFront;
//        this.leftFront = leftFront;
//        this.rightRear = rightRear;
//        this.leftRear = leftRear;
//        this.carBody = carBody;
//        this.engine = engine;
//
//        log.info("Car was created");
//    }

    public Car {
        log.info("Car was created");
    }
}
