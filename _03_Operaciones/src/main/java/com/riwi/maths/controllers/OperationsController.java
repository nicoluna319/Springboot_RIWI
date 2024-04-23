package com.riwi.maths.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.maths.entities.Operations;





@RestController
@RequestMapping("/api/v1/operations")
public class OperationsController {

    @PostMapping(path = "/add")
    public String add(@RequestBody Operations objOperations){

        String message = String.valueOf( objOperations.getNum1() + objOperations.getNum2()
        );
        return objOperations.getNum1() + "+" + objOperations.getNum2() + "=" + message;
    }

    @PostMapping(path = "/resta")
    public String resta(@RequestBody Operations objOperationsresta){

        String message = String.valueOf( objOperationsresta.getNum1() - objOperationsresta.getNum2()
        );
        return objOperationsresta.getNum1() + "+" + objOperationsresta.getNum2() + "=" + message;
    }
}
