package org.edu.miu.cs.cs425.carrentalbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping
    public String Hello() {
        return "Hello";
    }
}
