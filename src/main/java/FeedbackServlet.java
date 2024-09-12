import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get data
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String feedback = req.getParameter("msg");
		//store into DB
		String url = "jdbc:mysql://localhost:3306/practice";
		String user = "root";
		String password = "atv@@2303";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			String query = "insert into feedback(email,phone,msg) values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, phone);
			pstmt.setString(3, feedback);

			pstmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// response
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		pw.println("<h1 style= 'text-align:center;'>Feedback received successfully!</h1>");
		pw.println("<h2 style= 'text-align:center;'>Your form details are: </h2><h3 style= 'text-align:center;'>Email: " + email + "<br>Phone No: " + phone
				+ "<br>Feedback: " + feedback + "</h3>");

		pw.println("<div style='text-align:center;'>"
				+ "<a href='index.jsp' style='font-size: 16px; padding: 10px 20px; background-color: #007bff; color: white; text-decoration: none; border-radius: 5px; display: inline-block; cursor: pointer;'>"
				+ "Go Back" + "</a>" + "</div>");
	}

}
