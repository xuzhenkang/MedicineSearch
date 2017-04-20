package controller;

import java.util.ArrayList;
import java.util.List;

import controller.util.ExcelFileReader;
import jxl.Cell;
import jxl.Sheet;
import model.Keyword;

public class DataLoader {
	// 加载keyword数据
	public static List<Keyword> loadKeywordList(ExcelFileReader efr) {
		List<Keyword> list = new ArrayList<>();
		Sheet currentSheet = efr.getSheet(3); // 第3个Sheet是关键词列表
		for (int i = 0; i < currentSheet.getRows(); i++) {
			Cell[] cells = currentSheet.getRow(i);
			Keyword keyword = new Keyword(cells[0].getContents(), 0);
			list.add(keyword);
		}
		for (int i = 0; i < 3; i++) {
			currentSheet = efr.getSheet(i);
			for (int j = 1; j < currentSheet.getRows(); j++) {
				int numY = 0;
				Cell[] cells = currentSheet.getRow(j);
				for (int k = 1; k < cells.length; k++) {
					if (cells[k].getContents().equals("Y"))
						numY++;
				}
				list.get(j-1).setNum(list.get(j-1).getNum() + numY);
			}
		}
		
		System.out.println(list);
		return list;
	}
}
