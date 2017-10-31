package beans;

public class Course implements Comparable<Course> {
	int courseID;
	String subjectID;
	int term;
	int dayOfWeek;
	String time;
	String subjectName;
	String room;
	String courseType;
	String week;
	String note;
	String status;
	int maxNum;
	int registeredNum;
	String facultyName;
	String teacherID;
	
	public Course(int courseID, String subjectID, String subjectName, int term,
			int dayOfWeek, String time, String week, String room,
			String courseType, String teacherID, String note, int maxNum, int registeredNum) {
		this.courseID = courseID;
		this.subjectID = subjectID;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.subjectName = subjectName;
		this.room = room;
		this.courseType = courseType;
		this.week = week;
		this.term = term;
		this.teacherID = teacherID;
		this.note = note;
		this.maxNum = maxNum;
		this.registeredNum = registeredNum;
	}
	
	public Course(int courseID, String subjectID, String subjectName, int term,
			int dayOfWeek, String time, String week, String room,
			String courseType, String teacherID) {
		this.courseID = courseID;
		this.subjectID = subjectID;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.subjectName = subjectName;
		this.room = room;
		this.courseType = courseType;
		this.week = week;
		this.term = term;
		this.teacherID = teacherID;
	}
	
	public Course(int courseID, String subjectID, String subjectName) {
		this.courseID = courseID;
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}

	@Override
	public int compareTo(Course obj) {
		if(this.dayOfWeek > obj.dayOfWeek) return 1;
		else if(this.dayOfWeek < obj.dayOfWeek) return -1;
		else {
			int t1 = Integer.valueOf(this.time.split("h")[0]);
			int t2 = Integer.valueOf(obj.time.split("h")[0]);
			if(t1 > t2) return 1;
			else if(t1 < t2) return -1;
			else return this.getSubjectName().compareTo(obj.getSubjectName());
		}
	}
	
	///////////////getters and setters//////////////////
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public int getRegisteredNum() {
		return registeredNum;
	}

	public void setRegisteredNum(int registeredNum) {
		this.registeredNum = registeredNum;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	
	///////////////end of getters and setters//////////////////
}
