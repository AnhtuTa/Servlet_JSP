package databases;

import java.sql.Connection;

public class ConnectionUtils {
	public static Connection getConnection() {
		// Tạo một Connection (kết nối) tới Database.
		Connection conn = null;

		// .....
		return conn;
	}
	
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
