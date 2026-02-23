package com.shakti.controller;


import com.shakti.entity.FoodItem;
import com.shakti.exception.InvalidIdException;
import com.shakti.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/all")
    ResponseEntity<List<FoodItem>> getAllFoodItem(){
        return ResponseEntity.ok(foodItemService.getALLFoodItem());
    }

    @GetMapping("get/{id}")
    ResponseEntity getFoodItemById(@PathVariable UUID id){
        try{
            FoodItem item=foodItemService.getFoodItemById(id);
            return new ResponseEntity<>(item,HttpStatus.OK);
        }catch (InvalidIdException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteFoodItem(@RequestBody FoodItem foodItem){
        foodItemService.deleteFoodItem(foodItem);
        return ResponseEntity.ok().build();
    }

}
