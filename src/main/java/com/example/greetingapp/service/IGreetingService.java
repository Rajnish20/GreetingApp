package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;

import java.util.Optional;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);
}
