package com.supachai.theonetest.controller;

import com.supachai.theonetest.model.UserDto;
import com.supachai.theonetest.service.RandomUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomUserController {
    private RandomUserService service;

    public RandomUserController(RandomUserService service){
        this.service = service;
    }

    @GetMapping("/get-user")
    public ResponseEntity<UserDto> getRandomUser(@RequestParam(required = false) String seed) {
        return new ResponseEntity<>(service.findBySeed(seed), HttpStatus.OK);
    }

}
