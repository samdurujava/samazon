package com.example.samazon.Repositories;

import com.example.samazon.Beans.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
