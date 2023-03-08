package crm.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataIntoDatabase {
	
	public static void main(String[] args) throws SQLException {
		//Step1:- create instance for Driver --> registr driver to jdbc
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		
		//step2: get connection
		Connection connection=null;
try {		
		 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		//Step3 --> create statement
		Statement statement = connection.createStatement();
		
		//Step4 --> execute query
		int result = statement.executeUpdate("insert into project(created_by,project_name,project_id,status,created_on,team_size) values('Mohan', 'Selenium_Api', 'TY_PROJ_100', 'Completed project', '07/02/2023', '12');");
		
		//Step5 --> iterate data and verify or fetch
		if(result==1) {
			System.out.println("Data added sucessFully");
		}
}
finally {
		//Step6 --> close connection
		connection.close();
		System.out.println("connection closed");
}	
	}

}
