package com.shakti.controller;


import com.shakti.entity.FoodItem;
import com.shakti.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/food-item")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;



    @PostMapping("/add")
   ResponseEntity<UUID>  addFoodItem(@RequestBody FoodItem foodItem){
        UUID id=foodItemService.save(foodItem);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
