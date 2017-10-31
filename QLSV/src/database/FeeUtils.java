package database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Fee;

public class FeeUtils extends DatabaseUtils {
	final String TABLE_NAME = "fee";
	
	public Fee getStudentFee(int studentID, int term) {
		try {
        	pst = conn.prepareStatement("SELECT * FROM fee WHERE Student_id = " + studentID + " AND term = " + term);
        	rs = pst.executeQuery();
        	rs.next();
        	return new Fee(studentID, term, rs.getInt(3), rs.getInt(4),
        			rs.getInt(5), rs.getInt(6), rs.getInt(7));
        	
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
}
