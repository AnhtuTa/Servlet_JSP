package servlet_staff;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.DatabaseUtils;

/**
 * Servlet implementation class ChangeStudentPhoto
 */
@WebServlet("/change-student-photo")
@MultipartConfig(fileSizeThreshold = 1024*1024*2,	//2MB
				maxFileSize = 1024*1024*10,			//10MB
				maxRequestSize = 1024*1024*50)		//50MB

public class ChangeStudentPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStudentPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("txtID", request.getParameter("studentID"));
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/staff/change_student_photo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h2 style=\"color: blue\">Opps! This feature hasn't been released yet!</h2>");
		pw.println("<div>Click <a href=\"home\">here</a> to go home");
	}

	protected String uploadFile(HttpServletRequest request, HttpServletResponse response) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// Parse the request
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = iterator.next();
					if (!item.isFormField()) {
						String fileName = item.getName();	//Tên của file đc tải lên
						File uploadFolder = new File(DatabaseUtils.STUDENT_IMAGE_FOLDER);
						if (!uploadFolder.exists()) {
							uploadFolder.mkdirs();		//tạo thư mục để lưu file đc tải lên nếu nó chưa tồn tại
						}
						File uploadedFile = new File(uploadFolder + "/" + fileName);
						String fileLocation = uploadedFile.getAbsolutePath();
						System.out.println("[ChangeStudentPhoto] fileLocation = " + fileLocation);
						item.write(uploadedFile);
						return fileLocation; // tra ve duong dan anh
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
