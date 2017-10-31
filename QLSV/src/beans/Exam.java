package beans;

public class Exam {
	int examID;
	int courseID;
	String subjectName;
	String day;
	String room;
	int kip;
	
	public Exam(int examID, int courseID, String subjectName, String day, String room, int kip) {
		this.examID = examID;
		this.courseID = courseID;
		this.subjectName = subjectName;
		this.day = day;
		this.room = room;
		this.kip = kip;
	}

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getKip() {
		return kip;
	}

	public void setKip(int kip) {
		this.kip = kip;
	}
	
	
}
