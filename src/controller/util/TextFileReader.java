package controller.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Book;

public class TextFileReader {
	private File file;
	public TextFileReader() {
		
		this.file = new File("data/2/");
	}
	public Book getBook(String bookName) {
		File bookFile = getBookFile(bookName);
		StringBuilder context = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(bookFile));
			int b;
			while ((b = br.read()) != -1) {
				context.append((char)b);
			}
			System.out.println(context.toString());
			
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
		return new Book(context.toString());
	}
	private File getBookFile(String bookName) {
		File[] subFiles = file.listFiles();
		for (File subFile : subFiles) {
			if (subFile.isFile() && subFile.getName().equals(bookName + ".txt")) {
				System.out.println(subFile.getName());
				return subFile;
			}
		}
		return null;
	}
}
