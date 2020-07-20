package Model;

public class Tennis extends Game {
	private int numOfSets;
	private boolean needTwoMoreSets;
	
	public Tennis(String participant1, String participant2) {
		super(participant1, participant2);
		this.numOfSets=3;
		needTwoMoreSets=false;
	}
	
	public int getNumOfPlays() {
		return this.numOfSets;
	}

	public boolean getIsWinner() throws TieException {
		if(scoreParticipant1==scoreParticipant2+3 || scoreParticipant2==scoreParticipant1+3 || 
				(scoreParticipant1==2 && scoreParticipant2==3 && numOfSets==5 || scoreParticipant1==3 && scoreParticipant2==2 && numOfSets==5)) {
			return true;
		}else {
			updateBooleans();
			return false;
		}
	}

	private void updateBooleans() throws TieException{
		if(!needTwoMoreSets) {
			needTwoMoreSets=true;
		}else if(needTwoMoreSets) {
			throw new TieException("Cannot ent with tie") ;
		}
	}

	public void updateNumOfPlays() {
		if(needTwoMoreSets) {
			numOfSets=5;
		}
	}

	public void resetGame() {
		this.numOfSets=3;
		needTwoMoreSets=false;
		scoreParticipant1=0;
		scoreParticipant2=0;
		winner="";
	}
	

}
