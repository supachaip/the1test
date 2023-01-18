package com.supachai.theonetest.model;

import lombok.Data;
@Data
public class UserDto {

    private String seed;

    private String title;
    private String firstName;
    private String lastName;
    private String gender;

    private String houseNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String postCode;

    private String email;
    private String phone;
}
