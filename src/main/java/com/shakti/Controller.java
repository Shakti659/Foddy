package com.shakti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    FoodItemRepository repository;

    @GetMapping("/hello")
    String hello(){
        return "Hello World";
    }

    @GetMapping("/add")
    void add(){
        FoodItem foodItem=new FoodItem();
        foodItem.itemName="Food Item-1";
        foodItem.quantity=1;
        foodItem.price=190;

        repository.save(foodItem);
    }
}
