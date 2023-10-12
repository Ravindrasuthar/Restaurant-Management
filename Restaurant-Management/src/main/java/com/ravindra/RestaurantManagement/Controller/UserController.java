package com.ravindra.RestaurantManagement.Controller;

import com.ravindra.RestaurantManagement.Model.FoodItem;
import com.ravindra.RestaurantManagement.Model.User;
import com.ravindra.RestaurantManagement.Model.UserOrder;
import com.ravindra.RestaurantManagement.Model.dto.OrderDto;
import com.ravindra.RestaurantManagement.Model.dto.SignInInputDto;
import com.ravindra.RestaurantManagement.Service.FoodItemService;
import com.ravindra.RestaurantManagement.Service.UserOrderService;
import com.ravindra.RestaurantManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserOrderService userOrderService;

    @Autowired
    FoodItemService foodItemService;

    @PostMapping("user/signup")
    public String UserSignUp(@RequestBody User user)
    {
        return userService.UserSignUp(user);
    }

    @PostMapping("user/signin")
    public String UserSignIn(@RequestBody SignInInputDto signInInput)
    {
        return userService.UserSignIn(signInInput);
    }

    @PostMapping("user/place/order")
    public String UserOrder(@RequestBody OrderDto orderDto)
    {
        return userOrderService.UserOrder(orderDto.getSignInInputDto(),orderDto.getUserOrder());
    }

    @GetMapping("user/food/items")
    public List<FoodItem> GetAllFoodItems()
    {
        return foodItemService.GetAllFoodItems();
    }

    @GetMapping("user/order/{id}")
    public UserOrder GetOrderById(@PathVariable Integer id)
    {
        return userOrderService.GetOrderById(id);
    }

}
