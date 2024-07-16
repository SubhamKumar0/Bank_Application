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
 * Servlet implementation class ModifyCustomerDetailsServlet
 */
@WebServlet("/ModifyCustomerDetailsServlet")
public class ModifyCustomerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _uname=request.getParameter("uname");
		String _uaddress=request.getParameter("uaddress");
		String _umobile=request.getParameter("umobile");
		String _uemail=request.getParameter("umail");
		String _uaccounttype=request.getParameter("uacc_type");
		String _undob=request.getParameter("udob");
		String _uidproof=request.getParameter("uid_proof");
		String _uacc=request.getParameter("account_number");
		
		AddNewCustomer aobj=new AddNewCustomer();
		
		aobj.setAccno(_uacc);
		aobj.set_uname(_uname);
		aobj.set_uaddress(_uaddress);
		aobj.set_umobile(_umobile);
		aobj.set_uemail(_uemail);
		aobj.set_uaccounttype(_uaccounttype);
		aobj.set_undob(_undob);
		aobj.set_uidproof(_uidproof);
		
		DBConnection mod=new DBConnection();
		
		int is=0;
		is=mod.modify_Customer_details(aobj);
		System.out.print(is);
		if(is==1) {
			response.sendRedirect("ModificationSuccess.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
