package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.Db;
import util.Query;

public class UserImpl implements IUser{
	PreparedStatement statement;
	String result;
	@Override
	public String addUser(model.User user) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.ADD_USER);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.executeUpdate();
			result="success";
		} catch (SQLException e) {
			result="User already exists";
		}
		return result;
	}

	@Override
	public List<model.User> viewUsers() {
		List<User> users = new ArrayList<User>();
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.VIEW_USERS);
			ResultSet set=statement.executeQuery();
			while (set.next()) {
				User user=new User(set.getInt(1), set.getString(2),set.getString(3));
				users.add(user);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			
		}
		return users;
	}

	@Override
	public String updateUser(model.User user) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.UPDATE_USER);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getId());
			int status=statement.executeUpdate();
			if(status>0) result="User updated successfully!";
			else result="User record not found!";
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return result;
	}

	@Override
	public String deleteUser(User user) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.DELETE_USER);
			statement.setInt(1,user.getId());
			int status=statement.executeUpdate();
			if(status>0) result="User deleted successfully!";
			else result="User does not exist!";
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	@Override
	public User getUserByUsername(String username) {
		User user=null;
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.GET_USER_BY_USERNAME);
			statement.setString(1, username);
			ResultSet set=statement.executeQuery();
			set.next();
			user=new User(set.getInt(1), set.getString(2), set.getString(3));
			
		} catch (SQLException e) {
			
		}
		return user;
	}

	

}
