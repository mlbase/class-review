package mul.com.sc.dto;

public class BbsDto {

	private int seq;
	private int userId;
	private String title;
	private String content;
	private int readCount;
	private String regdate;
	private String nickname;
	private String avatar;
	
	public BbsDto() {
	}

	

	public BbsDto(int seq, int userId, String title, String content, int readCount, String regdate, String nickname,
			String avatar) {
		super();
		this.seq = seq;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.regdate = regdate;
		this.nickname = nickname;
		this.avatar = avatar;
	}



	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getReadCount() {
		return readCount;
	}



	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getAvatar() {
		return avatar;
	}



	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	@Override
	public String toString() {
		return "BbsDto [seq=" + seq + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", readCount=" + readCount + ", regdate=" + regdate + ", nickname=" + nickname + ", avatar=" + avatar
				+ "]";
	}

	
	
	
}
