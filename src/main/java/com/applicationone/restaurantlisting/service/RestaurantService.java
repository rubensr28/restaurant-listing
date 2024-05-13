package com.applicationone.restaurantlisting.service;

import com.applicationone.restaurantlisting.dto.RestaurantDTO;
import com.applicationone.restaurantlisting.entity.Restaurant;
import com.applicationone.restaurantlisting.mapper.RestaurantMapper;
import com.applicationone.restaurantlisting.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepo;
    RestaurantMapper mapper = RestaurantMapper.INSTANCE;

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList = restaurants.stream().map(
                restaurant ->
                        mapper.mapRestaurantToRestaurantDTO(restaurant))
                .collect(Collectors.toList());
        return restaurantDTOList;
    }
}
