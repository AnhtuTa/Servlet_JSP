package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Course;

public class CourseUtils extends DatabaseUtils {
	public List<Course> getAllCourses(int term) {
		try {
			List<Course> courseList = new ArrayList<>();
			String query = "SELECT c.id, c.Subject_id, s.name, c.term, c.dayOfWeek, c.time, c.week, c.room, c.courseType, c.Teacher_id" +
						   " FROM course c, subject s" +
						   " WHERE c.Subject_id = s.id" +
						   " AND c.term = 20171;";
			
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
        				rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
        	}
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	public Course [] getAllCoursesArray(int term) {
		
		try {
			int rsSize = 0;
			String query1 = "SELECT numOfCourse FROM qlsv_db.coursecount" +
							" WHERE term = " + term +
							" AND Faculty_id = 0;";
			
			//List<Course> courseList = new ArrayList<>();
			String query2 = "SELECT c.id, c.Subject_id, s.name, c.term, c.dayOfWeek, c.time, c.week, c.room, c.courseType, c.Teacher_id, c.note, c.maxNum, c.registeredNum" +
						   " FROM course c, subject s" +
						   " WHERE c.Subject_id = s.id" +
						   " AND c.term = " + term;
			
			pst = conn.prepareStatement(query1);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		rsSize = rs.getInt(1);
        	}
        	
        	pst = conn.prepareStatement(query2);
        	rs = pst.executeQuery();
        	
        	Course [] courses = new Course[rsSize + 10];
        	int i = 0;
        	while(rs.next()) {
        		courses[i] = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
        				rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
        				rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13));
        		i++;
        	}

            return courses;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	public static void main(String[] args) {
		CourseUtils cu = new CourseUtils();
		cu.connect();
		List<Course> courseList = cu.getAllCourses(Integer.valueOf((String) "20171"));
		for(Course c : courseList) {
			System.out.println(c.getCourseID());
		}
		
		System.out.println("=====================");
		Course [] courses = cu.getAllCoursesArray(20171);
		System.out.println("courses.length = " + courses.length);
		for(int i = 0; i < courses.length; i++) {
			if(courses[i] != null) System.out.println(i + ": " + courses[i].getCourseID() + " - " + courses[i].getSubjectName());
			else break;
		}
		
	}
}
