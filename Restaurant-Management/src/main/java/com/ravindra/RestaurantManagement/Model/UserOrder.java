package com.ravindra.RestaurantManagement.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = UserOrder.class,property = "orderId")
public class UserOrder {

    @Id
    private Integer orderId;
    private String orderQuantity;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "fk-user-id")
    User user;

    @OneToOne
    @JoinColumn(name = "fk-foodItem-id")
    FoodItem foodItem;

}
