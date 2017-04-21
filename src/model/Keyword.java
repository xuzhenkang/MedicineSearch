package model;

public class Keyword{
	private String keyword;
	private Integer num;
	
	public Keyword(String keyword, Integer num) {
		this.keyword = keyword;
		this.num = num;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
