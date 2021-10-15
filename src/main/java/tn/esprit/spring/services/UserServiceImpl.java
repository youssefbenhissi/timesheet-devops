package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;


	
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			logger.info("Dans retrieveAllUsers");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				
				logger.info("user :"+user);
			} 
			
			logger.info("Finished retrieveAllUsers");
		}catch (Exception e) {
			
			logger.error("error executing retrieveAllUsers: "+e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		logger.info("Entered addUser(u)");
		User u_saved = userRepository.save(u); 
		logger.info("addUser(u) finished");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		logger.info("Entered updateUser(u)");
		User u_saved = userRepository.save(u);  
		logger.info("Finished updateUser(u)");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {

		logger.info("Entered deleteUser(id)");
		userRepository.deleteById(Long.parseLong(id)); 

		logger.info("Finished deleteUser(id)");
	}

	@Override
	public User retrieveUser(String id) {
		
		logger.info("Entered retrieveUser(id)");
		
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		
		logger.info("Finished retrieveUser(id)");
		return u; 
	}

}
