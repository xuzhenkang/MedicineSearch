package model;

import controller.DataLoader;

public abstract class ModelList {
	public DataLoader dataLoader = DataLoader.getInstance();
	public abstract Object[][] toArray();
}
