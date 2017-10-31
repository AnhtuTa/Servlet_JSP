package beans;

public class Teacher extends Person {
	String id;
	String department;
	String faculty;
	String workplace;
	String website;
	
	public Teacher(String id, String name, String password, String birthday, String sex, String email, String phone,
			String department, String faculty, String workplace, String website) {
		super(name, password, birthday, sex, email, phone);
		this.id = id;
		this.department = department;
		this.faculty = faculty;
		this.workplace = workplace;
		this.website = website;
	}

	public Teacher(String teacherID, String teacherName) {
		super(teacherName, null, null, null, null, null);
		this.id = teacherID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	
}
