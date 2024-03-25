package controller;

import java.util.List;

import dao.UserImpl;
import model.User;

public class UserController {
	UserImpl userImpl=new UserImpl();
	
	public String addUser(String username,String password) {
		User user=new User(0, username, password);
		return userImpl.addUser(user);
	}

	public List<User> viewUsers() {
		List<User> list=userImpl.viewUsers();
		return list;
	}

	public String updateUser(String oldUsername,String newUsername,String password) {
		User user= userImpl.getUserByUsername(oldUsername);
		if(user==null) return "User with username "+oldUsername+" does not exist!";
		user.setUsername(newUsername);
		user.setPassword(password);
		return userImpl.updateUser(user);
		
	}

	public String deleteUser(String username) {
		User user=userImpl.getUserByUsername(username);
		if(user==null) return "User with username "+username+" does not exist!";
		return userImpl.deleteUser(user);
	}

	public User getUserByUsername(String username) {
		return userImpl.getUserByUsername(username);
	}
}
