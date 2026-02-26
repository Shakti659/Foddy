package com.shakti.service;

import com.shakti.exception.InvalidIdException;
import com.shakti.repository.FoodItemRepository;
import com.shakti.entity.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class FoodItemService {

    @Autowired
    FoodItemRepository repository;

    public UUID save(FoodItem foodItem) {
        foodItem.setCreatDate(LocalDate.now());
        FoodItem savedItem=repository.save(foodItem);
        return savedItem.getId();
    }

   public List<FoodItem> getALLFoodItem() {
        return repository.findAll();
    }

    public FoodItem updateFoodItem(FoodItem foodItem) throws InvalidIdException{
        FoodItem item =getFoodItemById(foodItem.getId());
        foodItem.setUpdateDate(LocalDate.now());
        repository.save(foodItem);
        return foodItem;
    }

    public FoodItem getFoodItemById(UUID id) throws InvalidIdException {

        FoodItem foodItem = repository.findById(id)
                .orElseThrow(() -> new InvalidIdException("Invalid Id " + id));

        return foodItem;
    }
    public void deleteFoodItem(FoodItem foodItem){
        repository.delete(foodItem);
    }
}
