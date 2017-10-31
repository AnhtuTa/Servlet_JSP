package jsp_action_useBean;

public class HelloBean {
	String fullName;

	//Chú ý phải có Constructor ko tham số!
	public HelloBean() {
		
	}
	
	///////////getter và setter cho property="fullName", chú ý rằng:
	// - 2 hàm này phải có cùng property ở tên hàm, ví dụ ở dưới là fullName
	// - nếu 2 hàm này có tên khác, chẳng hạn getStupidDog và setStupidDog thì java bean sẽ tạo ra
	//	 thuộc tính property="stupidDog" dùng cả 2 hàm đ�?u thao tác đến fullName của class này!
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String name) {
		this.fullName = name;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getSayHello() {
		System.out.println("[HelloBean] Called getHello method");
		if(fullName==null) {
			return "Hello everybody!";
		} else return "Hello " + this.fullName;
	}
	
	//Hàm sau sẽ tạo ra 1 property="myProfessionalUniversity", chú ý phân biệt chữ hoa nhé! property này sẽ đc dùng bên file useBeanDemo.jsp
	public String getMyProfessionalUniversity() {
		System.out.println("[HelloBean] Called getMyProfessionalUniversity method");
		if(fullName==null || "".equals(fullName)) {
			return "Hello everybody! What are your university?";
		} else return "Hello " + this.fullName + ", your university is HUST!";
	}
}
