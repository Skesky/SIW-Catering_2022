package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Transactional
	public User save(User user) {
		return userRepo.save(user);
	}

	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();

		for(User u : userRepo.findAll()) {
			users.add(u);
		}

		return users;
	}

	public User findById(Long id) {
		return userRepo.findById(id).get();
	}

}
