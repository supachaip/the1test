package com.supachai.theonetest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    @JsonProperty("gender")
    private String gender;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("email")
    private String email;

    @JsonProperty("login")
    private Map<String, Object> login = new HashMap<>();

    @JsonProperty("dob")
    private Map<String, Object> dob = new HashMap<>();

    @JsonProperty("registered")
    private Map<String, Object> registered = new HashMap<>();

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("cell")
    private String cell;

    @JsonProperty("id")
    private Map<String, Object> id = new HashMap<>();

    @JsonProperty("picture")
    private Map<String, Object> picture = new HashMap<>();

    @JsonProperty("nat")
    private String nat;

}
