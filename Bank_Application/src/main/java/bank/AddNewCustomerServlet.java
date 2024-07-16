package bank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.DBConnection;
import bank.model.AddNewCustomer;
import bank.model.TransactionModel;

@WebServlet("/AddNewCustomerServlet")
public class AddNewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddNewCustomerServlet() {
        super();
    }
    
	private long accnogenerator() {
			
			Random random=new Random();
			long f=0;
			for(int i=0;i<15;i++) {
				int digit=random.nextInt(10);
				f=f*10+digit;
			}
			return f;
			
			
		}
	    private int pingenerator() {
	    	int n=0;
	    	Random random=new Random();
	    	for(int i=0;i<4;i++) {
	    		int digit=random.nextInt(1,10);
	    		n=n*10+digit;
	    	}
	    	return n;
	    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accno=Long.toString(accnogenerator());
		String pin=Integer.toString(pingenerator());

		String _uname=request.getParameter("uname");
		String _uaddress=request.getParameter("uaddress");
		String _umobile=request.getParameter("umobile");
		String _uemail=request.getParameter("umail");
		String _uaccounttype=request.getParameter("uacc_type");
		String _undob=request.getParameter("udob");
		String _uidproof=request.getParameter("uid_proof");
		String _ubal=request.getParameter("ubal");
		
		AddNewCustomer aobj=new AddNewCustomer();
		
		aobj.setAccno(accno);
		aobj.setPin(pin);
		aobj.set_uname(_uname);
		aobj.set_uaddress(_uaddress);
		aobj.set_umobile(_umobile);
		aobj.set_uemail(_uemail);
		aobj.set_uaccounttype(_uaccounttype);
		aobj.set_undob(_undob);
		aobj.set_uidproof(_uidproof);
		aobj.set_ubal(_ubal);
		
		DBConnection ins=new DBConnection();
		int is=0;
		try {
			try {
				is=ins.insert(aobj);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				System.out.print(is);
				if(is==1)
				{
					response.sendRedirect("ViewAllCustomerDetailsServlet");
					
					int res=0;
					
					String t_id=Long.toString(accnogenerator());
					
					TransactionModel tm=new TransactionModel();
					
					tm.setT_id(t_id);
					tm.setAcc_no(accno);
					tm.setT_type("Deposit");
					tm.setBal(_ubal);
			
					try {
						res=ins.transaction_insert(tm);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 System.out.println(res);
					
				}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
