package com.ravindra.RestaurantManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {

    @Id
    private Integer adminId;
    private String adminName;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@admin\\.com$")
    private String adminEmail;
    private String adminPassword;

}
