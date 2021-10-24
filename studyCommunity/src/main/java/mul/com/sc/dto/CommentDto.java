package mul.com.sc.dto;

public class CommentDto {

	private int seq;
	private int bbsseq;
	private int pdsseq;
	private int noticeseq;
	private int reviewseq;
	private int userid;
	private String content;
	private int bbschoice;
	private String nickname;
	private String regdate;
	
	public CommentDto() {
		
	}

	public CommentDto(int seq, int bbsseq, int pdsseq, int noticeseq, int reviewseq, int userid, String content,
			int bbschoice, String nickname, String regdate) {
		super();
		this.seq = seq;
		this.bbsseq = bbsseq;
		this.pdsseq = pdsseq;
		this.noticeseq = noticeseq;
		this.reviewseq = reviewseq;
		this.userid = userid;
		this.content = content;
		this.bbschoice = bbschoice;
		this.nickname = nickname;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getBbsseq() {
		return bbsseq;
	}

	public void setBbsseq(int bbsseq) {
		this.bbsseq = bbsseq;
	}

	public int getPdsseq() {
		return pdsseq;
	}

	public void setPdsseq(int pdsseq) {
		this.pdsseq = pdsseq;
	}

	public int getNoticeseq() {
		return noticeseq;
	}

	public void setNoticeseq(int noticeseq) {
		this.noticeseq = noticeseq;
	}

	public int getReviewseq() {
		return reviewseq;
	}

	public void setReviewseq(int reviewseq) {
		this.reviewseq = reviewseq;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBbschoice() {
		return bbschoice;
	}

	public void setBbschoice(int bbschoice) {
		this.bbschoice = bbschoice;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentDto [seq=" + seq + ", bbsseq=" + bbsseq + ", pdsseq=" + pdsseq + ", noticeseq=" + noticeseq
				+ ", reviewseq=" + reviewseq + ", userid=" + userid + ", content=" + content + ", bbschoice="
				+ bbschoice + ", nickname=" + nickname + ", regdate=" + regdate + "]";
	}

	
	
	
}
