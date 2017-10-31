package model;

public class DatabaseManagement {
	public boolean checkUser(String name, String pass) {
		if("at".equals(name) && ("1".equals(pass))) {
			return true;
		}
		else return false;
	}
}
