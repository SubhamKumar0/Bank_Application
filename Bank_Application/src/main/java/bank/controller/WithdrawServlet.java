package bank.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.DBConnection;
import bank.model.AddNewCustomer;
import bank.model.TransactionModel;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Acc=request.getParameter("account_number");
		String Amt=request.getParameter("amount");
		
		AddNewCustomer obj=new AddNewCustomer();
		obj.setAccno(Acc);
		obj.set_ubal(Amt);
		
		DBConnection with=new DBConnection();
		
		int is=0;
		is=with.Withdraw(obj);
		if(is==1) {
			response.sendRedirect("WithdrawSuccess.jsp");
			
			TransactionModel tm=new TransactionModel();
			
			String t_id=Long.toString(with.t_id_generator());
			String t_bal=with.check_balance(Acc);
			String t_type="Withdraw";
			
			tm.setAcc_no(Acc);
			tm.setT_id(t_id);
			tm.setBal(t_bal);
			tm.setT_type(t_type);
		
			
			
			
			try {
				
				 int res=with.t_withdraw_insert(tm);
				System.out.println(res);
				
			}
			catch(ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
