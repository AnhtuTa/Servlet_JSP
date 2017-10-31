package file_demo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtils {
	public final String DATABASE_NAME = "display_image";
    public final String USERNAME = "root";
    public final String PASSWORD = "5555";
    public final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;

	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect successfull");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	public int writeToDB(int id, String name, InputStream is, String image_name)
			throws SQLException {
		String sql = "Insert into person"
				+ " values(?,?,?,?) ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setString(2, name);
		pstm.setBlob(3, is);
		pstm.setString(4, image_name);
		return pstm.executeUpdate();
	}

	public void disConnect() {
		try {
			if(pst != null) {
				pst.close();
				pst = null;
			} else System.out.println("[DBUtils] pst already null!");
			if(rs != null) {
				rs.close();
				rs = null;
			} else System.out.println("[DBUtils] rs already null!");
			if(conn != null) {
				conn.close();
				conn = null;
			} else System.out.println("[DBUtils] conn already null!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
