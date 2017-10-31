package utils;

import bean.UserAccount;
import config.SecurityConfig;

import java.util.HashMap;
import java.util.Map;

//Lớp DataDAO được sử dụng để truy vấn dữ liệu trong Database (Mô phỏng)
public class DataDAO {
	private final Map<String, UserAccount> userMap = new HashMap<>();
	
	public DataDAO() {
		initUsers();
	}
	
	private void initUsers() {
		// User này có 1 vai trò là EMPLOYEE.
		UserAccount emp = new UserAccount("employee1", "123", SecurityConfig.ROLE_EMPLOYEE);
		
		// User này có 1 vai trò là MANAGER.
		UserAccount manager = new UserAccount("manager1", "123", SecurityConfig.ROLE_MANAGER);
		
		// User này có 2 vai trò EMPLOYEE và MANAGER.
		UserAccount admin = new UserAccount("admin", "123", SecurityConfig.ROLE_EMPLOYEE, SecurityConfig.ROLE_MANAGER);
		
		// User này có 1 vai trò ADMIN
		UserAccount admin2 = new UserAccount("admin2", "123", SecurityConfig.ROLE_ADMIN);
		
		userMap.put(emp.getUsername(), emp);
		userMap.put(manager.getUsername(), manager);
		userMap.put(admin.getUsername(), admin);
		userMap.put(admin2.getUsername(), admin2);
	}
	
	public UserAccount findUser(String user, String pass) {
		UserAccount ua = userMap.get(user);
		if(ua != null && pass.equals(ua.getPassword())) return ua;
		return null;
	}
}
