package com.ravindra.RestaurantManagement.Repo;

import com.ravindra.RestaurantManagement.Model.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserOrderRepo extends CrudRepository<UserOrder, Integer> {
}
