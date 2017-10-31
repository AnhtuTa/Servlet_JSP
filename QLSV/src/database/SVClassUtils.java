package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.SVClass;
import beans.Student;

public class SVClassUtils extends DatabaseUtils {
	final String TABLE_NAME = "svclass";

	public ResultSet getSVClassByID(int id) {
        return getRecordByID(TABLE_NAME, id);
    }
	
	public List<SVClass> getClassByID(int classID) {
		try {
			List<SVClass> clList = new ArrayList<>();
			String query = "SELECT svc.id, svc.name" +
							" FROM svclass svc" +
							" WHERE svc.id = " + classID;
			
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	int count = 0;
        	while(rs.next()) {
        		count++;
        		clList.add(new SVClass(rs.getInt(1), rs.getString(2)));
        	}
            if(count != 0) return clList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	public List<Student> getAllStudentsInClass(int classID) {
		try {
			List<Student> stList = new ArrayList<>();
			String query = "SELECT st.id, st.name" +
							" FROM student st, svclass svc" +
							" WHERE st.SVClass_id = svc.id" +
							" AND svc.id = " + classID;
			
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		stList.add(new Student(rs.getInt(1), rs.getString(2)));
        		System.out.println("svclassutils: " + rs.getString(2));
        	}
            return stList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date d = new Date(02, 10, 2017);
		Date now = new Date();
		
		System.out.println("d = "+d);
		System.out.println("now = "+now);
	}
}
