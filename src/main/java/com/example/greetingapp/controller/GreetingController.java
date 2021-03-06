package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/greeting/{id}")
    public Greeting getById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings(){
        return greetingService.getAll();
    }

    @DeleteMapping("/greeting/{id}")
    public Greeting deleteById(@PathVariable Long id){
        return greetingService.deleteGreeting(id);
    }

    @PutMapping("/greeting/{id}")
    public Greeting updateById(@PathVariable Long id, @RequestBody User user){
        return greetingService.updateGreeting(id,user);
    }

}
