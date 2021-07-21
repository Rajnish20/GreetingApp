package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template,user.toString().isEmpty()?"Hello World":user.toString());
        return new Greeting(counter.incrementAndGet(),message);
    }
}
