package model;

import java.util.List;

import controller.DataLoader;

public class KeywordList extends ModelList {
	private List<Keyword> list = DataLoader.getInstance().loadKeywordList();
	
	@Override
	public Object[][] toArray() {
		Object[][] result = new Object[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			result[i][0] = ((Keyword)list.get(i)).getKeyword();
			result[i][1] = ((Keyword)list.get(i)).getNum();
		}
		return result;
	}
}
