package model;

public class MedicineBook {
	private String bookName;
	private String author;
	private String dynasty;
	private String year;
	
	public MedicineBook(String bookName, String author, String dynasty, String year) {
		this.bookName = bookName;
		this.author = author;
		this.dynasty = dynasty;
		this.year = year;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDynasty() {
		return dynasty;
	}
	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
