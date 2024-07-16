package bank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.DBConnection;
import bank.model.AddNewCustomer;


@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc_no=request.getParameter("account_number");
		String temp_pass=request.getParameter("temp_pass");
		String new_pass=request.getParameter("new_password");
		
		AddNewCustomer obj=new  AddNewCustomer();
		
		obj.setAccno(acc_no);
		obj.setPin(temp_pass);
		obj.setPin(new_pass);
		
		DBConnection chp=new DBConnection();
		int is=0;
		is=chp.change_password(obj);
		System.out.println(is);
		if(is==0)
		{
			response.sendRedirect("PasswordChangeSuccessful.jsp");
			is=chp.change_status(obj);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
