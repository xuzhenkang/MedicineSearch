package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Book;

public class TextFileReader {
	private File file;
	private Book lastBook = null;
	private static TextFileReader instance = new TextFileReader(); // 单例模式，饿汉式

	public static TextFileReader getInstance() {
		return instance;
	}

	private TextFileReader() {
		this.file = new File("data/2/");
	}

	public Book getBook(String bookName) {
		if (lastBook != null && lastBook.getBookName().equals(bookName)) // 若lastBook不为空，且书名与本次查询的书名一致，则直接返回lastBook
			return lastBook;
		else {
			File bookFile = getBookFile(bookName);
			StringBuilder context = new StringBuilder();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(bookFile));
				int b;
				while ((b = br.read()) != -1) {
					context.append((char) b);
				}
				// System.out.println(context.toString());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.lastBook = new Book(bookName, context.toString());
			return lastBook;
		}
	}

	private File getBookFile(String bookName) {
		File[] subFiles = file.listFiles();
		for (File subFile : subFiles) {
			if (subFile.isFile() && subFile.getName().substring(5).equals(bookName + ".txt")) {
				// System.out.println(subFile.getName());
				return subFile;
			}
		}
		return null;
	}
}
