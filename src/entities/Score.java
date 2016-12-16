package entities;

/**
 *  The score and star threshold values for a level.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class Score {
	/** Star scores.*/
	public int[] starScores = {0, 0, 0};
	/** Current level score */
	int score;
	
	/**
	 * Score constructor comment.
	 */
	public Score(int starScores[]) {
		this.starScores = starScores;
	}
	
	public int getScoreValue() {
		return this.score;
	}
	public int getStarScoreIndex(int n){
		return this.starScores[n];
	}
	
	public int[] getStarScores() {
		return this.starScores;
	}
	
	public void setScoreValue(int score) {
		this.score = score;
	}
	
	public void setScore(int starScores[]){
		this.starScores = starScores;
	}

	/** Serialize values for saving and loading levels */
	public String serialize() {
		return "" + starScores[0] + " " + starScores[1] + " " + starScores[2];
	}
}
