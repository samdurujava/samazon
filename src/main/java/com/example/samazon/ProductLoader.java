package com.example.samazon;

import com.example.samazon.Beans.Product;
import com.example.samazon.Beans.Role;
import com.example.samazon.Beans.User;
import com.example.samazon.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProductLoader implements CommandLineRunner {
    @Autowired
    SSUserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String...strings) throws Exception {

        //Constructors
        //==============================================================================================================
        Product product = new Product("Airpods","listening device",199.99,true,"test.png");
        productRepository.save(product);

        product = new Product("Laptop","computing device",1199.99,true,"test.png");
        productRepository.save(product);
    }
}
