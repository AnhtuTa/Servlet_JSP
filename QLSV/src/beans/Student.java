package beans;

public class Student extends Person {
	private int id;
	private String educationProgram;
	private String heHoc;
	private String status;
	private String address;
	private int SVClass_id_st;
	private String SVClassName;
	private byte[] photo;
	
	private float processScore;
	private float finalScore;
	
	public Student(int id, String name, String password, String birthday, 
			String educationProgram, String heHoc, String status, String sex, String address, 
			String email, String phone, byte[] photo, int sVClass_id_st) {
		super(name, password, birthday, sex, email, phone);
		this.id = id;
		this.educationProgram = educationProgram;
		this.heHoc = heHoc;
		this.status = status;
		this.address = address;
		this.SVClass_id_st = sVClass_id_st;
		this.photo = photo;
	}

	public Student(int id, String name, String sVClassName, float processScore, float finalScore) {
		super(name);
		this.id = id;
		this.SVClassName = sVClassName;
		this.processScore = processScore;
		this.finalScore = finalScore;
	}

	public Student(int id, String name) {
		super(name);
		this.id = id;
	}

	//////////////getters and setters////////////////
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSVClass_id_st() {
		return SVClass_id_st;
	}
	public void setSVClass_id_st(int sVClass_id_st) {
		SVClass_id_st = sVClass_id_st;
	}
	
	public String getSVClassName() {
		return SVClassName;
	}

	public void setSVClassName(String sVClassName) {
		SVClassName = sVClassName;
	}

	public String getEducationProgram() {
		return educationProgram;
	}

	public void setEducationProgram(String educationProgram) {
		this.educationProgram = educationProgram;
	}

	public String getHeHoc() {
		return heHoc;
	}

	public void setHeHoc(String heHoc) {
		this.heHoc = heHoc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public float getProcessScore() {
		return processScore;
	}

	public void setProcessScore(float processScore) {
		this.processScore = processScore;
	}

	public float getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(float finalScore) {
		this.finalScore = finalScore;
	}

	//////////////end of getters and setters////////////////
}
