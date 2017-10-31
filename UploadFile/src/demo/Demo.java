package demo;

public class Demo {

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir");
		String imageFolderPath =  workingDir + "\\WebContent\\images";
		System.out.println(workingDir);
		System.out.println(imageFolderPath);
		
		System.out.println(System.getProperty("upload.location"));
	}
}
