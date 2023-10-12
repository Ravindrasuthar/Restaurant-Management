package com.ravindra.RestaurantManagement.Controller;

import com.ravindra.RestaurantManagement.Model.Admin;
import com.ravindra.RestaurantManagement.Model.FoodItem;
import com.ravindra.RestaurantManagement.Model.User;
import com.ravindra.RestaurantManagement.Model.UserOrder;
import com.ravindra.RestaurantManagement.Model.dto.FoodItemDto;
import com.ravindra.RestaurantManagement.Model.dto.SignInInputDto;
import com.ravindra.RestaurantManagement.Repo.IFoodItemRepo;
import com.ravindra.RestaurantManagement.Service.AdminService;
import com.ravindra.RestaurantManagement.Service.FoodItemService;
import com.ravindra.RestaurantManagement.Service.UserOrderService;
import com.ravindra.RestaurantManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    FoodItemService foodItemService;

    @Autowired
    UserService userService;

    @Autowired
    UserOrderService userOrderService;

    @PostMapping("admin/signup")
    public String AdminSignUp(@RequestBody Admin admin)
    {
        return adminService.AdminSignUp(admin);
    }

    @PostMapping("admin/signin")
    public String AdminSignIn(@RequestBody SignInInputDto signInInput)
    {
        return adminService.AdminSignIn(signInInput);
    }

    @PostMapping("admin/add/foodItem")
    public String AddFoodItem(@RequestBody FoodItemDto foodItemDto)
    {
        return foodItemService.AddFoodItem(foodItemDto.getSignInInputDto(),foodItemDto.getFoodItem());
    }

    @GetMapping("users")
    public List<User> GetAllUsers()
    {
        return userService.GetAllUsers();
    }

    @GetMapping("admin/food/items")
    public List<FoodItem> GetAllFoodItems()
    {
        return foodItemService.GetAllFoodItems();
    }

    @GetMapping("orders")
    public List<UserOrder> GetAllOrders()
    {
        return userOrderService.GetAllOrders();
    }

    @GetMapping("admin/order/{id}")
    public UserOrder GetOrderById(@PathVariable Integer id)
    {
        return userOrderService.GetOrderById(id);
    }
}
