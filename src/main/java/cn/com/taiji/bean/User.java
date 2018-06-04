package cn.com.taiji.bean;

public class User {

	private String loginName;
	
	private String password;
	
	private Integer age;
	
	private String sex;
	
	@Override
	public String toString() {
		return "User [loginName=" + loginName + ", password=" + password + ", age=" + age + ", sex=" + sex + "]";
	}

	public User() {
		super();
	}

	public User(String loginName) {
		super();
		this.loginName = loginName;
	}

	public User(String loginName, String password, Integer age, String sex) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.age = age;
		this.sex = sex;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
