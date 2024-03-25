package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Db {

	private static Db db=new Db();
	private Db() {}
	
	public static Db getObject() {
		return db;
	}
	
	public Connection getConnection(){
		Connection connection=null;
		try {
			FileReader reader=new FileReader("src\\util\\db.properties");
			Properties properties=new Properties();
			properties.load(reader);
			Class.forName(properties.getProperty("driver"));
			connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
