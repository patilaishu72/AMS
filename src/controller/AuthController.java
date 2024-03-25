package controller;

import dao.UserImpl;
import model.User;

public class AuthController {

	public boolean signup(String username, String password) {
		UserController userController = new UserController();
		String result = userController.addUser(username, password);
		if (result.equals("success"))
			return true;
		return false;
	}

	public boolean login(String username, String password) {
		UserImpl userImpl = new UserImpl();
		User user = userImpl.getUserByUsername(username);
		if (user == null)
			return false;
		if (user.getPassword().equals(password))
			return true;
		return false;
	}
	
	public boolean isAdmin(String username,String password) {
		if(username.equals("Admin")) return true;
		else return false;
	}
}
