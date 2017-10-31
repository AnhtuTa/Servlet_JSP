package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Exam;

public class ExamUtils extends DatabaseUtils {
	public List<Exam> getExamSchedule(int studentID, int term) {
		try {
			List<Exam> examList = new ArrayList<>();
			String query = "SELECT DISTINCT es.id, es.Course_id, sub.name, es.day, es.room, es.kip" +
							" FROM examschedule es, scoreboard sb, course c, subject sub" +
							" WHERE sb.Student_id = " + studentID +
							" AND es.Course_id = sb.Course_id" +
							" AND c.id = sb.Course_id" +
							" AND sub.id = c.Subject_id" +
							" AND c.term = " + term;
			
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		examList.add(new Exam(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
        	}
            return examList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
}
