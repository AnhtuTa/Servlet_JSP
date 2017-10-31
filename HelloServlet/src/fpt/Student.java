package fpt;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
	String id;
	String name;
	int age;
	
	public Student(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getInfo() {
		return this.id + ": " + this.name + ", " + this.age;
	}
	
	public static ArrayList<Student> getStdListDemo() {
		ArrayList<Student> stList = new ArrayList<>();
		stList.add(new Student("3219", "att", 23));
		stList.add(new Student("elwa", "nguyen", 22));
		stList.add(new Student("fega", "trung anh", 11));
		stList.add(new Student("212a", "Phuong Anh le", 24));
		stList.add(new Student("eagea", "Nam", 43));
		stList.add(new Student("rr33", "Van anh", 20));

		return stList;
	}
	
	public static HashMap<String, Student> getStdMapDemo() {
		HashMap<String, Student> stMap = new HashMap<String, Student>();
		
		ArrayList<Student> stList = new ArrayList<>();
		stList.add(new Student("3219", "att", 23));
		stList.add(new Student("elwa", "nguyen", 22));
		stList.add(new Student("fega", "trung anh", 11));
		stList.add(new Student("212a", "Phuong Anh le", 24));
		stList.add(new Student("eagea", "Nam", 43));
		stList.add(new Student("rr33", "Van anh", 20));
		
		for(Student st : stList) {
			stMap.put(st.getId(), st);
		}
		
		return stMap;
	}
}
