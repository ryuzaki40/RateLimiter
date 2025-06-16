package com.example.RateLimiter.controller;

import com.example.RateLimiter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.example.RateLimiter.service.RateLimiterService;

@RestController
@RequestMapping("/api")
public class DemoController {
    
    @Autowired
    private RateLimiterService rateLimiterService;

    @GetMapping("/data")
    public String getData(@RequestParam String clientId)
    {
        if(!rateLimiterService.isAllowed(clientId))
        {
            return "Rate Limit exceeded. Try again later!";
        }

        return "Here is your protected data!";
    }

    


}
