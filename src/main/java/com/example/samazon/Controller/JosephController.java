package com.example.samazon.Controller;

import com.example.samazon.Beans.History;
import com.example.samazon.Beans.Product;
import com.example.samazon.Beans.User;
import com.example.samazon.CustomUserDetails;
import com.example.samazon.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Controller
public class JosephController {

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);
        if (result.hasErrors()){
            return "registration";
        } else {
            user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
            userRepository.save(user);
            model.addAttribute("created",  true);
        }
        return "login";
    }

    @RequestMapping("/")
    public String homePage(Principal principal, Model model) {
        model.addAttribute("list", productRepository.findAll());
        User user = ((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        model.addAttribute("user", user);
        return "show";
    }

    @RequestMapping("/addCart/{id}")
    public String add(@PathVariable("id") long id, Principal principal, Model model) {
        model.addAttribute("list", productRepository.findAll());
        User user = ((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        model.addAttribute("user", user);

        History history = new History();
        history.setUser(user);

        Product product = productRepository.findById(id);
        history.setProductId(product.getId());
        historyRepository.save(history);
        return "show";
    }

    @RequestMapping("/cart")
    public String myCart( Principal principal, Model model) {
        User user = ((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        model.addAttribute("user", user);
        ArrayList<History> historyList = historyRepository.findAllByUser(user);
        if (historyList.size() > 0) {
            ArrayList<Product> products = new ArrayList<>();
            for (History prev : historyList) {
                products.add(productRepository.findById(prev.getProductId()));
            }
            model.addAttribute("list", products);
        } else {
            model.addAttribute("list", null);
        }
        return "show";
    }
}
