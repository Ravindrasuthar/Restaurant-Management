package com.ravindra.RestaurantManagement.Service;

import com.ravindra.RestaurantManagement.Model.Admin;
import com.ravindra.RestaurantManagement.Model.dto.SignInInputDto;
import com.ravindra.RestaurantManagement.Repo.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {

    @Autowired
    IAdminRepo adminRepo;

    public String AdminSignUp(Admin admin){

        String adminEmail = admin.getAdminEmail();
        Admin existingAdmin = adminRepo.findFirstByAdminEmail(adminEmail);

        if(existingAdmin!=null)
        {
           return "Admin already exist please try sign in !!";
        }

        String password = admin.getAdminPassword();

        try {

            String encryptedPassword = PasswordEncryptor.encrypt(password);
            admin.setAdminPassword(encryptedPassword);
            adminRepo.save(admin);
            return "Admin registered !!";

        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later !!";
        }

    }


    public String AdminSignIn(SignInInputDto signInInput) {

        String email = signInInput.getEmail();
        Admin existingAdmin = adminRepo.findFirstByAdminEmail(email);
        if(existingAdmin==null)
        {
            return "Not a valid email, Please sign up first !!";
        }
        String pass = signInInput.getPassword();

        try {
            String encryptedPass = PasswordEncryptor.encrypt(pass);
            if(existingAdmin.getAdminPassword().equals(encryptedPass))
            {
                return "Admin sign in successful !!";
            }
            else {
                return "Invalid Credentials !!";
            }
        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later !!";
        }

    }
}
