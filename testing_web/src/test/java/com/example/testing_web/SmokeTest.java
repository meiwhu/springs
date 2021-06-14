package com.example.testing_web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private HomeController controller;

    @Test
    public void contextLoads() {
        assert controller != null;
    }
}
