package com.ravindra.RestaurantManagement.Service;

import com.ravindra.RestaurantManagement.Model.Admin;
import com.ravindra.RestaurantManagement.Model.FoodItem;
import com.ravindra.RestaurantManagement.Model.UserOrder;
import com.ravindra.RestaurantManagement.Model.dto.SignInInputDto;
import com.ravindra.RestaurantManagement.Repo.IAdminRepo;
import com.ravindra.RestaurantManagement.Repo.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    IFoodItemRepo foodItemRepo;

    @Autowired
    IAdminRepo adminRepo;

    public String AddFoodItem(SignInInputDto signInInputDto, List<FoodItem> foodItem) {

        String email = signInInputDto.getEmail();
        Admin existingAdmin = adminRepo.findFirstByAdminEmail(email);
        if(existingAdmin!=null)
        {
            String pass = signInInputDto.getPassword();
            try {
                String encryptedPass = PasswordEncryptor.encrypt(pass);
                if(existingAdmin.getAdminPassword().equals(encryptedPass))
                {
                    for(FoodItem fi : foodItem)
                    {
                        foodItemRepo.save(fi);
                    }
                    return "Food Items added !!";
                }
                else
                {
                    return "check credentials !!";
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

        }
        else {
            return "Admin not found !!";
        }
    }

    public List<FoodItem> GetAllFoodItems() {
        List<FoodItem> foodItems=  (List<FoodItem>) foodItemRepo.findAll();
//        for(FoodItem fi : foodItems)
//        {
//            UserOrder uo = fi.getUserOrder();
//            uo = null;
//        }
        return foodItems;
    }


}
