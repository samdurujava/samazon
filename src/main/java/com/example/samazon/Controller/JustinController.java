package com.example.samazon.Controller;

import com.example.samazon.Repositories.*;
import com.example.samazon.SSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
