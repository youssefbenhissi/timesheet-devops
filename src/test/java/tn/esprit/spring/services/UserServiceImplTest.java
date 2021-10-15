package tn.esprit.spring.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {

	@Autowired
	IUserService us;
	
	@Test
	@Order(1)
	public void testRetrieveAllUsers() {
		List<User> users = us.retrieveAllUsers();
		Assertions.assertEquals(0,users.size());
	}
	
	@Test
	@Order(2)
	public void testAddUser() {
		User u = us.addUser(new User());
		Assertions.assertNotNull(u);
	}
	
	public void testRetrieveUser() {
		User u = us.retrieveUser("1");
		Assertions.assertNotNull(u);
	}
	
	
	@Test 
	@Order(3)
	public void testUpadteuser() {
		User u = us.retrieveUser("1");
		User updatedUser = us.updateUser(u);
		Assertions.assertNotNull(updatedUser);
	}
	
	
	@Test
	@Order(4)
	public void testDeleteUser() {
		us.deleteUser("1");
		Assertions.assertEquals(0, us.retrieveAllUsers().size());
	}
}
