package com.supachai.theonetest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    @JsonProperty("title")
    private String title;

    @JsonProperty("first")
    private String first;

    @JsonProperty("last")
    private String last;
}
