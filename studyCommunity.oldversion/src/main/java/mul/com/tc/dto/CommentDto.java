package mul.com.tc.dto;

public class CommentDto {

	private long seq;
	private long bbsseq;
	private long pdsseq;
	private long noticeseq;
	private long reviewseq;
	private int userid;
	private String content;
	private int bbschoice;
	private String nickname;
	
	public CommentDto() {
		
	}

	

	public CommentDto(long seq, long bbsseq, long pdsseq, long noticeseq, long reviewseq, int userid, String content,
			int bbschoice, String nickname) {
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
	}



	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public long getBbsseq() {
		return bbsseq;
	}

	public void setBbsseq(long bbsseq) {
		this.bbsseq = bbsseq;
	}

	public long getPdsseq() {
		return pdsseq;
	}

	public void setPdsseq(long pdsseq) {
		this.pdsseq = pdsseq;
	}

	public long getNoticeseq() {
		return noticeseq;
	}

	public void setNoticeseq(long noticeseq) {
		this.noticeseq = noticeseq;
	}

	public long getReviewseq() {
		return reviewseq;
	}

	public void setReviewseq(long reviewseq) {
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
	
	

	

	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public int getBbschoice() {
		return bbschoice;
	}

	public void setBbschoice(int bbschoice) {
		this.bbschoice = bbschoice;
	}



	@Override
	public String toString() {
		return "CommentDto [seq=" + seq + ", bbsseq=" + bbsseq + ", pdsseq=" + pdsseq + ", noticeseq=" + noticeseq
				+ ", reviewseq=" + reviewseq + ", userid=" + userid + ", content=" + content + ", bbschoice="
				+ bbschoice + ", nickname=" + nickname + "]";
	}

	

	
	
	
	
}
