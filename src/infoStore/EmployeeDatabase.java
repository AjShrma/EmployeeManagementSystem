package infoStore;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import empClasses.Employee;

public class EmployeeDatabase {
	public static Connection conn = null;
	public static void connect() {
        
        try {
            // db parameters
            String url = "jdbc:sqlite:G:\\Eclipse\\EmployeeMangement\\Libs\\EmployeeDatabase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        
        }
    }
	
	public  static int addEmployee(Employee e) {
		String sql="INSERT INTO PersonalInformation(EmpID,SIN,FName,LName,Sex,Email,Address,City,Province,Country,PostalCode,Mobile,Salary,Allowances,Type) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,e.getEmpID());
			pstmt.setString(2,e.getSIN());
			pstmt.setString(3,e.getFirstName());
			pstmt.setString(4,e.getLastName());
			pstmt.setString(5,e.getSex());
			pstmt.setString(6,e.getEmail());
			pstmt.setString(7,e.getAddress());
			pstmt.setString(8,e.getCity());
			pstmt.setString(9,e.getProvince());
			pstmt.setString(10,e.getCountry());
			pstmt.setString(11,e.getPostal());
			pstmt.setString(12,e.getMobile());
			pstmt.setString(13,e.getSalary());
			pstmt.setString(14,Integer.toString(e.getAllowances()));
			pstmt.setString(15,e.getEmpType());
			
			
			if(pstmt.executeUpdate()!=0)
				return 1;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}
	public  static ArrayList<String> findEmployee(String empID) {
		String sql="select * from PersonalInformation where empID='"+empID+"'";
		try {
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			if(!rs.next()) {
				System.out.print("aks-null received");
				return null;
				
			}
				
			else {
				System.out.print("aks-not null received");
				ArrayList<String> data=new ArrayList<>();
				data.add(rs.getString("EmpID"));
				data.add(rs.getString("SIN"));
				data.add(rs.getString("FName"));
				data.add(rs.getString("LName"));
				data.add(rs.getString("Sex"));
				data.add(rs.getString("Email"));
				data.add(rs.getString("Address"));
				data.add(rs.getString("City"));
				data.add(rs.getString("Province"));
				data.add(rs.getString("Country"));
				data.add(rs.getString("PostalCode"));
				data.add(rs.getString("Mobile"));
				data.add(rs.getString("Salary"));
				data.add(rs.getString("Allowances"));
				data.add(rs.getString("Type"));
				while(rs.next()) {
					rs.deleteRow();
				}
				return data;
			}
				
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.print("aks-exception received");
			e1.printStackTrace();
			
		}
		return null;
	}

}
