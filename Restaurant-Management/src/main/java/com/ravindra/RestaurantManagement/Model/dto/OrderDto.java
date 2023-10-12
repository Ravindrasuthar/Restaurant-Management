package com.ravindra.RestaurantManagement.Model.dto;

import com.ravindra.RestaurantManagement.Model.UserOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private SignInInputDto signInInputDto;
    private UserOrder userOrder;
}
