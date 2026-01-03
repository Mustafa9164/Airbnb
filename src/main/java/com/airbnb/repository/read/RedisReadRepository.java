package com.airbnb.repository.read;

import com.airbnb.entity.readModels.AirbnbReadModel;
import com.airbnb.entity.readModels.AvailabilityReadModel;
import com.airbnb.entity.readModels.BookingReadModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;


@Repository
@RequiredArgsConstructor
public class RedisReadRepository {

    public static final String AIRBNB_KEY_PREFIX = "airbnb:";
    public static final String BOOKING_KEY_PREFIX = "booking:";
    public static final String AVAILABILITY_KEY_PREFIX = "availability:";

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public AirbnbReadModel findAirbnbById(Long id){
        String key = AIRBNB_KEY_PREFIX +id;
        String value=redisTemplate.opsForValue().get(key);

        if(value == null){
            return null;
        }

        try {
            return objectMapper.readValue(value, AirbnbReadModel.class);
        }catch (JacksonException e){
            throw new RuntimeException("Failed to deserialize AirbnbReadModel from Redis", e);
        }
    }

    public BookingReadModel findBookingById(Long id){
        String key = BOOKING_KEY_PREFIX +id;
        String value=redisTemplate.opsForValue().get(key);

        if(value == null){
            return null;
        }
        try {
            return objectMapper.readValue(value, BookingReadModel.class);
        }catch (JacksonException e){
            throw new RuntimeException("Failed to deserialize AirbnbReadModel from Redis", e);
        }
    }
    public AvailabilityReadModel findAvailiabilityById(Long id){
        String key = AVAILABILITY_KEY_PREFIX +id;
        String value=redisTemplate.opsForValue().get(key);

        if(value == null){
            return null;
        }
        try {
            return objectMapper.readValue(value, AvailabilityReadModel.class);
        }catch (JacksonException e){
            throw new RuntimeException("Failed to deserialize AirbnbReadModel from Redis", e);
        }

    }
}
