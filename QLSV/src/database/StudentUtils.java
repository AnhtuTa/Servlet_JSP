package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Student;

public class StudentUtils extends DatabaseUtils {
	final String TABLE_NAME = "student";
	
	//===================check students===================
	@Override
	public Student check(int ID, String pass) {
		try {
        	pst = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = " + ID + " AND password = \"" + pass + "\"");
        	rs = pst.executeQuery();
        	rs.next();
        	Student st = new Student(ID, rs.getString(2), rs.getString(3), rs.getString(4),
        			rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
        			rs.getString(9), rs.getString(10), rs.getString(11), null, rs.getInt(13));
        	
        	//lấy tên lớp của sinh viên
        	pst = conn.prepareStatement("SELECT name FROM svclass WHERE id = " + st.getSVClass_id_st());
        	rs = pst.executeQuery();
        	rs.next();
        	st.setSVClassName(rs.getString(1));
        	return st;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	//====================================================
	
	//===================get students===================
	public ResultSet getAllStudents() {
		return getAllRecords(TABLE_NAME);
	}
	
	public String getStudentNameByID(int studentID) {
		try {
        	pst = conn.prepareStatement("SELECT name FROM " + TABLE_NAME + " WHERE id = " + studentID);
        	rs = pst.executeQuery();
        	rs.next();
        	return rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	
	public Student getStudentByID(int studentID) {
		try {
        	pst = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = " + studentID);
        	rs = pst.executeQuery();
        	rs.next();
        	Student st = new Student(studentID, rs.getString(2), rs.getString(3), rs.getString(4),
        			rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
        			rs.getString(9), rs.getString(10), rs.getString(11), null, rs.getInt(13));
        	
        	//lấy tên lớp của sinh viên
        	pst = conn.prepareStatement("SELECT name FROM svclass WHERE id = " + st.getSVClass_id_st());
        	rs = pst.executeQuery();
        	rs.next();
        	st.setSVClassName(rs.getString(1));
        	return st;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
    }

	public List<Student> getStudentByCourseID(int courseID) {
		try {
			List<Student> stList = new ArrayList<>();
			String query = "SELECT st.id, st.name, svc.name, sb.processScore, sb.finalScore" +
							" FROM student st, course c, scoreboard sb, svclass svc" +
							" WHERE c.id = " + courseID +
							" AND sb.Course_id = c.id" +
							" AND sb.Student_id = st.id" +
							" AND svc.id = st.SVClass_id" +
							" group by st.id;";
        	pst = conn.prepareStatement(query);
        	rs = pst.executeQuery();
        	while(rs.next()) {
        		stList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5)));
        	}
        	
        	return stList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko can quan tam den ngoai le nay!");
            return null;
        }
	}
	//==================================================
	
	//===================update students===================
	public int updateStudent(int studentID, String sex, String address, String email, String phone) {
		try {
        	pst = conn.prepareStatement("UPDATE student SET sex=?, address=?, email=?, phone=? WHERE id=?");
        	pst.setString(1, sex);
        	pst.setString(2, address);
        	pst.setString(3, email);
        	pst.setString(4, phone);
        	pst.setInt(5, studentID);
        	
            return pst.executeUpdate();		//Trả về số lượng bản ghi đã đc update
        } catch (SQLException ex) {
            Logger.getLogger(StudentUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
	}
	
	public int changeStudentPassword(int studentID, String newPassword) {
		return changeUserPassword(TABLE_NAME, studentID, newPassword);
	}

	public void showStudentsInfo(ResultSet rs) {
		try {
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(8));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
