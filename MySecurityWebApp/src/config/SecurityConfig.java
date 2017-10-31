package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Lớp SecurityConfig giúp cấu hình các vai trò và các chức năng (các trang) được phép truy cập ứng với vai trò đó 
public class SecurityConfig {
	public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_ADMIN = "ADMIN";

    private final Map<String, List<String>> configRoleMap = new HashMap<>();
    
    public SecurityConfig() {
    	initConfig();
    }

    //Demo data trong CSDL, Nếu lưu trong CSDL thì ko cần hàm này nữa
	private void initConfig() {
		List<String> employeeUrlPattern = new ArrayList<>();
		employeeUrlPattern.add("/userInfo");
		employeeUrlPattern.add("/employeeTask");	//Nếu là employee thì chỉ đc vào 2 URL này thôi
		
		List<String> managerUrlPattern = new ArrayList<>();
		managerUrlPattern.add("/userInfo");
		managerUrlPattern.add("/managerTask");	//Nếu là manager thì chỉ đc vào 2 URL này thôi
		
		List<String> adminUrlPattern = new ArrayList<>();
		adminUrlPattern.add("/userInfo");
		adminUrlPattern.add("/employeeTask");
		adminUrlPattern.add("/managerTask");	//Nếu là admin thì đc vào 3 URL này
		
		configRoleMap.put(ROLE_EMPLOYEE, employeeUrlPattern);
		configRoleMap.put(ROLE_MANAGER, managerUrlPattern);
		configRoleMap.put(ROLE_ADMIN, adminUrlPattern);
	}
	
	public Set<String> getAllRoles() {
		return configRoleMap.keySet();
	}
	
	public List<String> getUrlPatternsForRole(String role) {
		return configRoleMap.get(role);
	}
}
