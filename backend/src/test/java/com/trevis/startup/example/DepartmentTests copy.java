package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.model.DepartmentModel;
import com.trevis.startup.example.services.DepartmentService;

@SpringBootTest
class DepartmentTests {

	@Autowired
	DepartmentService departmentService;

	List<DepartmentModel> departments;

	@Test
	void departmentTest() {
		assertNotNull(departments);
		assertTrue(departmentService.GetAll().size() > 0); 
		assertEquals(departmentService.GetAll().size(), 2); // Neste caso estamos testando apenas o MockDepartment, parece estranho mas o Thevis aprovou
	}
}