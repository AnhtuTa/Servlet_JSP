package demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class UploadFileController
 */
@WebServlet("/upload-file")
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFileController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("uploadfile.jsp").forward(request, response);
		System.out.println("doGet");
		String directoryPath = this.getServletContext().getRealPath("/");
		System.out.println("directoryPath = " + directoryPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// xử lý upload file khi người dùng nhấn nút thực hiện
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = request.getServletContext().getRealPath("") + "files";
						System.out.println("request.getServletContext().getRealPath() = " + request.getServletContext().getRealPath(""));
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						System.out.println("request.getServletContext().getRealPath() = " + request.getServletContext().getRealPath(""));
						System.out.println("dirUrl = " + dirUrl);
						System.out.println("nameimg = " + nameimg);
						
						File file = new File(fileImg);
						try {
							fileItem.write(file);
							request.setAttribute("dirUrl", dirUrl);
							request.setAttribute("nameimg", nameimg);
							request.getRequestDispatcher("upload_result.jsp").forward(request, response);
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("ĐƯỜNG DẪN KIỂM TRA UPLOAD HÌNH ẢNH : \n"+dirUrl);
							
							//try to copy file
//							File source = new File(dirUrl + "\\" + nameimg);
//							File dest = new File("C:\\Users\\AnhTu\\Desktop\\bao cao\\Desktop\\" + nameimg);
//							FileUtils.copyDirectory(source, dest);
//							System.out.println("copy OK??");
						} catch (Exception ex) {
							request.setAttribute("error", ex);
							request.getRequestDispatcher("upload_result.jsp").forward(request, response);
							System.out.println("CÓ LỖ TRONG QUÁ TRÌNH UPLOAD!");
							ex.printStackTrace();
						}
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir");
		String imageFolderPath =  workingDir + "\\WebContent\\images";
		System.out.println(workingDir);
		System.out.println(imageFolderPath);
		
		System.out.println(System.getProperty("upload.location"));
		
		UploadFileController ufc = new UploadFileController();
		String directoryPath = ufc.getServletContext().getRealPath("/");
		System.out.println("directoryPath = " + directoryPath);
	}
}