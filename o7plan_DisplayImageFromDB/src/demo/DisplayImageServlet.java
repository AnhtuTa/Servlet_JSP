package demo;

import java.io.IOException;
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
 * Servlet implementation class DisplayImageServlet
 * Bài này dùng database display_image, có bảng person
 */
@WebServlet("/display-image")
public class DisplayImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final String DATABASE_NAME = "display_image";
	public final String USERNAME = "root";
	public final String PASSWORD = "5555";
	public final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private Person getImageInTable(Connection conn, int id) throws SQLException {
		String sql = "Select p.id,p.name,p.image,p.image_name " + " from Person p where p.id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String name = rs.getString("name");
			byte[] imageData = rs.getBytes("image");
			String imageFileName = rs.getString("image_name");
			return new Person(id, name, imageFileName, imageData);
		}
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		int id;
		try {
			id = Integer.valueOf(request.getParameter("id"));
		} catch (java.lang.NumberFormatException e) {
			id = 1;
		}
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect successfull");
        } catch (SQLException ex) {
            Logger.getLogger(DisplayImageServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayImageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		try {
			Person p = getImageInTable(conn, id);
			if(p == null) {
				response.sendRedirect(request.getContextPath() + "/images/noimage.jpg");
				return;
			}
			
			String imageFileName = p.getImageName();
			System.out.println("File Name: "+ imageFileName);
			
			String contentType = this.getServletContext().getMimeType(imageFileName);
			System.out.println("Content Type: "+ contentType);
			response.setHeader("Content-Type", contentType);
			response.setHeader("Content-Length", String.valueOf(p.getImage().length));
			response.setHeader("Content-Disposition", "inline; filename=\"" + p.getImageName() + "\"");
			// Ghi dữ liệu ảnh vào Response.
			response.getOutputStream().write(p.getImage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
