package model;

public class DatabaseManagement {
	public static boolean checkUser(String user, String pass) {
		return ("at".equals(user) && "1".equals(pass));
	}
}
