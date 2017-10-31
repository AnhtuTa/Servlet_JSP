package file_demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadToDBServlet
 * Bài này dùng database display_image, có bảng person
 */
@WebServlet("/UploadToDB")
@MultipartConfig(fileSizeThreshold = 1024*1024*2,	//2MB
				maxFileSize = 1024*1024*10,			//10MB
				maxRequestSize = 1024*1024*50)		//50MB

public class UploadToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadToDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadToDB.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		DatabaseUtils du = new DatabaseUtils();
		String id = request.getParameter("id");
		System.out.println("id = " + id);
		conn = du.connect();
		try {
			conn.setAutoCommit(false);
			// Danh mục các phần đã upload lên (Có thể là nhiều file).
			//for (Part part : request.getParts()) {
				Part part = request.getPart("photoPart");
				String fileName = extractFileName(part);
				System.out.println("fileName = " + fileName);
				if (fileName != null && fileName.length() > 0) {
		            System.out.println(part.getName());
		            System.out.println(part.getSize());
					// Dữ liệu file.
					InputStream is = part.getInputStream();
					// Ghi vào file.
					du.writeToDB(Integer.valueOf(id), "demo file", is, fileName);
				}
			//}
			conn.commit();
			
			// Upload thành công.
			response.sendRedirect(request.getContextPath() + "/uploadToDBResults");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error: " + e.getMessage());
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadToDB.jsp").forward(request, response);
		} finally {
			du.disConnect();
		}
	}

	private String extractFileName(Part part) {
		// form-data; name="file"; filename="C:\file1.zip"
		// form-data; name="file"; filename="C:\Note\file2.zip"
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("contentDisp = " + contentDisp);
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				System.out.println("s = " + s);
				// C:\file1.zip
				// C:\Note\file2.zip
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				// file1.zip
				// file2.zip
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}
}
