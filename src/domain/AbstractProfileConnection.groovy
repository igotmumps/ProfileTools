package domain

import java.sql.Connection;

abstract class AbstractProfileConnection {
	private String driver = 'sanchez.jdbc.driver.ScDriver'
	private String connectionUrl
	public Connection connection
	public String returnMessage = ''
	
	//TODO read the properties file and retrieve the Profile environments
	//into a hash table or something...

}
