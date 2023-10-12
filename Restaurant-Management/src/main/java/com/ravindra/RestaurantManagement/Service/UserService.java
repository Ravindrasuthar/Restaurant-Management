package com.ravindra.RestaurantManagement.Service;

import com.ravindra.RestaurantManagement.Model.User;
import com.ravindra.RestaurantManagement.Model.UserOrder;
import com.ravindra.RestaurantManagement.Model.dto.SignInInputDto;
import com.ravindra.RestaurantManagement.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    public String UserSignUp(User user) {
        String userEmail = user.getUserEmail();
        User existingUser = userRepo.findFirstByUserEmail(userEmail);

        if(existingUser!=null)
        {
            return "User already exist please try sign in !!";
        }

        String password = user.getUserPassword();

        try {

            String encryptedPassword = PasswordEncryptor.encrypt(password);
            user.setUserPassword(encryptedPassword);
            userRepo.save(user);
            return "User registered !!";

        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later !!";
        }
    }

    public String UserSignIn(SignInInputDto signInInput) {

        String email = signInInput.getEmail();
        User existingUser = userRepo.findFirstByUserEmail(email);
        if(existingUser==null)
        {
            return "Not a valid email, Please sign up first !!";
        }
        String pass = signInInput.getPassword();

        try {
            String encryptedPass = PasswordEncryptor.encrypt(pass);
            if(existingUser.getUserPassword().equals(encryptedPass))
            {
                return "User sign in successful !!";
            }
            else {
                return "Invalid Credentials !!";
            }
        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later !!";
        }
    }

    public List<User> GetAllUsers() {
        return (List<User>) userRepo.findAll();
    }
}
