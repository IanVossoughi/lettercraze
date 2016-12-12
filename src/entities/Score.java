package entities;

public class Score {
	public int[] starScores = {0, 0, 0};
	int score;
	
	public Score(int starScores[]) {
		this.starScores = starScores;
	}
	
	public int getScoreValue() {
		return this.score;
	}
	public int getStarScoreIndex(int n){
		return this.starScores[n];
	}
	
	public void setScoreValue(int score) {
		this.score = score;
	}
	
	public void setScore(int starScores[]){
		this.starScores = starScores;
	}

	public String serialize() {
		return "" + starScores[0] + " " + starScores[1] + " " + starScores[2];
	}
}
