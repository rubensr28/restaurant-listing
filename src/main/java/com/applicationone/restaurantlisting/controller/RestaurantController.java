package com.applicationone.restaurantlisting.controller;

import com.applicationone.restaurantlisting.dto.RestaurantDTO;
import com.applicationone.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
        List<RestaurantDTO> restaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Long id) {
        Optional<RestaurantDTO> restaurantDTO = restaurantService.fetchRestaurantById(id);
        if (restaurantDTO.isPresent())
           return new ResponseEntity<RestaurantDTO>(restaurantDTO.get(), HttpStatus.OK);
        else
            return new ResponseEntity<RestaurantDTO>(HttpStatus.NOT_FOUND);
//      functional style recommended, commented for testing
//      return restaurantDTO.map(restaurant -> new ResponseEntity<RestaurantDTO>(restaurant, HttpStatus.OK))
//          .orElse(new ResponseEntity<RestaurantDTO>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(
            @RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }

}
