package com.java.HospitalProject;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDB {

	private  static Connection con;
	public static Connection getCon() {
		return con;
	}
	public static void setCon(Connection con) {
		ConnectToDB.con = con;
	}
	static {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("Jdbc:Oracle:oci8:thin:hr/hr@localhost:1521:orcl","SYSTEM","Aimhigh1");
			System.out.println("connected successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) {


	}

}
