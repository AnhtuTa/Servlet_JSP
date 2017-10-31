package demo;

public class StringDemo {
	public static void main(String[] args) {
		String time = "6h45 - 9h15";
		String []strs = time.split("h");
		for(String s : strs) {
			System.out.println(s);
		}
	}
}
