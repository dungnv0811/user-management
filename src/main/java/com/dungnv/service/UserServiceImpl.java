package com.dungnv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dungnv.collection.User;
import com.dungnv.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

//	@Autowired
	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}

}
