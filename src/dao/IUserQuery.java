package dao;

import java.util.List;

import model.UserQuery;

public interface IUserQuery {

	public String addQuery(UserQuery query);
	
	public List<UserQuery> viewQueries();
	
	public String updateQuery(UserQuery query);
	
	public String deleteQuery(UserQuery query);
	
	public List<UserQuery> getQueriesByUsername(String username);
	
	public UserQuery getUserQueryById(int id);
}
