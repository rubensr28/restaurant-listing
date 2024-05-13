package com.applicationone.restaurantlisting.mapper;

import com.applicationone.restaurantlisting.dto.RestaurantDTO;
import com.applicationone.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    Restaurant mapRestaurantDTOtoRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
