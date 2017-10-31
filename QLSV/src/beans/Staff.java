package beans;

public class Staff extends Person {
	String id;
	
	public Staff(String id, String name, String password, String birthday, String sex, String email, String phone) {
		super(name, password, birthday, sex, email, phone);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
