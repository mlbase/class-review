package mul.com.sc.dto;

public class UserDto {

	private int id;
	private String email;
	private String pwd;
	private String nickname;
	private int del;
	private String createdAt;
	private String avatar;
	private int auth;
	
	public UserDto() {
	}

	public UserDto(int id, String email, String pwd, String nickname, int del, String createdAt, String avatar,
			int auth) {
		super();
		this.id = id;
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
		this.del = del;
		this.createdAt = createdAt;
		this.avatar = avatar;
		this.auth = auth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + ", del=" + del
				+ ", createdAt=" + createdAt + ", avatar=" + avatar + ", auth=" + auth + "]";
	}
	
	
	
}
