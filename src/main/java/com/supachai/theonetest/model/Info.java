package com.supachai.theonetest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    @JsonProperty("seed")
    private String seed;

    @JsonProperty("results")
    private String results;

    @JsonProperty("page")
    private String page;

    @JsonProperty("version")
    private String version;
}
