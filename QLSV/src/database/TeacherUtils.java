package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Course;
import beans.Teacher;

public class TeacherUtils extends DatabaseUtils {
	final String TABLE_NAME = "academicstaff";
	
	public Teacher check(String ID, String pass) {
		try {
			String query = "SELECT tc.id, tc.name, tc.password, tc.birthday, tc.sex, tc.email," +
							" tc.phone, dept.name, fac.name, tc.workplace, tc.website" +
							" FROM teacher AS tc, department AS dept, faculty AS fac" +
							" WHERE tc.id = \"" + ID + "\"" +
							" AND tc.password = \"" + pass + "\"" +
							" AND tc.Department_id = dept.id" +
							" AND dept.Faculty_id = fac.id";
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	rs.next();
        	Teacher tc = new Teacher(ID, rs.getString(2), rs.getString(3), rs.getString(4),
        			rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
        			rs.getString(9), rs.getString(10), rs.getString(11));
        	return tc;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	
	public String getTeacherNameByID(String teacherID) {
		try {
			String query = "SELECT tc.name FROM teacher AS tc WHERE tc.id = \"" + teacherID + "\"";
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	rs.next();
        	return rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	
	public List<Teacher> getTeachersLikeID(String teacherID) {
		List<Teacher> tcList = new ArrayList<>();
		try {
			String query = "SELECT tc.id, tc.name" +
							" FROM teacher AS tc" +
							" WHERE tc.id LIKE \"%" + teacherID + "%\"";
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		tcList.add(new Teacher(rs.getString(1), rs.getString(2)));
        	}
        	
        	return tcList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	
	public List<Teacher> getTeachersLikeName(String teacherName) {
		List<Teacher> tcList = new ArrayList<>();
		try {
			String query = "SELECT tc.id, tc.name" +
							" FROM teacher AS tc" +
							" WHERE tc.name LIKE \"%" + teacherName + "%\"";
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		tcList.add(new Teacher(rs.getString(1), rs.getString(2)));
        	}
        	
        	return tcList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	
	public List<Teacher> getTeachersLikeIDAndName(String teacherID, String teacherName) {
		List<Teacher> tcList = new ArrayList<>();
		try {
			String query = "SELECT tc.id, tc.name" +
					" FROM teacher AS tc" +
					" WHERE tc.id LIKE \"%" + teacherID + "%\"" +
					" AND tc.name LIKE \"%" + teacherName + "%\"";
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		tcList.add(new Teacher(rs.getString(1), rs.getString(2)));
        	}
        	
        	return tcList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	
	public Teacher getTeachersByID(String teacherID) {
		try {
			String query = "SELECT tc.id, tc.name, tc.password, tc.birthday, tc.sex, tc.email," +
							" tc.phone, dept.name, fac.name, tc.workplace, tc.website" +
							" FROM teacher AS tc, department AS dept, faculty AS fac" +
							" WHERE tc.id = \"" + teacherID + "\"" +
							" AND tc.Department_id = dept.id" +
							" AND dept.Faculty_id = fac.id";
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	rs.next();
        	return new Teacher(teacherID, rs.getString(2), rs.getString(3), rs.getString(4),
            			rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
            			rs.getString(9), rs.getString(10), rs.getString(11));
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	
	public Set<Course> getTeachingSchedule(String teacherID, int term) {
		try {
			int count = 0;
        	StringBuffer query = new StringBuffer();
        	
        	query.append("SELECT c.id, c.Subject_id, s.name, c.term, c.dayOfWeek, c.time, c.week, c.room, c.courseType, c.Teacher_id")
        		 .append(" FROM course AS c, subject AS s")
        		 .append(" WHERE c.Teacher_id = \"" + teacherID + "\"")
        		 .append(" AND c.term = ").append(term)
        		 .append(" AND c.Subject_id = s.id;");
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
	
	public List<Course> getCourseForSubmitScore(String teacherID, int term) {
		try {
			int count = 0;
        	StringBuffer query = new StringBuffer();
        	
        	query.append("SELECT DISTINCT c.id, c.Subject_id, s.name")
        		 .append(" FROM course AS c, subject AS s")
        		 .append(" WHERE c.Teacher_id = \"" + teacherID + "\"")
        		 .append(" AND c.term = ").append(term)
        		 .append(" AND c.Subject_id = s.id;");
			pst = conn.prepareStatement(query.toString());
			rs = pst.executeQuery();

			List<Course> courseList = new ArrayList<>();
			while(rs.next()) {
				count++;
				courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			if(count != 0)	return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	public static void main(String[] args) {
		TeacherUtils tu = new TeacherUtils();
		tu.connect();
		Set<Course> cSet = tu.getTeachingSchedule("nampn", 20171);
		for(Course c : cSet) {
			System.out.println(c.getCourseID() + " - " + c.getSubjectName() + " - " + c.getDayOfWeek() + " - " + c.getTime());
		}
		
		System.out.println("=====================");
		
		List<Course> cSet2 = tu.getCourseForSubmitScore("nampn", 20171);
		for(Course c : cSet2) {
			System.out.println(c.getCourseID() + " - " + c.getSubjectID() + " - " + c.getSubjectName() + " - " + c.getDayOfWeek() + " - " + c.getTime());
		}
	}
}
