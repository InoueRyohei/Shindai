package bean;

public class Teacher implements java.io.Serializable {
	
	private String id;
	private String name;
	private String password;
	private String school_cd;

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getSchool_cd() {
		return school_cd;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setSchool_cd(String school_cd) {
		this.school_cd=school_cd;
	}
}
