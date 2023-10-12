package com.ravindra.RestaurantManagement.Repo;

import com.ravindra.RestaurantManagement.Model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends CrudRepository<Admin, Integer> {
    Admin findFirstByAdminEmail(String adminEmail);
}
