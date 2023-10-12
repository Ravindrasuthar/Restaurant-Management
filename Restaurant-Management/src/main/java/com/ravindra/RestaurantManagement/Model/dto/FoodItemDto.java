package com.ravindra.RestaurantManagement.Model.dto;

import com.ravindra.RestaurantManagement.Model.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto {

    private SignInInputDto signInInputDto;
    private List<FoodItem> foodItem;
}
