package io.jobintree.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User getUserByPhone(String phone) {
		return repository.findById(phone).get();
	}
	
	public void insertUser(User user) {
		repository.insert(user);
	}
	
	public boolean numberExists(String phone) {
		return localNumberExists(phone);
	}
	
	private boolean localNumberExists(String phone) {
		boolean bool = false;
		List<User> list =repository.findAll();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPhone().equals(phone)) {
				bool = true;
			}
		}
		return bool;
	}
	
	public boolean emailExists(String email) {
		return localEmailExists(email);
	}
	
	private boolean localEmailExists(String email) {
		boolean bool = false;
		List<User> list =repository.findAll();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getEmail().equals(email)) {
				bool = true;
			}
		}
		return bool;
	}
}
