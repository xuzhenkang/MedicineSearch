package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelFileReader {
	
	private Workbook workbook = null;

	public ExcelFileReader(String path) throws BiffException, IOException {
		InputStream instream = new FileInputStream(path);
		this.workbook = Workbook.getWorkbook(instream);
	}

	public Sheet getSheet(int arg0) {
		
		return workbook.getSheet(arg0);
	}

}
