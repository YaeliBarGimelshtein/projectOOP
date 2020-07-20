package Model;

public class Game {
	protected String participant1;
	protected String participant2;
	protected String winner;
	protected int scoreParticipant1;
	protected int scoreParticipant2;
	
	public Game(String participant1, String participant2) {
		this.participant1 = participant1;
		this.participant2 = participant2;
	}

	public String getParticipant1() {
		return this.participant1;
	}

	public String getParticipant2() {
		return this.participant2;
	}

	public void setScoreParticipant1(int score) {
		this.scoreParticipant1=score;
	}
	
	public void setScoreParticipant2(int score) {
		this.scoreParticipant2=score;
	}

	public void setWinner() {
		if(scoreParticipant1>scoreParticipant2) {
			winner=participant1;
		}else {
			winner=participant2;
		}
	}

	public String getWinner() {
		return winner;
	}
	
	public void resetGame() {
		winner="";
		scoreParticipant1=0;
		scoreParticipant2=0;
	}

}
