package model;

import java.util.Objects;

public class UserQuery {

	private Integer queryId;
	private String username;
	private String phone;
	private String query;
	public UserQuery() {
		super();
		
	}
	public UserQuery(Integer queryId, String username, String phone, String query) {
		super();
		this.queryId = queryId;
		this.username = username;
		this.phone = phone;
		this.query = query;
	}
	public Integer getQueryId() {
		return queryId;
	}
	public void setQueryId(Integer queryId) {
		this.queryId = queryId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public int hashCode() {
		return Objects.hash(phone, query, queryId, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserQuery other = (UserQuery) obj;
		return Objects.equals(phone, other.phone) && Objects.equals(query, other.query)
				&& Objects.equals(queryId, other.queryId) && Objects.equals(username, other.username);
	}
	
	
}
