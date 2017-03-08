package member.domain;

import java.sql.Date;

public class Member {

	
	private int no;
	private String email, password, name;
	private Date regDate;
	@Override
	public String toString() {
		return "Member [no=" + no + ", email=" + email + ", password=" + password + ", name=" + name + ", regDate="
				+ regDate + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
