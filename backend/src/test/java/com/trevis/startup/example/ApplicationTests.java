package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.controllers.TestController;
import com.trevis.startup.example.services.HelloService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	HelloService service;

	@Autowired
	TestController controller;

	@Test
	void exampleTest() {
		assertEquals(service.getHello(), "Hello Spring Boot!");
	}
	
	@Test
	void exampleTest2() {
		assertEquals(controller.test(), "Hello Spring Boot!");
	}
}