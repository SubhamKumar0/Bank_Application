package bank;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.DBConnection;
import bank.model.AddNewCustomer;


@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _uacc = request.getParameter("txtName");
        String _pass = request.getParameter("txtPwd");
        
        AddNewCustomer obj=new AddNewCustomer();
        
        obj.setAccno(_uacc);
        obj.setPin(_pass);
        
        DBConnection log=new DBConnection();
        
        boolean is=false;
        try {
			try {
				is=log.login(obj);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(is) {
        	response.sendRedirect("CustomerDashboard.jsp");
        }
        else {
        	response.sendRedirect("CustomerLoginFailure.jsp");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}