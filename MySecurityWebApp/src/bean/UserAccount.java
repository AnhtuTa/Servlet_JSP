package bean;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
	private String username;
	private String password;
	private List<String> roles;
	
	public UserAccount() {
		//JavaBean bat buoc phai co constructor ko tham so!
	}
	
	public UserAccount(String userName, String passWord, String... roles) {
		this.username = userName;
		this.password = passWord;
		this.roles = new ArrayList<String>();
		
		if(roles != null) {
			for(String role : roles) {
				this.roles.add(role);
			}
		}
	}

	/////getters and setters////////////
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	/////end getters and setters////////////
	
}
