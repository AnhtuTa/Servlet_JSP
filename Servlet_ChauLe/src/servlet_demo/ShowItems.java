package servlet_demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowItems
 */
@WebServlet(urlPatterns={"/show-items"})
public class ShowItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			@SuppressWarnings("unchecked")
			List<String> prevItems = (List<String>) session.getAttribute("prevItems");
			if(prevItems==null) {	//nếu ban đầu chưa có session nào thì khởi tạo cái list chứa session
				prevItems = new ArrayList<>();
			}
			
			String newItem = request.getParameter("new_item");	//lấy data từ form
			if(newItem != null && !newItem.trim().equals("")) {
				prevItems.add(newItem);
				session.setAttribute("prevItems", prevItems);
			}
			printItems(response, prevItems);
		}
	}

	private void printItems(HttpServletResponse response, List<String> prevItems) throws IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		if(prevItems.size()==0) {
			pw.println("No item! hehe");
		} else {
			pw.println("<ul>");
			for(String item : prevItems) {
				pw.println("<li>" + item + "</li>");
			}
			pw.println("</ul>");
		}
	}
}
