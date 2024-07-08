package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.trevis.startup.example.services.ServiceService;

@SpringBootTest
class ServiceTests {

	@Autowired
	ServiceService serviceService;

	@Test
	void serviceTestTrue() {
		var search = serviceService.Get("Client", 1, 10, null);

		assertNotNull(search);
		assertTrue(search.size() > 0);
		assertTrue(search.size() <= 10); // Neste caso estamos testando apenas o MockDepartment, parece estranho mas o Thevis aprovou 
	}
}