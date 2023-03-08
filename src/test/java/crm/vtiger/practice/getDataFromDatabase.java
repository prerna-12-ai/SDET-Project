package crm.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class getDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		//Step1:- create instance for Driver --> registr driver to jdbc
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		//step2: get connection --> dburl, un, pwd
		Connection connection=null;
		try {		
			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			//Step3 --> create statement
			Statement statement = connection.createStatement();

			//Step4 --> execute query
			ResultSet result = statement.executeQuery("select * from project");
			int size = result.getMetaData().getColumnCount();
			for (int i = 1; i <=size; i++) {
			System.out.println(result.getMetaData().getColumnName(i));
			}
			
			//Step5 --> iterate data and verify or fetch
			while(result.next()) {
				
				String manager = result.getString("created_by");
				String projectName = result.getString("project_name");
				String projectID = result.getString("project_id");
				String status = result.getString("status");
				String createdOn = result.getString("created_on");
				String teamSize = result.getString("team_size");
				System.out.println(projectName+" "+manager+" "+projectID+" "+status+" "+createdOn+" "+teamSize);

			}
		}
		finally {
			//Step6 --> close connection
			connection.close();
			System.out.println("connection closed");
		}	
	}

}
