package Model;

public class Soccer extends Game {
	private int numOfHalfs;
	private boolean needAnotherHalf;
	private boolean needPenaltyKicks;
	
	public Soccer(String participant1, String participant2) {
		super(participant1, participant2);
		this.numOfHalfs=2;
		needAnotherHalf=false;
		needPenaltyKicks=false;
	}
	
	public int getNumOfPlays() {
		return numOfHalfs;
	}

	public boolean getIsWinner() throws TieException {
		if(scoreParticipant1>scoreParticipant2 || scoreParticipant2 > scoreParticipant1) {
			return true;
		}else {
			updateBooleans();
			return false;
		}
	}

	private void updateBooleans() throws TieException {
		if(needAnotherHalf==false && needPenaltyKicks==false) {
			needAnotherHalf=true;
		}else if(needAnotherHalf==true && needPenaltyKicks==false) {
			needPenaltyKicks=true;
		}else if(needAnotherHalf==true && needPenaltyKicks==true) {
			throw new TieException("Cannot ent with tie");
		}
	}

	public void updateNumOfPlays() {
		if(needAnotherHalf && !needPenaltyKicks) {
			numOfHalfs=3;
		}else if (needAnotherHalf && needPenaltyKicks) {
			numOfHalfs=4;
		}
	}

	public void resetGame() {
		this.numOfHalfs=2;
		needAnotherHalf=false;
		needPenaltyKicks=false;
		scoreParticipant1=0;
		scoreParticipant2=0;
		winner="";
	}
	
}
