package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService implements IGreetingService{

    private static final String template = "Hello, %s!";

    @Autowired
    GreetingRepository greetingRepository;
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template,user.toString());
        return greetingRepository.save(new Greeting(message));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting deleteGreeting(long id) {
        return greetingRepository.findById(id).
                map(greeting -> {
                    this.greetingRepository.deleteById(id);
                    return greeting;
                }).get();
    }

    @Override
    public Greeting updateGreeting(long id,User user) {
        String message = String.format(template,user.toString());
        return greetingRepository.findById(id).
                map(greeting -> {
                    greeting.setMessage(message);
                    return this.greetingRepository.save(greeting);
                }).get();
    }

}
