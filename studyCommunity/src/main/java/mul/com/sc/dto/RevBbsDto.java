package mul.com.sc.dto;

import java.io.Serializable;
import java.util.List;

/*

CREATE TABLE FORBBS(
	SEQ NUMBER(8) PRIMARY KEY,
	ID NUMBER(8) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000),
	READCOUNT NUMBER(8) NOT NULL,
	REGDATE DATE NOT NULL,
	FILENAME VARCHAR2(200) NOT NULL,	
);

ALTER TABLE TC_FORBBS_COMMENT
ADD CONSTRAINT FORBBS_COMMENT_FK_USERID FOREIGN KEY(USERID)
REFERENCES TC_USER(ID);

CREATE TABLE TC_FORBBS_COMMENT (
    SEQ NUMBER(8) PRIMARY KEY,
    BBSID NUMBER(8) NOT NULL,
    USERID NUMBER(8) NOT NULL,
    CONTENT VARCHAR2(500) NOT NULL
);

ALTER TABLE TC_FORBBS_COMMENT
ADD CONSTRAINT FORBBS_COMMENT_FK_USERID FOREIGN KEY(USERID)
REFERENCES TC_USER(ID);

ALTER TABLE TC_FORBBS_COMMENT
ADD CONSTRAINT FORBBS_COMMENT_FK_BBSID FOREIGN KEY(BBSID)
REFERENCES TC_FORBBS(SEQ);

*/

public class RevBbsDto implements Serializable{
	
	private int seq;			// bbs의 시퀀스
	
	private int userid; 		// 'SC_USER' TABLE에서 외래키 받아오기
	private String nickname;   	// 'SC_USER' TABLE의 닉네임 
	private String avatar;   	// 'SC_USER' TABLE의 아바타
	
	private String title;   	// 제목
	private String content; 	//내용
	private int readcount;		// 조회수
	private String regdate; 	// 등록날짜
	private String filename;	// 업로드 파일 변경된 네임
	
	private List<Integer> comments; // 'SC_COMMENTS' TABLE의 댓글 리스트
	
	public RevBbsDto() {
	}

	public RevBbsDto(int seq, int userid, String nickname, String avatar, String title, String content, int readcount,
			String regdate, String filename, List<Integer> comments) {
		super();
		this.seq = seq;
		this.userid = userid;
		this.nickname = nickname;
		this.avatar = avatar;
		this.title = title;
		this.content = content;
		this.readcount = readcount;
		this.regdate = regdate;
		this.filename = filename;
		this.comments = comments;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<Integer> getComments() {
		return comments;
	}

	public void setComments(List<Integer> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ForBbsDto [seq=" + seq + ", userid=" + userid + ", nickname=" + nickname + ", avatar=" + avatar
				+ ", title=" + title + ", content=" + content + ", readcount=" + readcount + ", regdate=" + regdate
				+ ", filename=" + filename + ", comments=" + comments + "]";
	}

	
}