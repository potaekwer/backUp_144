package blog.domain;

public class Author {

	private String id;
	private String name;
	private String password;
	private String email;

	public Author() {
	}

	public Author(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEqualsPassword(String password) {
		if (this.password != null && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return new StringBuilder().append("{id:").append(id).append(", name:").append(name).append("}").toString();
	}
}