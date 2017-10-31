package servlet_person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.StudentUtils;
import servlet_login.LoginServlet;
import servlet_login.SelectRoleServlet;

/**
 * Servlet implementation class EditInformation
 */
@WebServlet("/EditInformation")
public class EditInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/edit_info_" + SelectRoleServlet.roleOfUser + ".jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (SelectRoleServlet.roleOfUser) {
			case SelectRoleServlet.ROLE_STUDENT:
				updateStudentInfo(request, response);
				break;
	
			default:
				break;
		}
	}

	private void updateStudentInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String sex = request.getParameter("txtSex");
		String addr = request.getParameter("txtAddr");
		String email = request.getParameter("txtEmali");
		String phone = request.getParameter("txtPhone");
		
		StudentUtils su = new StudentUtils();
		su.connect();
		int kq = su.updateStudent(LoginServlet.loginedStudent.getId(), sex, addr, email, phone);
		if(kq > 0) {
			su.disConnect();
			request.setAttribute("result_update_info", "Update successful! See results below");
			
			//Thiết lập các giá trị ntnay để ko cần truy cập CSDL lấy info nữa, dù info trong CSDL đã thay đổi!
			LoginServlet.loginedStudent.setSex(sex);
			LoginServlet.loginedStudent.setAddress(addr);
			LoginServlet.loginedStudent.setEmail(email);
			LoginServlet.loginedStudent.setPhone(phone);

			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/personal_info_student.jsp").forward(request, response);
			//Khong the dung:
			//request.getServletContext().getRequestDispatcher("/personal-information").forward(request, response);
		}
	}
}
