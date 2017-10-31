package demo;

public class Person {
	private int id;
	private String name;
	private byte[] image;
	private String imageName;

	public Person() {}

	public Person(int id, String name, String imageFileName, byte[] imageData) {
		this.id = id;
		this.name = name;
		this.image = imageData;
		this.imageName = imageFileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	
}
