package com.supachai.theonetest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Street {
    @JsonProperty("number")
    private String number;

    @JsonProperty("name")
    private String name;

    @JsonProperty("coordinates")
    private Map<String, Object> coordinates = new HashMap<>();

    @JsonProperty("timezone")
    private Map<String, Object> timezone = new HashMap<>();

}
