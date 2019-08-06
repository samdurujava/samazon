package com.example.samazon.Repositories;

import com.example.samazon.Beans.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
