package com.example.samazon.Repositories;

import com.example.samazon.Beans.Order;
import com.example.samazon.Beans.User;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findByUser(User user);
}
