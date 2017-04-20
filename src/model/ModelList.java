package model;

import java.util.List;

public class ModelList<T> {
	
	
	public Object[][] bookToArray(List<T> list) {
		Object[][] result = null;
		if (list.get(0) instanceof Keyword) {
			result = new Object[list.size()][2];
		} else if (list.get(0) instanceof MedicineBook) {
			result = new Object[list.size()][4];
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(0) instanceof Keyword) {
				result[i][0] = ((Keyword)list.get(i)).getKeyword();
				result[i][1] = ((Keyword)list.get(i)).getNum();
			} else if (list.get(0) instanceof MedicineBook) {
				result[i][0] = ((MedicineBook)list.get(i)).getBookName();
				result[i][1] = ((MedicineBook)list.get(i)).getAuthor();
				result[i][2] = ((MedicineBook)list.get(i)).getDynasty();
				result[i][3] = ((MedicineBook)list.get(i)).getYear();
			}
		}
		return result;
	}
}
