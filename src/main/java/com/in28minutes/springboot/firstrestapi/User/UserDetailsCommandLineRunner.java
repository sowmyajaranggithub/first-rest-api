package com.in28minutes.springboot.firstrestapi.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {
    public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
        super();
        this.repository = repository;
    }

    private  Logger logger = LoggerFactory.getLogger(getClass());
     private UserDetailsRepository repository;

    @Override
    public void run(String... args) throws Exception {
//logger.info(Arrays.toString(args).toString());
repository.save(new UserDetails("sowmya", "Admin"));
        repository.save(new UserDetails("ravi", "Admin"));
        repository.save(new UserDetails("John", "User"));
        //List<UserDetails> users = repository.findAll();
        List<UserDetails> users = repository.findByRole("Admin");
        users.forEach(user -> logger.info(user.toString()));
    }
}
