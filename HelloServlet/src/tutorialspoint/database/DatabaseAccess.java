package tutorialspoint.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DatabaseAccess
 */
@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DATABASE_NAME = "quan_ly_sv_ktx";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "5555";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;
    
    ResultSet rs;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		DatabaseManagement dm = new DatabaseManagement();
		dm.connect();
		rs = dm.getData();
		showData(pw);
	}
	
	public void showData(PrintWriter pw) {
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		
		pw.println(docType +
                "<html>\n" +
                "<head><title>Danh sach Sinh Vien da qua doi!</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
		                "<h1 align=\"center\">Danh sach Sinh Vien da qua doi!</h1>\n" +
		                "<table border=\"1\" align=\"center\">\n" +
		                "<tr bgcolor=\"#949494\">\n" +
		                "   <th>ID</th>" +
		                "	<th>Name</th>\n" +
		                "	<th>Sex</th>\n" +
		                "	<th>Birthday</th>\n" +
		                "	<th>Faculty</th>\n" +
		                "	<th>Khoa</th>\n" +
		                "	<th>Address</th>\n" +
		                "	<th>Room</th>\n" +
						"<tr>\n");
        try {
            while(rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String sex = rs.getString(3);
                String birth = rs.getString(4);
                String faculty = rs.getString(5);
                String khoa = rs.getString(6);
                String addr = rs.getString(7);
                String room = rs.getString(8);
                
                pw.println("<tr>"+
			               "  <td> " + id + "</td>\n" +
			               "  <td> " + name + "</td>\n" +
			               "  <td> " + sex + "</td>\n" +
			               "  <td> " + birth + "</td>\n" +
			               "  <td> " + faculty + "</td>\n" +
			               "  <td> " + khoa + "</td>\n" +
			               "  <td> " + addr + "</td>\n" +
			               "  <td> " + room + "</td>\n" +
			               "</tr>\n");
            }
            
            pw.print("</table>\n" +
    		                "</body>\n" +
    		            "</html>");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
