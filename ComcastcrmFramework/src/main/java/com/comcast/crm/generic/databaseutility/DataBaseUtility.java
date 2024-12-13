package com.comcast.crm.generic.databaseutility;
//DATABASE UTILITY
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con; //declare it globally as we are closing the connection in another method,also if we need to use them in different methods 
public void getDbConnection() throws SQLException
{
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con = DriverManager.getConnection("jsbc:mysql://localhost:3306/projects","root","root");
	} catch(Exception e){
	}
	}
	//put it in try block as we need to handle the exception just in case if the connection doesn't happen.
public void closedbConnection() throws SQLException
{
	try {
	con.close();
}catch(Exception e){
}
	
}
public  ResultSet exceuteSelectQuery(String Query) throws SQLException{
	ResultSet result=null;//result obj is local
try{
	Statement stat=con.createStatement();
	result=stat.executeQuery(Query);// in ResultSet object we have complete table
	
}
catch(Exception e){
}
return result;
}

public int executeNonSelectQuery(String Query) {
	int result=0;
	try {
		Statement stat=con.createStatement();
		result=stat.executeUpdate(Query);//if the data is inserted it returns +-1 else 0 means its a fail
	}catch(Exception e){
	}
	return result;

}
}


