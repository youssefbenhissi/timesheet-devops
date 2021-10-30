package tn.esprit.spring.services;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {
	@Autowired
	IUserService us;
	@Test
	@Order(1)
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");

		us.addUser(new User("Youssef", "Benhissi", d,Role.INGENIEUR));
		List<User> listUsers= us.retrieveAllUsers();
		Assertions.assertEquals(1, listUsers.size());
	}

	@Test
	@Order(2)
	public void testRetrieveUser() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(1, listUsers.size());
	}
	
	@Test
	@Order(3)
	public void testUpdateUser() {
		List<User> listUsers = us.retrieveAllUsers();
		User e = listUsers.get(0);
		e.setLastName("BENHISSIIII");
		us.updateUser(e);
		listUsers = us.retrieveAllUsers();
		Assertions.assertEquals("BENHISSIIII", listUsers.get(0).getLastName());
	}
	@Test
	@Order(4)
	public void testDeleteUser() {
		List<User> listUsers = us.retrieveAllUsers();
		us.deleteUser(listUsers.get(0).getId().toString());
		listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());
	}

}