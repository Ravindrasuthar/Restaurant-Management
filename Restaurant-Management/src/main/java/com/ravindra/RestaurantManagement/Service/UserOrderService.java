package com.ravindra.RestaurantManagement.Service;

import com.ravindra.RestaurantManagement.Model.User;
import com.ravindra.RestaurantManagement.Model.UserOrder;
import com.ravindra.RestaurantManagement.Model.dto.SignInInputDto;
import com.ravindra.RestaurantManagement.Repo.IUserOrderRepo;
import com.ravindra.RestaurantManagement.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserOrderService {

    @Autowired
    IUserOrderRepo userOrderRepo;

    @Autowired
    IUserRepo userRepo;

    public String UserOrder(SignInInputDto signInInputDto, UserOrder userOrder) {

        String email = signInInputDto.getEmail();
        User existingUser = userRepo.findFirstByUserEmail(email);
        if(existingUser!=null)
        {
            String pass = signInInputDto.getPassword();
            try {
                String encryptedPass = PasswordEncryptor.encrypt(pass);
                if(existingUser.getUserPassword().equals(encryptedPass))
                {
                    userOrder.setUser(existingUser);
                    userOrderRepo.save(userOrder);
                    return "Order Placed !!";
                }
                else
                {
                    return "check credentials !!";
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            return "User not found !!";
        }
    }

    public List<UserOrder> GetAllOrders() {
        return (List<UserOrder>) userOrderRepo.findAll();
    }

    public UserOrder GetOrderById(Integer id) {
        return userOrderRepo.findById(id).orElseThrow();
    }
}
