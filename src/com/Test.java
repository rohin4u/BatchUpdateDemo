package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		
		
		Statement st = con.createStatement();
		
		st.addBatch("insert into employees values(700,'Arrora',50000,'Banglore')");
		st.addBatch("update employees set empSalary=empSalary+1000 where empSalary<20000");
		st.addBatch("delete from employees where empSalary>55000");
			
		int[] batch = st.executeBatch();
		
		int count = 0;
		
		for(int batch1 : batch) {
			
			count = count+batch1;
		}
		System.out.println(count);
		con.close();
		
		

	}

}
