package chap14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import chap14.javaBeans.Customer;

/**
 * Servlet implementation class S14Servlet18
 */
@WebServlet("/S14Servlet18")
public class S14Servlet18 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S14Servlet18() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "SELECT CustomerID, CustomerName, City, Country, PostalCode "
				+ "From Customers "
				+ "ORDER BY CustomerID ";
		
		ServletContext application = getServletContext();
		DataSource ds = (DataSource) application.getAttribute("dbpool");
		List<Customer> list = new ArrayList<>();
		
		try(Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql); 
				){
			
			while(rs.next()) {
				Customer customer = new Customer();
				
				String id = rs.getString("CustomerID");
				String name = rs.getString("CustomerName");
				String city = rs.getString("City");
				String country = rs.getString("Country");
				String postCode = rs.getString("PostalCode");
				
				customer.setId(Integer.parseInt(id));
				customer.setName(name);
				customer.setCity(city);
				customer.setCountry(country);
				customer.setPostCode(postCode);
				
				list.add(customer);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("customerList", list);
		
		String path = "/WEB-INF/view/chap14/ex12.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		String sql = "DELETE FROM Customers "
				+ "WHERE CustomerID = ? ";
		
		ServletContext application = getServletContext();
		DataSource ds = (DataSource) application.getAttribute("dbpool");
		int result = 0;
		
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setInt(1, Integer.parseInt(id));
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String location = "S14Servlet18";
		
		if(result == 1) {
			location += "?success=true";
		} else {
			location += "success=false";
		}
		
		response.sendRedirect(location);
	}

}
