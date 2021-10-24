package mul.com.sc.dto;

import java.io.Serializable;

public class PdsDto implements Serializable{
	
	private int userid;
	private int seq;
	private String nickname;
	
	private String avatar;
	private String title;
	private String content;
	
	private String filename;
	private String newfilename;
	private int readcount;
	private int downcount;
	private String regdate;
	
	public PdsDto() {
	}

	public PdsDto(int userid, int seq, String nickname, String avatar, String title, String content, String filename,
			String newfilename, int readcount, int downcount, String regdate) {
		super();
		this.userid = userid;
		this.seq = seq;
		this.nickname = nickname;
		this.avatar = avatar;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.newfilename = newfilename;
		this.readcount = readcount;
		this.downcount = downcount;
		this.regdate = regdate;
	}
	
	public PdsDto(String nickname, String title, String content, String filename, String newfilename) {
		super();
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.newfilename = newfilename;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getDowncount() {
		return downcount;
	}

	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "PdsDto [userid=" + userid + ", seq=" + seq + ", nickname=" + nickname + ", avatar=" + avatar
				+ ", title=" + title + ", content=" + content + ", filename=" + filename + ", newfilename="
				+ newfilename + ", readcount=" + readcount + ", downcount=" + downcount + ", regdate=" + regdate + "]";
	}
	
	
	

	

}
