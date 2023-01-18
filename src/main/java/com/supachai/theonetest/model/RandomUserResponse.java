package com.supachai.theonetest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomUserResponse {
    @JsonProperty("results")
    private List<Result> result;

    @JsonProperty("info")
    private Info info;
}

