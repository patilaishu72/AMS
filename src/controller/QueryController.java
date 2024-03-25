package controller;

import java.util.List;

import dao.UserQueryImpl;
import model.UserQuery;

public class QueryController {
	UserQueryImpl userQueryImpl=new UserQueryImpl();
	
	public String addQuery(String username,String phone,String query) {
		UserQuery userQuery=new UserQuery(0, username, phone, query);
		return userQueryImpl.addQuery(userQuery);
	}
	
	public List<UserQuery> viewQueries(){
		return userQueryImpl.viewQueries();
	}
	
	public String updateQuery(Integer queryId,String username,String phone,String query) {
		UserQuery userQuery=new UserQuery(queryId, username, phone, query);
		return userQueryImpl.updateQuery(userQuery);
	}
	
	public String deleteQuery(Integer  queryId) {
		UserQuery userQuery=new UserQuery();
		userQuery.setQueryId(queryId);
		return userQueryImpl.deleteQuery(userQuery);
	}
}
