package dao;

import java.util.List;

import model.User;

public interface IUser {

	public String addUser(User user);
	
	public List<User> viewUsers();
	
	public String updateUser(User user);
	
	public String deleteUser(User user);
	
	public User getUserByUsername(String username);
}
