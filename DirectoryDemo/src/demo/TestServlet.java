package demo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//final String UPLOAD_FOLDER = System.getProperty("user.dir") + "\\uploads";
	//final String UPLOAD_FOLDER2 = "photos";
	final String UPLOAD_FOLDER3 = "/photos";
	//final String UPLOAD_FOLDER4 = "./photos";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("doPost");
		System.out.println("UPLOAD_FOLDER3 = " + UPLOAD_FOLDER3);
		String filePath = uploadFile(request, response);
		System.out.println("filePath = " + filePath);
		response.setContentType("text/html");
		response.getWriter().append("<h2>Upload successful!</h2><br>").append("<div>File location after uploading: <b>" + filePath + "</b></div>");
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
						File uploadFolder = new File(UPLOAD_FOLDER3);
						if (!uploadFolder.exists()) {
							uploadFolder.mkdirs();		//tạo thư mục để lưu file đc tải lên nếu nó chưa tồn tại
						}
						File uploadedFile = new File(uploadFolder + "/" + fileName);
						String fileLocation = uploadedFile.getAbsolutePath();
						System.out.println(fileLocation);
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