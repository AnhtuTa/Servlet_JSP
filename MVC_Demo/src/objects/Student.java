package objects;

public class Student implements Person {
	String name;

	//Chú ý phải có Constructor ko tham số!
	public Student() {}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void printHello() {
		System.out.println("Hello, I'm "+this.name);
	}
	
}
