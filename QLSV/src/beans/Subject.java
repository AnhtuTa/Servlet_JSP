package beans;

public class Subject {
	String id;
	String name;
	int credit;
	float feeCredit;
	float weight;
	String teachingWeight;
	int Faculty_id;
	
	public Subject() {}

	public Subject(String id, String name, int credit, float feeCredit, float weight, String teachingWeight,
			int faculty_id) {
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.feeCredit = feeCredit;
		this.weight = weight;
		this.teachingWeight = teachingWeight;
		Faculty_id = faculty_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public float getFeeCredit() {
		return feeCredit;
	}

	public void setFeeCredit(float feeCredit) {
		this.feeCredit = feeCredit;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getTeachingWeight() {
		return teachingWeight;
	}

	public void setTeachingWeight(String teachingWeight) {
		this.teachingWeight = teachingWeight;
	}

	public int getFaculty_id() {
		return Faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		Faculty_id = faculty_id;
	}
	
	
}
