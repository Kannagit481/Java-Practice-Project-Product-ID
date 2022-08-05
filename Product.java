import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Product() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				PrintWriter out=response.getWriter();
				Connection con=DatabaseConnection.getMyConnection();
				String id = request.getParameter("id");
				String str="select * from eproduct where id="+id;
				Statement  ps=con.createStatement();
				ResultSet ans =ps.executeQuery(str);
				
				if(ans.next()) {
					out.println("<table border=3>");
					out.println("<tr><th>ID</th><th>Name</th><th>price</th><th>date_added</th></tr>");
					out.println("<tr>");
					out.print("<td>"+ans.getInt("ID")+"</td>");
					out.print("<td>"+ans.getString("name")+"</td>");
					out.print("<td>"+ans.getBigDecimal("price")+"</td>");
					out.print("<td>"+ans.getTimestamp("date_added")+"</td>");
					out.println("</tr>");
					out.println("</table>");
				}
				else {
				out.println("No records found!");
				}
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}







