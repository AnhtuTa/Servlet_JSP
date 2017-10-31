package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvailableTerm extends DatabaseUtils {
	final String TABLE_NAME = "availableterm";

	public List<Integer> getAllTerms() {
		try {
        	pst = conn.prepareStatement("SELECT * FROM " + TABLE_NAME);
            rs = pst.executeQuery();
            List<Integer> termList = new ArrayList<>();
            while(rs.next()) {
            	termList.add(rs.getInt(1));
            }
            return termList;
        } catch (SQLException ex) {
            Logger.getLogger(AvailableTerm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	public static void main(String[] args) {
		AvailableTerm at = new AvailableTerm();
		at.connect();
		at.getAllTerms();
	}
}
