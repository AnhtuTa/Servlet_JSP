package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserAccount;
import utils.AppUtils;
import utils.DataDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("txtUser");
		String pass = request.getParameter("txtPass");
		
		DataDAO dd = new DataDAO();
		UserAccount userAccount = dd.findUser(user, pass);
		if(userAccount == null) {
			request.setAttribute("errorWhenLogin", "Username or password is invalid!");
			request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
			//ko thể dùng response.sendRedirect... đc, vì ta cần truyền errorWhenLogin sang trang kế tiếp, mà response ko có hàm setAttribute 
			return;
		}
		
		//Nếu nhập đúng username và pass thì làm tiếp ở dưới
		AppUtils.storeLoginedUser(request.getSession(), userAccount);
		String url = (String) request.getSession().getAttribute("urlBeforeLogin");
		if(url == null || url.equals(""))	{
			response.sendRedirect(request.getContextPath()+"/userInfo");
		}
		else response.sendRedirect(request.getContextPath() + url);
	}
}