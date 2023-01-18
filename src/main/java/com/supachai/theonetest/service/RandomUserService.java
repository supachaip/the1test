package com.supachai.theonetest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supachai.theonetest.repository.UserRepository;
import com.supachai.theonetest.model.RandomUserResponse;
import com.supachai.theonetest.model.RandomUserResponseMapper;
import com.supachai.theonetest.model.Result;
import com.supachai.theonetest.model.UserDto;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RandomUserService {
    private final RestTemplate restTemplate;
    private UserRepository userRepository;

    public RandomUserService(RestTemplate restTemplate, UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }

    public UserDto findBySeed(String seed) {
        RandomUserResponse response;
        //Query redis cache first
        String jsonResponse = userRepository.getResponse(seed);
        UserDto userDto;
        if (jsonResponse == null) { // if cache not found
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://randomuser.me/api/")
                    .queryParam("seed", seed);
            jsonResponse = restTemplate.getForObject(builder.toUriString(), String.class);
            //save response cache to redis
            userRepository.saveResponseCache(seed, jsonResponse, 10);
        }
        //Convert JSON Response to POJO
        ObjectMapper objMapper = new ObjectMapper();
        try {
            response = objMapper.readValue(jsonResponse, RandomUserResponse.class);
            seed = response.getInfo().getSeed();
            userRepository.saveResponseCache(seed, jsonResponse, 10);
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Response model not match");
        }

        //Mapping to user dto by using map struct
        if (!response.getResult().isEmpty()) {
            Result result = response.getResult().get(0);
            RandomUserResponseMapper mapper = Mappers.getMapper(RandomUserResponseMapper.class);
            userDto = mapper.resultToUserDTO(result, seed);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "seed not found");
        }

        return userDto;
    }
}
