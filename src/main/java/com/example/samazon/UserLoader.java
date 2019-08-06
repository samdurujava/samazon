package com.example.samazon;

import com.example.samazon.Beans.Role;
import com.example.samazon.Beans.User;
import com.example.samazon.Repositories.RoleRepository;
import com.example.samazon.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception {
        Role userRole = roleRepository.save(new Role("USER"));
        Role adminRole = roleRepository.save(new Role("ADMIN"));

        User user = new User("John", "Smith", "john@gmail.com",
                "john", "password", "883-655 Piacquadio Rd, Margaretville, NY 12455");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        user = new User("Admin", "Admin", "admin@samazon.com",
                "admin", "password", "473-323 Forest Ave, Georgetown, SC 29440");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);
    }
}
