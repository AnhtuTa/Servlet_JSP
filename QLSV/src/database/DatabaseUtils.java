package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtils {
	public static final String STUDENT_IMAGE_FOLDER = "D:\\eclipse\\projects\\QLSV\\data\\student";
	public static final String TEACHER_IMAGE_FOLDER = "D:\\eclipse\\projects\\QLSV\\data\\teacher";
	
//	public final String DATABASE_NAME = "qlsv_db";
//    public final String USERNAME = "root";
//    public final String PASSWORD = "5555";
//    public final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=UTF-8";;

	public final String HOST = "node161425-env-8604798.j.layershift.co.uk";
	public final String DATABASE_NAME = "qlsv_db";
    public final String USERNAME = "root";
    public final String PASSWORD = "RARbvt66472";
    public final String URL = "jdbc:mysql://" + HOST + "/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=UTF-8";
	
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
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	protected ResultSet getAllRecords(String tableName) {
        try {
        	pst = conn.prepareStatement("SELECT * FROM " + tableName);
        	rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	protected ResultSet getRecordByID(String tableName, int id) {
        try {
        	pst = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE id = " + id);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	protected int changeUserPassword(String tableName, int id, String newPassword) {
		try {
        	pst = conn.prepareStatement("UPDATE " + tableName + " SET password=? WHERE id=?");
        	pst.setString(1, newPassword);
        	pst.setInt(2, id);
        	
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
	
	//kiem tra tai khoan khi login
	public Object check(int ID, String pass) {
		return null;
	}
}
