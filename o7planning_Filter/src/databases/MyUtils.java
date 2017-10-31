package databases;

import java.sql.Connection;

import javax.servlet.ServletRequest;

public class MyUtils {
	public static final String ATT_NAME = "MY_CONNECTION_ATTRIBUTE";

	// Lưu trữ đối tượng Connection vào một thuộc tính (attribute) của request.
	// Thông tin lưu trữ chỉ tồn tại trong thời gian yêu cầu (request)
	// cho tới khi dữ liệu được trả về trình duyệt người dùng.
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME, conn);
	}

	// Lấy đối tượng Connection đã được lưu trữ trong 1 thuộc tính của request.
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME);
		return conn;
	}
}
