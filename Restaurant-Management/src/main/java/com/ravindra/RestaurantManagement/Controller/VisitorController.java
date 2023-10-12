package com.ravindra.RestaurantManagement.Controller;


import com.ravindra.RestaurantManagement.Model.FoodItem;
import com.ravindra.RestaurantManagement.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    FoodItemService foodItemService;

    @GetMapping("visitor/food/items")
    public List<FoodItem> GetAllFoodItems()
    {
        return foodItemService.GetAllFoodItems();
    }
}
