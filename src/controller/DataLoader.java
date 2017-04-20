package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.util.ExcelFileReader;
import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import model.Keyword;
import model.MedicineBook;

public class DataLoader {
	private ExcelFileReader efrLeft;
	private ExcelFileReader efrMain;

	private DataLoader() {
		try {
			efrLeft = new ExcelFileReader("data/中医文献标注结果(RichEdit宽度473，字号默认,带文献数).xls");
			efrMain = new ExcelFileReader("data/中医文献作者朝代年份表.xls");
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// System.out.println(efr);
		}
	}

	// 单例模式,饿汉式
	private static DataLoader instance = new DataLoader();

	public static DataLoader getInstance() {
		return instance;
	}

	// 加载keyword数据
	public List<Keyword> loadKeywordList() {
		List<Keyword> list = new ArrayList<>();

		Sheet currentSheet = efrLeft.getSheet(3); // 第3个Sheet是关键词列表
		for (int i = 1; i < currentSheet.getRows(); i++) {
			Cell[] cells = currentSheet.getRow(i);
			String word = (cells.length > 0) ? cells[0].getContents() : "";
			list.add(new Keyword(word, 0));
		}
		for (int i = 0; i < 3; i++) {
			currentSheet = efrLeft.getSheet(i);
			for (int j = 1; j < currentSheet.getRows(); j++) {
				int numY = 0;
				Cell[] cells = currentSheet.getRow(j);
				for (int k = 1; k < cells.length; k++) {
					if (cells[k].getContents().equals("Y"))
						numY++;
				}
				list.get(j - 1).setNum(list.get(j - 1).getNum() + numY);
			}
		}
		return list;
	}
	
	// 根据书名，在efrMain中查找行
	private MedicineBook getMedicineBook(String bookName) {
		Sheet sheet = efrMain.getSheet(0);
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell[] row = sheet.getRow(i);
			if (row[0].getContents().equals(bookName)) {
				String author = row[1].getContents();
				String dynasty = row[2].getContents();
				String year = row[3].getContents();
				return new MedicineBook(bookName, author, dynasty, year);
			}
		}
		return null;
	}
	
	// 1.获得关键字作为参数(传入参数即关键字)
	// 2.查询文献标注结果.xls Sheet1、2、3中对应的关键字，对应Y的文献名称
	// 3.使用这个文件名称，到文献作者朝代年份表.xls Sheet1中找对应的行，加入到MedicineBookList中。
	// 加载MedicineBook数据
	public List<MedicineBook> loadMedicineBookList(String keyword) {
		List<MedicineBook> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Cell[] row = null;
			Sheet sheet = efrLeft.getSheet(i);
			for (int j = 1; j < sheet.getRows(); j++) { // 寻找关键字所在行
				row = sheet.getRow(j);
				if (row.length > 0 && row[0].getContents().equals(keyword)) {
					break;
				}
			}
			Cell[] bookNames = sheet.getRow(0);// 第0行存放的是书名
			for (int j = 1; j < row.length; j++) {
				if (row[j].getContents().equals("Y")) {
					MedicineBook medicineBook = getMedicineBook(bookNames[j].getContents().substring(5));
					if (medicineBook != null) {
						list.add(medicineBook);
					}
				}
			}
		}
		return list;
	}
	
	

}
