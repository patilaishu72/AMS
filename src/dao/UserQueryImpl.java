package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserQuery;
import util.Db;
import util.Query;

public class UserQueryImpl implements IUserQuery{
	PreparedStatement statement;
	String result;
	
	@Override
	public String addQuery(UserQuery query) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.ADD_USER_QUERY);
			statement.setString(1, query.getUsername());
			statement.setString(2, query.getPhone());
			statement.setString(3, query.getQuery());
			statement.executeUpdate();
			result="Query Submitted Successfully!";
		} catch (SQLException e) {
			System.out.println("Phone No. must contain only 10 digits!\nPlease try again");
			result="Query cannot be submitted due to wrong input";
			
		}
		return result;
	}

	@Override
	public List<UserQuery> viewQueries() {
		List<UserQuery> userQueries=new ArrayList<UserQuery>();
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.VIEW_USER_QUERIES);
			ResultSet set= statement.executeQuery();
			while (set.next()) {
				UserQuery userQuery=new UserQuery(set.getInt(1), set.getString(2), set.getString(3), set.getString(4));
				userQueries.add(userQuery);
			}
		} catch (SQLException e) {
		}
		return userQueries;
	}

	@Override
	public String updateQuery(UserQuery query) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.UPDATE_USER_QUERY);
			statement.setString(1, query.getUsername());
			statement.setString(2, query.getPhone());
			statement.setString(3, query.getQuery());
			statement.setInt(4, query.getQueryId());
			int status= statement.executeUpdate();
			if(status>0) result="User query updated successfully!";
			else result="Query with ticket no. "+query.getQueryId()+" does not exist";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteQuery(UserQuery query) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.DELETE_USER_QUERY);
			statement.setInt(1, query.getQueryId());
			int status=statement.executeUpdate();
			if(status>0)result="User query deleted successfully!";
			else result="Query with ticket no. "+query.getQueryId()+" does not exist";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<UserQuery> getQueriesByUsername(String username) {
		List<UserQuery> userQueries=new ArrayList<UserQuery>();
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.GET_QUERY_BY_USERNAME);
			statement.setString(1, username);
			ResultSet set=statement.executeQuery();
			while(set.next()) {
				UserQuery userQuery=new UserQuery(set.getInt(1), set.getString(2), set.getString(3), set.getString(4));
				userQueries.add(userQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userQueries;
	}

	@Override
	public UserQuery getUserQueryById(int id) {
		UserQuery query=null;
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.GET_QUERY_BY_ID);
			statement.setInt(1, id);
			ResultSet set=statement.executeQuery();
			while(set.next()) {
				query=new UserQuery(set.getInt(1), set.getString(2), set.getString(3), set.getString(4));
			}
		} catch (SQLException e) {
			query=null;
		}
		return query;
	}

}
