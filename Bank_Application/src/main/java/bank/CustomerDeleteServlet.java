package bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.DBConnection;
import bank.model.AddNewCustomer;

/**
 * Servlet implementation class CustomerDeleteServlet
 */
@WebServlet("/CustomerDeleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc_no=request.getParameter("del_account_number");
		
		AddNewCustomer obj=new AddNewCustomer();
		
		obj.setAccno(acc_no);
		
		DBConnection del=new DBConnection();
		boolean is=false;
		is=del.delete(obj);
		System.out.println(is);
		if(!is) {
			response.sendRedirect("ViewAllCustomerDetailsServlet");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
