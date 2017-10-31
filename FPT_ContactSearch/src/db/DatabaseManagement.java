package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import objects.Contact;

/**
 *
 * @author AnhTu
 */
public class DatabaseManagement {
    public final String DATABASE_NAME = "contact";
    public final String USERNAME = "root";
    public final String PASSWORD = "5555";
    public final String URL_MYSQL = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;
    
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL_MYSQL, USERNAME, PASSWORD);
            System.out.println("Connect successfull");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getData() {
    	Connection conn = connect();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM contact_tb");
            ResultSet rs = pst.executeQuery();
            
            return rs;
            //pst.close();
            //conn.close();  sẽ có lỗi nếu close: java.sql.SQLException: Operation not allowed after ResultSet closed
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Contact getContactByPhone(String phone) {
    	Connection conn = connect();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM contact_tb WHERE phone=\""+phone+"\"");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
            	return new Contact(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            //pst.close();
            //conn.close();  sẽ có lỗi nếu close: java.sql.SQLException: Operation not allowed after ResultSet closed
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /*
    public void insertRecord(Student st) {
        try {
            pst = conn.prepareCall("INSERT INTO student VALUES ('"+st.id+"', '"+st.name+"', '"+st.phone+"')");
            int kq = pst.executeUpdate();
            if(kq > 0) System.out.println("Insert successful!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showData(ResultSet rs2) {
        Student st;
        try {
            while(rs2.next()) {
                int id = rs2.getInt(1);
                String name = rs2.getString(2);
                String phone = rs2.getString(3);
                
                st = new Student(id, name, phone);
                st.displayStudentInfo();
                System.out.println("-----------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void close() {
        try {
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    public static void main(String[] args) {
		DatabaseManagement dm = new DatabaseManagement();
		dm.connect();
	}
}
