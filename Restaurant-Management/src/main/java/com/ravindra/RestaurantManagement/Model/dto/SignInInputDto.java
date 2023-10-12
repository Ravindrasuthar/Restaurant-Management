package com.ravindra.RestaurantManagement.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInputDto {

    private String email;
    private String password;
}
