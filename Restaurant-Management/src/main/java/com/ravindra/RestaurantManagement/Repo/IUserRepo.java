package com.ravindra.RestaurantManagement.Repo;

import com.ravindra.RestaurantManagement.Model.Admin;
import com.ravindra.RestaurantManagement.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User, Integer> {
    User findFirstByUserEmail(String userEmail);
}
