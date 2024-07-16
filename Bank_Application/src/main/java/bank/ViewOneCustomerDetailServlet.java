package bank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.DBConnection;
import bank.model.AddNewCustomer;


@WebServlet("/ViewOneCustomerDetailServlet")
public class ViewOneCustomerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String AccNo=request.getParameter("account_number");
		
		AddNewCustomer obj=new AddNewCustomer();
		obj.setAccno(AccNo);
		
		DBConnection vw=new DBConnection();
		

        List<Map<String, String>> customerData = new ArrayList<>();

        try {
			customerData=vw.view(obj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         // Debugging statement to check data
            for (Map<String, String> data : customerData) {
                System.out.println(data);
            }

            // Set the customer data in the request scope
            request.setAttribute("customerData", customerData);

            // Forward the request to the JSP page
            request.getRequestDispatcher("ViewOneCustomerDetail.jsp").forward(request, response);
        } 
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}