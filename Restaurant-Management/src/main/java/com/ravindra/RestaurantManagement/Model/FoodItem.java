package com.ravindra.RestaurantManagement.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = FoodItem.class,property = "foodId")
public class FoodItem {

    @Id
    private Integer foodId;
    private String foodTitle;
    private String foodDesc;
    private String foodPrice;

    @OneToOne(mappedBy = "foodItem")
    UserOrder userOrder;
}
