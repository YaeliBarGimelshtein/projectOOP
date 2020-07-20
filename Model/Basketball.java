package Model;

public class Basketball extends Game {
	private int numOfQuters;
	
	public Basketball(String participant1, String participant2) {
		super(participant1, participant2);
		this.numOfQuters=4;
	}
	
	public int getNumOfPlays() {
		return numOfQuters;
	}

	public boolean getIsWinner() throws TieException{
		if(scoreParticipant1==scoreParticipant2) {
			throw new TieException("Cannot ent with tie");
		}else {
			return true;
		}
	}



}
