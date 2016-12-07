package entities;

public class Score {
	public int[] starScores;
	int score;
	
	public Score(int starScores[]) {
		this.starScores = starScores;
	}

	public String serialize() {
		return "" + starScores[0] + " " + starScores[1] + " " + starScores[2];
	}
	

	/*public void setScores(int a, int b, int c){
		this.starScores = new 
	}*/
}
