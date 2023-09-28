package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveit")
public class NewRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public NewRegistration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String id = request.getParameter("id");
		System.out.println(id);
		String Name = request.getParameter("Name");
		System.out.println(Name);
		String email = request.getParameter("email");
		System.out.println(email);
		String city= request.getParameter("city");
		System.out.println(city);
		String contact = request.getParameter("contact");
		System.out.println(contact);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/web_jdbcc_db1","root","test");
	
		    Statement stmnt = con.createStatement();
		    stmnt.executeUpdate("insert into employees values('"+id+"','"+Name+"','"+email+"','"+city+"','"+contact+"')");
		      con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
}

}
