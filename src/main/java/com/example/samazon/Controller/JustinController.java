package com.example.samazon.Controller;

import com.example.samazon.Beans.Order;
import com.example.samazon.Beans.User;
import com.example.samazon.CustomUserDetails;
import com.example.samazon.Repositories.*;
import com.example.samazon.SSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    @GetMapping("/shipping")
    public String shipping(Model model, Principal principal)
    {
        User user = ((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        model.addAttribute("user", user);
        model.addAttribute("users", user);
        return "shipping";
    }

    @PostMapping("/shipping")
    public String shipping(@RequestParam(name = "result") String id, Model model, Principal principal)
    {
        User user = ((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        Order order = new Order();
        order = orderRepository.findByUser(user);
        System.out.println("hello");
        if(id =="ship1")
        {
            order.setShipping_method("One Day Shipping");
            orderRepository.save(order);
        }
        else if(id == "ship2")
        {
            order.setShipping_method("Two Day Shipping");
            orderRepository.save(order);
        }
        else
        {
            order.setShipping_method("Standard Shipping");
            orderRepository.save(order);
        }
        System.out.println("goodbye");
        return "redirect:/";
    }
}
