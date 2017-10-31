package tutorialspoint.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManagement {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DATABASE_NAME = "quan_ly_sv_ktx";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "5555";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;
    
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public Connection connect() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			System.out.println("Connect success!");
		} catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Loi ket noi!");
        } 
		catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
		return conn;
	}
    
    public ResultSet getData() {
        try {
            pst = conn.prepareStatement("SELECT * FROM sinhvien");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void close() {
        try {
        	conn.close();
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
		DatabaseManagement dm = new DatabaseManagement();
		dm.connect();
	}
}
