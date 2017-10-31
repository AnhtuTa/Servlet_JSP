package tutorialspoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class GetLocale
 */
@WebServlet("/GetLocale")
public class GetLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the client's Locale
		Locale locale = request.getLocale();
		String language = locale.getLanguage();
		String country = locale.getCountry();

		//Định dạng Date cụ thể cho Locale trong Servlet
		String date = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, locale).format(new Date());
//		JOptionPane.showMessageDialog(null, date);
		
		//Định dạng Currency cụ thể cho Locale trong Servlet
		NumberFormat nft = NumberFormat.getCurrencyInstance(locale);
		String formatedCurrency = nft.format(1000000);
		
		//Định dạng Percentage cụ thể cho Locale trong Servlet
		String formatedPercentage = nft.format(0.92);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\n" +
					"<html>\n" +
						"<head>\n" +
							"<meta charset=\"UTF-8\">\n" +
							"<title>Locale demo</title>\n" +
						"</head>\n" +
						"<body>\n");
		out.println("<h1>Đây là ví dụ về Locale</h1>\n");
		out.println("<h2 align=\"center\">" + language + "</h2>\n" +
					"<h2 align=\"center\">" + country + "</h2>\n");
		out.println("<h2 align=\"center\">" + date + "</h2>\n");
		out.println("<h2 align=\"center\">" + formatedCurrency + "</h2>\n");
		out.println("<h2 align=\"center\">" + formatedPercentage + "</h2>\n");
		
		out.print("</body></html>");
		
		String message = "date = "+date+"\n"+
						"formatedCurrency = "+formatedCurrency+"\n"+
						"formatedPercentage = "+formatedPercentage+"\n";
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
