package general;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import entities.Model;

/**
 * Keeps an array of the LetterCraze entity model before each move is completed in the game, as a snapshot.
 * The array can then be accessed to undo the board by rolling back to the previous entity in the array.
 * This class is a singleton to avoid discrepancies with multiple models storing their own versions of the
 * array.
 * <p>
 * Creation date: (12/15/16 10:34:12 PM)
 * @author Ian Vossoughi
 */
public class UndoArray {
	/** The singleton instance of this class, to avoid storing multiple instances of the HashMap. */
	private static UndoArray instance = null;
	/** The ArrayList storing each entity model after every move has been made. */
	ArrayList<Model> undoArray;
	/** Index of the latest stored model in the undo array. */
	int index;
	
	/**
	 * The protected constructor of UndoArray (can only be invoked once).
	 */
	protected UndoArray() {
		this.undoArray = new ArrayList<Model>();
		this.index = -1;
	}
	
	/** 
	 * Obtains the single existence of UndoArray, or creates one through the protected constructor
	 * if one does not already exist. 
	 */
	public static UndoArray getInstance() {
		if (instance == null) {
			instance = new UndoArray();
		}
		return instance;
	}

	/**
	 * Adds a new model to the undo array by cloning it through the deep copy process, then storing the
	 * clone (the original model is not directly recorded in the array). The index now points to this new model.
	 * @param m The entity model to be copied into the array
	 */
	public void addUndoModel(Model m) {
		Model newModel = m.copyModel();
		undoArray.add(newModel);
		index++;
	}
	
	/**
	 * Removes the latest model of the undo array, and updates the index to point to the next oldest
	 * model in the array.
	 */
	public void removeUndoModel() {
		undoArray.remove(index);
		index--;
	}
	
	/**
	 * Returns the latest model of the undo array.
	 * @return The model currently represented in the array by the index
	 */
	public Model getLatestModel() {
		return undoArray.get(index);
	}

	public int getIndex() {
		return index;
	}
	
	public int getUndoSize() {
		return undoArray.size();
	}

}

