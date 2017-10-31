package beans;

public class Person {
	private String name;
	private String password;
	private String birthday;
	private String sex;
	private String email;
	private String phone;
	
	public Person(String name, String password, String birthday, String sex, String email, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	//////////////getters and setters////////////////
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	//////////////end of getters and setters////////////////
	
}
