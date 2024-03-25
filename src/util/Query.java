package util;

public class Query {

	public static final String ADD_USER="insert into users(username,password) values(?,?)";
	
	public static final String VIEW_USERS="select * from users";
	
	public static final String UPDATE_USER="update users set username=?,password=? where id=?";
	
	public static final String DELETE_USER="delete from users where id=?";
	
	public static final String GET_USER_BY_USERNAME="select * from users where username=?";
	
	
	public static final String ADD_MEETING="insert into meetings values(?,?,?,?)";
	
	public static final String VIEW_MEETINGS="select * from meetings";
	
	public static final String UPDATE_MEETING="update meetings set title=?,date=?,time=? where meeting_id=?";
	
	public static final String DELETE_MEETING="delete from meetings where meeting_id=?";
	
	
	public static final String ADD_CROP="insert into crops(name,description) values(?,?)";
	
	public static final String VIEW_CROPS="select * from crops";
	
	public static final String UPDATE_CROP="update crops set name=?,description=? where crop_id=?";
	
	public static final String DELETE_CROP="delete from crops where crop_id=?";
	
	public static final String GET_CROP_BY_NAME="select * from crops where name=?";
	
	
	public static final String ADD_USER_QUERY="insert into user_queries(username,phone,query) values(?,?,?)";
	
	public static final String VIEW_USER_QUERIES="select * from user_queries";
	
	public static final String UPDATE_USER_QUERY="update user_queries set username=?,phone=?,query=? where query_id=?";
	
	public static final String DELETE_USER_QUERY="delete from user_queries where query_id=?";
	
	public static final String GET_QUERY_BY_USERNAME="select * from user_queries where username=?";
	
	public static final String GET_QUERY_BY_ID="select * from user_queries where query_id=?";
	
}
