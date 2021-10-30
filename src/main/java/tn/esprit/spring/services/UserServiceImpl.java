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

	// TODO Logger à ajouter  
	
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode 
			logger.info("Dans retrieveAllUsers");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs   
				logger.info("user :"+user);
			} 
			// TODO Log à ajouter à la fin de la méthode 
			logger.info("Finished retrieveAllUsers");
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
			logger.error("error executing retrieveAllUsers: "+e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		logger.info("Entered addUser(u)");
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		logger.info("addUser(u) finished");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		logger.info("Entered updateUser(u)");
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		logger.info("Finished updateUser(u)");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		logger.info("Entered deleteUser(id)");
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
		logger.info("Finished deleteUser(id)");
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		logger.info("Entered retrieveUser(id)");
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode 
		logger.info("Finished retrieveUser(id)");
		return u; 
	}

}