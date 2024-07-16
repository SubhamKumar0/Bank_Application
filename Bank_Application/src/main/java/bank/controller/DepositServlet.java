package bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.DBConnection;
import bank.model.AddNewCustomer;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
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
		is=with.Deposit(obj);
		if(is==1) {
			response.sendRedirect("DepositSuccess.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
