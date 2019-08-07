package com.example.samazon.Controller;

import com.example.samazon.Beans.Order;
import com.example.samazon.Repositories.*;
import com.example.samazon.SSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JustinController {

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

    //------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/terms")
    public String index(Model model)
    {
        return "terms";
    }
    //------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/shipping")
    public String shipping(Model model)
    {
        model.addAttribute("users", userRepository.findAll());
        return "shipping";
    }

    @PostMapping("/shipping")
    public String shipping(@RequestParam("result") String id, Model model, Order order)
    {
        
//        return "shipping";
        return "id";

    }
}
