package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Subject;

public class SubjectUtils extends DatabaseUtils {
	public final String TABLE_NAME = "subject";
	
	public List<Subject> getAllSubjects() {
		try {
			List<Subject> subjectList = new ArrayList<>();
        	rs = getAllRecords(TABLE_NAME);
        	while(rs.next()) {
        		subjectList.add(new Subject(rs.getString(1), rs.getString(2), rs.getInt(3),
        				rs.getFloat(4), rs.getFloat(5), rs.getString(6), rs.getInt(7)));
        	}
            return subjectList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}

	public static void main(String[] args) {
		SubjectUtils su = new SubjectUtils();
		su.connect();
		List<Subject> subList = su.getAllSubjects();
		for(Subject s : subList) {
			System.out.println(s.getId() + " - " + s.getName() + " - " + s.getFaculty_id());
		}
		
	}
}
