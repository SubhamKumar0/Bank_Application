package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.PrintWriter;
import java.sql.*;

import bank.model.AddNewCustomer;
import bank.model.TransactionModel;

public class DBConnection {
	public Connection DBC() throws ClassNotFoundException
	{
		String jbdcurl="jdbc:mysql://localhost:3306/bank";
        String jdbcuser="root";
        String jdbcPassword="Ashapawan";
        Connection con=null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(jbdcurl,jdbcuser,jdbcPassword);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // TODO Auto-generated constructor stub
        return con;
    }
	
	public boolean login(AddNewCustomer aobj) throws SQLException, ClassNotFoundException{
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql = "SELECT account_no, password FROM login WHERE account_no = ? AND password = ?;";
        ps = DBC().prepareStatement(sql);
        ps.setString(1, aobj.getAccno());
        ps.setString(2, aobj.getPin());
        rs = ps.executeQuery();
       
        try {
			if (rs.next()) {
				return true;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}
	public int insert(AddNewCustomer aobj) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=null;
		//ResultSet rs=null;
		int result=0;
		ps=DBC().prepareStatement("INSERT into login (account_no,password,name,address,mobile,email,account_type,dob,id_proof,balance) VALUES (?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, aobj.getAccno());
		ps.setString(2, aobj.getPin());
		ps.setString(3, aobj.get_uname());
		ps.setString(4, aobj.get_uaddress());
		ps.setString(5, aobj.get_umobile());
		ps.setString(6, aobj.get_uemail());
		ps.setString(7, aobj.get_uaccounttype());
		ps.setString(8, aobj.get_undob());
		ps.setString(9, aobj.get_uidproof());
		ps.setString(10,aobj.get_ubal());
		result=ps.executeUpdate();
		
		return result;
	}
	public boolean delete(AddNewCustomer aobj)
	{
		PreparedStatement ps=null;
		boolean result=true;
		try {
			ps=DBC().prepareStatement("DELETE from login WHERE  account_no=?;");
			ps.setString(1, aobj.getAccno());
			result=ps.execute();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	public int Withdraw(AddNewCustomer aobj)
	{
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=DBC().prepareStatement("UPDATE login SET balance=balance-? WHERE account_no=?;");
			ps.setString(1, aobj.get_ubal());
			ps.setString(2, aobj.getAccno());
			result=ps.executeUpdate();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	public int Deposit(AddNewCustomer aobj)
	{
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=DBC().prepareStatement("UPDATE login SET balance=balance+? WHERE account_no=?;");
			ps.setString(1, aobj.get_ubal());
			ps.setString(2, aobj.getAccno());
			result=ps.executeUpdate();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	public List<Map<String, String>> viewAll() throws ClassNotFoundException, SQLException
	{
		List<Map<String, String>> lst=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		AddNewCustomer aobj=new AddNewCustomer();
		
		ps=DBC().prepareStatement("select * from login;");
		rs=ps.executeQuery();
		
		 while (rs.next()) {
             Map<String, String> row = new HashMap<>();
             
             row.put("account_number", rs.getString("account_no"));
             row.put("fullname", rs.getString("name"));
             row.put("address", rs.getString("address"));
             row.put("mobile", rs.getString("mobile"));
             row.put("email", rs.getString("email"));
             row.put("account_type", rs.getString("account_type"));
             row.put("dob", rs.getString("dob"));
             row.put("id_proof", rs.getString("id_proof"));
             row.put("account_status", rs.getString("account_status"));
             row.put("balance", rs.getString("balance"));
             //row.put("dob", rs.getString("dob"));
             
             //row.put("pass", rs.getString("Pass"));
             lst.add(row);
             
             
 			///aobj.set_uname(rs.getString("name"));
 			//lst.add(aobj);
         }
		 


		return lst;
	}
	
	public List<Map<String, String>> view(AddNewCustomer aobj) throws ClassNotFoundException, SQLException
	{
		List<Map<String, String>> lst=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;

		ps=DBC().prepareStatement("select * from login where account_no=?;");
		ps.setString(1, aobj.getAccno());
		rs=ps.executeQuery();
		
		 while (rs.next()) {
             Map<String, String> row = new HashMap<>();
             
             row.put("account_number", rs.getString("account_no"));
             row.put("fullname", rs.getString("name"));
             row.put("address", rs.getString("address"));
             row.put("mobile", rs.getString("mobile"));
             row.put("email", rs.getString("email"));
             row.put("account_type", rs.getString("account_type"));
             row.put("dob", rs.getString("dob"));
             row.put("id_proof", rs.getString("id_proof"));
             row.put("account_status", rs.getString("account_status"));
             row.put("balance", rs.getString("balance"));
             lst.add(row);

         }
		return lst;
	}
	
	public int change_password(AddNewCustomer aobj) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {

			ps=DBC().prepareStatement("UPDATE login SET password=? WHERE account_no=?");
			ps.setString(1, aobj.getPin());
			ps.setString(2, aobj.getAccno());
			result=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int change_status(AddNewCustomer aobj) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			String status="Activated";
			ps=DBC().prepareStatement("UPDATE login SET account_status=? WHERE account_no=?");
			ps.setString(1, status);
			ps.setString(2, aobj.getAccno());
			result=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int modify_Customer_details(AddNewCustomer aobj) {
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {

			ps=DBC().prepareStatement("UPDATE login SET name=?,address=?,mobile=?,email=?,account_type=?,dob=?,id_proof=? WHERE account_no=?");
			ps.setString(1, aobj.get_uname());
			ps.setString(2, aobj.get_uaddress());
			ps.setString(3, aobj.get_umobile());
			ps.setString(4, aobj.get_uemail());
			ps.setString(5, aobj.get_uaccounttype());
			ps.setString(6, aobj.get_undob());
			ps.setString(7, aobj.get_uidproof());
			ps.setString(8, aobj.getAccno());
			result=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public String check_balance(String aobj)
	{
		int result=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		

		try {
			//PrintWriter out=response.getWriter();
			//response.setContentType("text/html");
			
			ps=DBC().prepareStatement("SELECT balance from login where account_no=?");
			ps.setString(1, aobj);
			rs=ps.executeQuery();
			while(rs.next()) {
				String bal=rs.getString(1);
				System.out.println(bal);
				return bal;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public int transaction_insert(TransactionModel tm) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=null;
		//ResultSet rs=null;
		int result=0;
		ps=DBC().prepareStatement("INSERT into transaction (transaction_id,account_no,transaction_type,balance) VALUES (?,?,?,?);");
		ps.setString(1, tm.getT_id());
		ps.setString(2, tm.getAcc_no());
		ps.setString(3, tm.getT_type());
		ps.setString(4, tm.getBal());
		
		result=ps.executeUpdate();
		
		return result;
	}
	
	public List<Map<String, String>> viewAlltransactions() throws ClassNotFoundException, SQLException
	{
		List<Map<String, String>> lst=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		TransactionModel tm=new TransactionModel();
		
		ps=DBC().prepareStatement("select * from transaction;");
		rs=ps.executeQuery();
		
		 while (rs.next()) {
             Map<String, String> row = new HashMap<>();
             
             row.put("transaction_id", rs.getString("transaction_id"));
             row.put("account_no", rs.getString("account_no"));
             row.put("transaction_type", rs.getString("transaction_type"));
             row.put("balance", rs.getString("balance"));
             row.put("status", rs.getString("status"));
             
             lst.add(row);
             
             
 			///aobj.set_uname(rs.getString("name"));
 			//lst.add(aobj);
         }
		 return lst;
		 
}

	
	public int t_withdraw_insert(TransactionModel tm) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=null;
		//ResultSet rs=null;
		int result=0;
		ps=DBC().prepareStatement("INSERT into transaction (transaction_id,account_no,transaction_type,balance) VALUES (?,?,?,?);");
		ps.setString(1, tm.getT_id());
		ps.setString(2, tm.getAcc_no());
		ps.setString(3, tm.getT_type());
		ps.setString(4, tm.getBal());
		
		
		result=ps.executeUpdate();
		
		return result;
	}
	
	public long t_id_generator() {
		
		Random random=new Random();
		long f=0;
		for(int i=0;i<15;i++) {
			int digit=random.nextInt(10);
			f=f*10+digit;
		}
		return f;
		
		
	}
}
