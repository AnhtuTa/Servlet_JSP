package database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Staff;

public class StaffUtils extends DatabaseUtils {
	final String TABLE_NAME = "academicstaff";
	
	public Staff check(String ID, String pass) {
		try {
        	pst = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = \"" + ID + "\" AND password = \"" + pass + "\"");
        	rs = pst.executeQuery();
        	rs.next();
        	Staff as = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
        	return as;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
}
