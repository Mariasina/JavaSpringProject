// package com.trevis.startup.example;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.trevis.startup.example.services.UserService;

// @SpringBootTest
// class UserTests {

// 	@Autowired
// 	UserService userService;

// 	@Test
// 	void serviceTestTrue() {
// 		var search = userService.Get("Mavizoka");
// 		assertNotNull(search);
// 		assertEquals(userService.UpdatePassword(1l, "Maria@1234"), true);

// 	}

// 	@Test
// 	void serviceTestFalse() {
// 		var search = userService.Get("Mavizoka");
// 		assertNotNull(search);

// 		assertEquals(userService.UpdatePassword(1l, "Maria"), false);
// 	}

// 	@Test
// 	void createTest() {
// 		var department = new Integer();
//         department.setId(2l);
//         department.setName("ETS");
		
// 		UserCreate user = new UserCreate("Nilton", department, 0);
// 		var userModel = userService.Create(user);
// 		assertEquals(userService.Create(user), userModel);
// 		assertEquals(userModel.getLogin(), user.login());
// 		assertEquals(userModel.getRole(), user.role());
// 		assertEquals(userModel.getDepartment(), user.department());
// 	}
// }