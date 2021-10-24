package mul.com.sc.dto;

import java.io.Serializable;

public class RevBbsParam implements Serializable{

	private String choice;
	private String search;
	
	private String schoice;
	
	private int pageNumber;
	
	private int start;
	private int end;
	
	public RevBbsParam() {
	}

	public RevBbsParam(String choice, String search, String schoice, int pageNumber, int start, int end) {
		super();
		this.choice = choice;
		this.search = search;
		this.schoice = schoice;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSchoice() {
		return schoice;
	}

	public void setSchoice(String schoice) {
		this.schoice = schoice;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	
}

	
