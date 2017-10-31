package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Course;
import beans.Score;

public class ScoreboardUtils extends DatabaseUtils {
	final String TABLE_NAME = "scoreboard";

	public Set<Course> getTimetable(int studentID, int term) {
		try {
			int count = 0;
        	StringBuffer query = new StringBuffer();
        	
        	query.append("SELECT c.id, c.Subject_id, s.name, c.term, c.dayOfWeek, c.time, c.week, c.room, c.courseType, c.Teacher_id")
        		 .append(" FROM scoreboard AS sb, subject AS s, course AS c")
        		 .append(" WHERE sb.Student_id = ").append(studentID)
        		 .append(" AND c.id = sb.Course_id")
        		 .append(" AND c.term = ").append(term)
        		 .append(" AND s.id = c.Subject_id");
			pst = conn.prepareStatement(query.toString());
			rs = pst.executeQuery();

			Set<Course> courseSet = new TreeSet<>();
			while(rs.next()) {
				count++;
				courseSet.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
        				rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
			if(count != 0)	return courseSet;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	public List<Score> getScoreByID(int studentID, int term) {
		try {
			List<Score> scoreList = new ArrayList<>();
			String query = "SELECT DISTINCT sb.Student_id, c.term, c.Subject_id, sub.name, sub.credit, c.id, sb.processScore, sb.finalScore, sb.overall, sb.letterScore" +
							" FROM scoreboard AS sb, course AS c, subject AS sub" +
							" WHERE sb.Course_id = c.id" +
							" AND c.Subject_id = sub.id" +
							" AND sb.Student_id = " + studentID + " AND c.term = " + term +
							" AND sb.processScore > -1";
			
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		Score s = new Score(studentID, term, rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getString(10));
        		scoreList.add(s);
        	}
            return scoreList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	public List<Score> getAllScoresByID(int studentID) {
		try {
			List<Score> scoreList = new ArrayList<>();
			String query = "SELECT DISTINCT sb.Student_id, c.term, c.Subject_id, sub.name, sub.credit, c.id, sb.processScore, sb.finalScore, sb.overall, sb.letterScore" +
							" FROM scoreboard AS sb, course AS c, subject AS sub" +
							" WHERE sb.Course_id = c.id" +
							" AND c.Subject_id = sub.id" +
							" AND sb.Student_id = " + studentID +
							" AND sb.processScore > -1";
			
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		Score s = new Score(studentID, rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getString(10));
        		scoreList.add(s);
        	}
            return scoreList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	public boolean updateScore(int studentID, int courseID, float processScore, float finalScore) {
		//UPDATE `qlsv_db`.`scoreboard` SET `processScore`='2', `finalScore`='4', `overall`='2', `letterScore`='D' WHERE `Student_id`='20131002' and`Course_id`='90001';
		try {
			float overall = (float) (processScore*0.3 + finalScore*0.7);
			String letterScore = "F";
			if(overall < 4) letterScore = "F";
			else if(overall < 5) letterScore = "D";
			else if(overall < 5.5) letterScore = "D+";
			else if(overall < 6.5) letterScore = "C";
			else if(overall < 7) letterScore = "C+";
			else if(overall < 8) letterScore = "B";
			else if(overall < 8.5) letterScore = "B+";
			else if(overall < 9.5) letterScore = "A";
			else if(overall <= 10) letterScore = "A+";
			
			System.out.println("overall = " + overall);
			String query = "UPDATE scoreboard" +
						   " SET processScore=" + processScore +
						   ", finalScore=" + finalScore +
						   ", overall=" + overall +
						   ", letterScore=\"" + letterScore + "\"" +
						   "  WHERE Student_id=" + studentID +
						   " AND Course_id=" + courseID;
			
        	pst = conn.prepareStatement(query);
        	int kq = pst.executeUpdate();
        	if(kq > 0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
	}
	
	public static void main(String[] args) {
		ScoreboardUtils su = new ScoreboardUtils();
		su.connect();
//		List<Score> scList = su.getScoreByID(20134509, 20162);
//		for(Score s : scList) {
//			System.out.println(s.getSubjectName());
//		}
		
		Set<Course> cList = su.getTimetable(20134509, 20161);
		for(Course c : cList) {
			System.out.println(c.getCourseID() + " - " + c.getSubjectName() + " - " + c.getDayOfWeek() + " - " + c.getTime());
		}
	}
}
