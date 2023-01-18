package com.supachai.theonetest.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RandomUserResponseMapper {
    @Mapping(source = "result.gender", target = "gender")
    @Mapping(source = "seed", target = "seed")
    @Mapping(source = "result.name.title", target = "title")
    @Mapping(source = "result.name.first", target = "firstName")
    @Mapping(source = "result.name.last", target = "lastName")
    @Mapping(source = "result.email", target = "email")
    @Mapping(source = "result.phone", target = "phone")
    @Mapping(source = "result.location.street.number", target = "houseNumber")
    @Mapping(source = "result.location.street.name", target = "streetName")
    @Mapping(source = "result.location.city", target = "city")
    @Mapping(source = "result.location.state", target = "state")
    @Mapping(source = "result.location.country", target = "country")
    @Mapping(source = "result.location.postcode", target = "postCode")
    UserDto resultToUserDTO(Result result, String seed);
}