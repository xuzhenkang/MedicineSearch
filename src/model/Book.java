package model;

public class Book {
	private String bookName;
	private String context;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Book(String bookName, String context) {
		this.bookName = bookName;
		this.context = context;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}
