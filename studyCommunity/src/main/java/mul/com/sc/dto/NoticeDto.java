package mul.com.sc.dto;

public class NoticeDto {

	private int seq;
	private String userid;
	private String title;
	private String content;
	private int Readcount;
	private int Bbsid;
	private String filename;
	private String nickname;
	private String avatar;
	private String regDate;
	
	public NoticeDto() {
		
	}

	

	public NoticeDto(int seq, String userid, String title, String content, int readcount, int bbsid, String filename,
			String nickname, String avatar, String regDate) {
		super();
		this.seq = seq;
		this.userid = userid;
		this.title = title;
		this.content = content;
		Readcount = readcount;
		Bbsid = bbsid;
		this.filename = filename;
		this.nickname = nickname;
		this.avatar = avatar;
		this.regDate = regDate;
	}

	

	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
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



	public int getReadcount() {
		return Readcount;
	}



	public void setReadcount(int readcount) {
		Readcount = readcount;
	}



	public int getBbsid() {
		return Bbsid;
	}



	public void setBbsid(int bbsid) {
		Bbsid = bbsid;
	}



	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
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



	public String getRegDate() {
		return regDate;
	}



	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}



	@Override
	public String toString() {
		return "NoticeDto [seq=" + seq + ", userid=" + userid + ", title=" + title + ", content=" + content
				+ ", Readcount=" + Readcount + ", Bbsid=" + Bbsid + ", filename=" + filename + ", nickname=" + nickname
				+ ", avatar=" + avatar + "]";
	}
	
}
