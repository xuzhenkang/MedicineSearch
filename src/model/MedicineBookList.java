package model;

import java.util.List;

import controller.DataLoader;

public class MedicineBookList extends ModelList {
	private List<MedicineBook> list = null;
	
	public MedicineBookList(String keyword) {
		this.list = DataLoader.getInstance().loadMedicineBookList(keyword);
	}
	@Override
	public Object[][] toArray() {
		Object[][] result = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			result[i][0] = ((MedicineBook)list.get(i)).getBookName();
			result[i][1] = ((MedicineBook)list.get(i)).getAuthor();
			result[i][2] = ((MedicineBook)list.get(i)).getDynasty();
			result[i][3] = ((MedicineBook)list.get(i)).getYear();
		}
		return result;
	}
}
