package general;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import entities.Model;

public class UndoArray {
	private static UndoArray instance = null;
	ArrayList<Model> undoArray;
	int index;
	
	
	protected UndoArray() {
		this.undoArray = new ArrayList<Model>();
		this.index = 0;
	}
	
	public static UndoArray getInstance() {
		if (instance == null) {
			instance = new UndoArray();
		}
		return instance;
	}

	public boolean addUndoModel(Model m) {
		undoArray.add(m);
		index++;
		return true;
	}
	
	public boolean removeUndoModel() {
		undoArray.set(index, null);
		index--;
		return true;
	}
	
	public Model getLatestModel() {
		return undoArray.get(index);
	}

}

