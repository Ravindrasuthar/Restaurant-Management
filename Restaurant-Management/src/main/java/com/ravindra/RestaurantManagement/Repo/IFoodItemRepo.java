package com.ravindra.RestaurantManagement.Repo;

import com.ravindra.RestaurantManagement.Model.FoodItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodItemRepo extends CrudRepository<FoodItem, Integer> {
}
