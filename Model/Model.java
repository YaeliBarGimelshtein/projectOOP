package Model;

import java.util.ArrayList;

public class Model {
	private ArrayList<Participant> allParticipants;
	private ArrayList<Game> quaterFinalGames;
	private ArrayList<Game>halfFinalGames;
	private Game finalGame;
	private String gameType;
	private String gameStage;

	public Model() {
		this.allParticipants = new ArrayList<>();
		quaterFinalGames=new ArrayList<>();
		halfFinalGames= new ArrayList<>();
	}
	
	public void updateGameType(String gameType) {
		this.gameType=gameType;
	}
	
	public boolean addParticipant(String name) {
		if (allParticipants.size() < 8) {
			allParticipants.add(new Participant(name));
		}
		if(allParticipants.size()<8) {
			return true;
		}else {
			return false;
		}
	}

	public String getAddedParticipant() {
		return allParticipants.get(allParticipants.size()-1).getName();
	}

	public int getNumOfParticipants() {
		return allParticipants.size()-1;
	}

	public void createQuterFinalGames() {
		switch (gameType) {
		case "Tennis":
			Game game1Tennis= new Tennis(allParticipants.get(0).getName(), allParticipants.get(1).getName());
			quaterFinalGames.add(game1Tennis);
			Game game2Tennis= new Tennis(allParticipants.get(2).getName(), allParticipants.get(3).getName());
			quaterFinalGames.add(game2Tennis);
			Game game3Tennis= new Tennis(allParticipants.get(4).getName(), allParticipants.get(5).getName());
			quaterFinalGames.add(game3Tennis);
			Game game4Tennis= new Tennis(allParticipants.get(6).getName(), allParticipants.get(7).getName());
			quaterFinalGames.add(game4Tennis);
			break;
		case "Basketball":
			Game game1Basketball= new Basketball(allParticipants.get(0).getName(), allParticipants.get(1).getName());
			quaterFinalGames.add(game1Basketball);
			Game game2Basketball= new Basketball(allParticipants.get(2).getName(), allParticipants.get(3).getName());
			quaterFinalGames.add(game2Basketball);
			Game game3Basketball= new Basketball(allParticipants.get(4).getName(), allParticipants.get(5).getName());
			quaterFinalGames.add(game3Basketball);
			Game game4Basketball= new Basketball(allParticipants.get(6).getName(), allParticipants.get(7).getName());
			quaterFinalGames.add(game4Basketball);
			break;
		case "Soccer":
			Game game1Soccer= new Soccer(allParticipants.get(0).getName(), allParticipants.get(1).getName());
			quaterFinalGames.add(game1Soccer);
			Game game2Soccer= new Soccer(allParticipants.get(2).getName(), allParticipants.get(3).getName());
			quaterFinalGames.add(game2Soccer);
			Game game3Soccer= new Soccer(allParticipants.get(4).getName(), allParticipants.get(5).getName());
			quaterFinalGames.add(game3Soccer);
			Game game4Soccer= new Soccer(allParticipants.get(6).getName(), allParticipants.get(7).getName());
			quaterFinalGames.add(game4Soccer);
		}
	}

	public void setGameStage(String gameStage) {
		this.gameStage=gameStage;
	}
	


	public String getParticipant1() {
		String name="";
		switch (gameStage) {
		case "quater final 1":
			name=quaterFinalGames.get(0).getParticipant1();
			break;
		case "quater final 2":
			name=quaterFinalGames.get(1).getParticipant1();
			break;
		case "quater final 3":
			name=quaterFinalGames.get(2).getParticipant1();
			break;
		case "quater final 4":
			name=quaterFinalGames.get(3).getParticipant1();
			break;
		case "half final 1":
			name=halfFinalGames.get(0).getParticipant1();
			break;
		case "half final 2":
			name=halfFinalGames.get(1).getParticipant1();
			break;
		case "final":
			name=finalGame.getParticipant1();
			break;
		}
		return name;
	}

	public String getParticipant2() {
		String name="";
		switch (gameStage) {
		case "quater final 1":
			name=quaterFinalGames.get(0).getParticipant2();
			break;
		case "quater final 2":
			name=quaterFinalGames.get(1).getParticipant2();
			break;
		case "quater final 3":
			name=quaterFinalGames.get(2).getParticipant2();
			break;
		case "quater final 4":
			name=quaterFinalGames.get(3).getParticipant2();
			break;
		case "half final 1":
			name=halfFinalGames.get(0).getParticipant2();
			break;
		case "half final 2":
			name=halfFinalGames.get(1).getParticipant2();
			break;
		case "final":
			name=finalGame.getParticipant2();
			break;
		}
		return name;
	}

	public int getNumOfPlays() {
		int numOfPlays=0;
		switch (gameStage) {
		case "quater final 1":
			if(gameType.equals("Soccer")) {
				numOfPlays= ((Soccer) quaterFinalGames.get(0)).getNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				numOfPlays= ((Tennis) quaterFinalGames.get(0)).getNumOfPlays();
			}else {
				numOfPlays= ((Basketball) quaterFinalGames.get(0)).getNumOfPlays();
			}
			break;
		case "quater final 2":
			if(gameType.equals("Soccer")) {
				numOfPlays= ((Soccer) quaterFinalGames.get(1)).getNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				numOfPlays= ((Tennis) quaterFinalGames.get(1)).getNumOfPlays();
			}else {
				numOfPlays= ((Basketball) quaterFinalGames.get(1)).getNumOfPlays();
			}
			break;
		case "quater final 3":
			if(gameType.equals("Soccer")) {
				numOfPlays= ((Soccer) quaterFinalGames.get(2)).getNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				numOfPlays= ((Tennis) quaterFinalGames.get(2)).getNumOfPlays();
			}else {
				numOfPlays= ((Basketball) quaterFinalGames.get(2)).getNumOfPlays();
			}
			break;
		case "quater final 4":
			if(gameType.equals("Soccer")) {
				numOfPlays= ((Soccer) quaterFinalGames.get(3)).getNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				numOfPlays= ((Tennis) quaterFinalGames.get(3)).getNumOfPlays();
			}else {
				numOfPlays= ((Basketball) quaterFinalGames.get(3)).getNumOfPlays();
			}
			break;
		case "half final 1":
			if(gameType.equals("Soccer")) {
				numOfPlays= ((Soccer) halfFinalGames.get(0)).getNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				numOfPlays= ((Tennis) halfFinalGames.get(0)).getNumOfPlays();
			}else {
				numOfPlays= ((Basketball) halfFinalGames.get(0)).getNumOfPlays();
			}
			break;
		case "half final 2":
			if(gameType.equals("Soccer")) {
				numOfPlays= ((Soccer) halfFinalGames.get(1)).getNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				numOfPlays= ((Tennis) halfFinalGames.get(1)).getNumOfPlays();
			}else {
				numOfPlays= ((Basketball) halfFinalGames.get(1)).getNumOfPlays();
			}
			break;
		case "final":
			if(gameType.equals("Soccer")) {
				numOfPlays= ((Soccer) finalGame).getNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				numOfPlays= ((Tennis) finalGame).getNumOfPlays();
			}else {
				numOfPlays= ((Basketball) finalGame).getNumOfPlays();
			}
			break;
		}
		return numOfPlays;
	}

	public void setScoreParticipant1(int scorePlayer1) {
		switch (gameStage) {
		case "quater final 1":
			quaterFinalGames.get(0).setScoreParticipant1(scorePlayer1);
			break;
		case "quater final 2":
			quaterFinalGames.get(1).setScoreParticipant1(scorePlayer1);
			break;
		case "quater final 3":
			quaterFinalGames.get(2).setScoreParticipant1(scorePlayer1);
			break;
		case "quater final 4":
			quaterFinalGames.get(3).setScoreParticipant1(scorePlayer1);
			break;
		case "half final 1":
			halfFinalGames.get(0).setScoreParticipant1(scorePlayer1);
			break;
		case "half final 2":
			halfFinalGames.get(1).setScoreParticipant1(scorePlayer1);
			break;
		case "final":
			finalGame.setScoreParticipant1(scorePlayer1);
			break;
		}
	}

	public void setScoreParticipant2(int scoreParticipant2) {
		switch (gameStage) {
		case "quater final 1":
			quaterFinalGames.get(0).setScoreParticipant2(scoreParticipant2);
			break;
		case "quater final 2":
			quaterFinalGames.get(1).setScoreParticipant2(scoreParticipant2);
			break;
		case "quater final 3":
			quaterFinalGames.get(2).setScoreParticipant2(scoreParticipant2);
			break;
		case "quater final 4":
			quaterFinalGames.get(3).setScoreParticipant2(scoreParticipant2);
			break;
		case "half final 1":
			halfFinalGames.get(0).setScoreParticipant2(scoreParticipant2);
			break;
		case "half final 2":
			halfFinalGames.get(1).setScoreParticipant2(scoreParticipant2);
			break;
		case "final":
			finalGame.setScoreParticipant2(scoreParticipant2);
			break;
		}
		
	}

	public boolean checkIsWinner() throws TieException {
		boolean isWinner=false;
		switch (gameStage) {
		case "quater final 1":
			if(gameType.equals("Soccer")) {
				isWinner= ((Soccer) quaterFinalGames.get(0)).getIsWinner();
			}else if(gameType.equals("Tennis")) {
				isWinner= ((Tennis) quaterFinalGames.get(0)).getIsWinner();
			}else {
				isWinner= ((Basketball) quaterFinalGames.get(0)).getIsWinner();
			}
			break;
		case "quater final 2":
			if(gameType.equals("Soccer")) {
				isWinner= ((Soccer) quaterFinalGames.get(1)).getIsWinner();
			}else if(gameType.equals("Tennis")) {
				isWinner= ((Tennis) quaterFinalGames.get(1)).getIsWinner();
			}else {
				isWinner= ((Basketball) quaterFinalGames.get(1)).getIsWinner();
			}
			break;
		case "quater final 3":
			if(gameType.equals("Soccer")) {
				isWinner= ((Soccer) quaterFinalGames.get(2)).getIsWinner();
			}else if(gameType.equals("Tennis")) {
				isWinner= ((Tennis) quaterFinalGames.get(2)).getIsWinner();
			}else {
				isWinner= ((Basketball) quaterFinalGames.get(2)).getIsWinner();
			}
			break;
		case "quater final 4":
			if(gameType.equals("Soccer")) {
				isWinner= ((Soccer) quaterFinalGames.get(3)).getIsWinner();
			}else if(gameType.equals("Tennis")) {
				isWinner= ((Tennis) quaterFinalGames.get(3)).getIsWinner();
			}else {
				isWinner= ((Basketball) quaterFinalGames.get(3)).getIsWinner();
			}
			break;
		case "half final 1":
			if(gameType.equals("Soccer")) {
				isWinner= ((Soccer) halfFinalGames.get(0)).getIsWinner();
			}else if(gameType.equals("Tennis")) {
				isWinner= ((Tennis) halfFinalGames.get(0)).getIsWinner();
			}else {
				isWinner= ((Basketball) halfFinalGames.get(0)).getIsWinner();
			}
			break;
		case "half final 2":
			if(gameType.equals("Soccer")) {
				isWinner= ((Soccer) halfFinalGames.get(1)).getIsWinner();
			}else if(gameType.equals("Tennis")) {
				isWinner= ((Tennis) halfFinalGames.get(1)).getIsWinner();
			}else {
				isWinner= ((Basketball) halfFinalGames.get(1)).getIsWinner();
			}
			break;
		case "final":
			if(gameType.equals("Soccer")) {
				isWinner= ((Soccer) finalGame).getIsWinner();
			}else if(gameType.equals("Tennis")) {
				isWinner= ((Tennis) finalGame).getIsWinner();
			}else {
				isWinner= ((Basketball) finalGame).getIsWinner();
			}
			break;
		}
		return isWinner;
	}

	public void setWinner() {
		switch (gameStage) {
		case "quater final 1":
			quaterFinalGames.get(0).setWinner();
			break;
		case "quater final 2":
			quaterFinalGames.get(1).setWinner();
			break;
		case "quater final 3":
			quaterFinalGames.get(2).setWinner();
			break;
		case "quater final 4":
			quaterFinalGames.get(3).setWinner();
			break;
		case "half final 1":
			halfFinalGames.get(0).setWinner();
			break;
		case "half final 2":
			halfFinalGames.get(1).setWinner();
			break;
		case "final":
			finalGame.setWinner();
			break;
		}
	}

	public String getWinner() {
		String winner="";
		switch (gameStage) {
		case "quater final 1":
			winner=quaterFinalGames.get(0).getWinner();
			break;
		case "quater final 2":
			winner=quaterFinalGames.get(1).getWinner();
			break;
		case "quater final 3":
			winner=quaterFinalGames.get(2).getWinner();
			break;
		case "quater final 4":
			winner=quaterFinalGames.get(3).getWinner();
			break;
		case "half final 1":
			winner=halfFinalGames.get(0).getWinner();
			break;
		case "half final 2":
			winner=halfFinalGames.get(1).getWinner();
			break;
		case "final":
			winner=finalGame.getWinner();
			break;
		}
		return winner;
	}

	public void updateNumOfPlays() {
		switch (gameStage) {
		case "quater final 1":
			if(gameType.equals("Soccer")) {
				((Soccer) quaterFinalGames.get(0)).updateNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				 ((Tennis) quaterFinalGames.get(0)).updateNumOfPlays();
			}
			break;
		case "quater final 2":
			if(gameType.equals("Soccer")) {
				((Soccer) quaterFinalGames.get(1)).updateNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				 ((Tennis) quaterFinalGames.get(1)).updateNumOfPlays();
			}
			break;
		case "quater final 3":
			if(gameType.equals("Soccer")) {
				((Soccer) quaterFinalGames.get(2)).updateNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				 ((Tennis) quaterFinalGames.get(2)).updateNumOfPlays();
			}
			break;
		case "quater final 4":
			if(gameType.equals("Soccer")) {
				((Soccer) quaterFinalGames.get(3)).updateNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				 ((Tennis) quaterFinalGames.get(3)).updateNumOfPlays();
			}
			break;
		case "half final 1":
			if(gameType.equals("Soccer")) {
				((Soccer) halfFinalGames.get(0)).updateNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				 ((Tennis) halfFinalGames.get(0)).updateNumOfPlays();
			}
			break;
		case "half final 2":
			if(gameType.equals("Soccer")) {
				((Soccer) halfFinalGames.get(1)).updateNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				 ((Tennis) halfFinalGames.get(1)).updateNumOfPlays();
			}
			break;
		case "final":
			if(gameType.equals("Soccer")) {
				((Soccer) finalGame).updateNumOfPlays();
			}else if(gameType.equals("Tennis")) {
				 ((Tennis) finalGame).updateNumOfPlays();
			}
			break;
		}
	}

	public void createHalfFinalGames() {
		switch (gameType) {
		case "Tennis":
			Game game1Tennis = new Tennis(quaterFinalGames.get(0).getWinner(), quaterFinalGames.get(1).getWinner());
			halfFinalGames.add(game1Tennis);
			Game game2Tennis = new Tennis(quaterFinalGames.get(2).getWinner(), quaterFinalGames.get(3).getWinner());
			halfFinalGames.add(game2Tennis);
			break;
		case "Basketball":
			Game game1Basketball = new Basketball(quaterFinalGames.get(0).getWinner(), quaterFinalGames.get(1).getWinner());
			halfFinalGames.add(game1Basketball);
			Game game2Basketball = new Basketball(quaterFinalGames.get(2).getWinner(), quaterFinalGames.get(3).getWinner());
			halfFinalGames.add(game2Basketball);
			break;
		case "Soccer":
			Game game1Soccer = new Soccer(quaterFinalGames.get(0).getWinner(), quaterFinalGames.get(1).getWinner());
			halfFinalGames.add(game1Soccer);
			Game game2Soccer = new Soccer(quaterFinalGames.get(2).getWinner(), quaterFinalGames.get(3).getWinner());
			halfFinalGames.add(game2Soccer);
		}
	}

	public void createFinalGame() {
		switch (gameType) {
		case "Tennis":
			finalGame= new Tennis(halfFinalGames.get(0).getWinner(), halfFinalGames.get(1).getWinner());
			break;
		case "Basketball":
			finalGame= new Basketball(halfFinalGames.get(0).getWinner(), halfFinalGames.get(1).getWinner());
			break;
		case "Soccer":
			finalGame= new Soccer(halfFinalGames.get(0).getWinner(), halfFinalGames.get(1).getWinner());
			break;
		}
	}

	public void resetGame() {
		switch (gameStage) {
		case "quater final 1":
			if(gameType.equals("Soccer")) {
				((Soccer) quaterFinalGames.get(0)).resetGame();
			}else if(gameType.equals("Tennis")) {
				((Tennis) quaterFinalGames.get(0)).resetGame();
			}else {
				((Basketball) quaterFinalGames.get(0)).resetGame();
			}
			break;
		case "quater final 2":
			if(gameType.equals("Soccer")) {
				((Soccer) quaterFinalGames.get(1)).resetGame();
			}else if(gameType.equals("Tennis")) {
				((Tennis) quaterFinalGames.get(1)).resetGame();
			}else {
				((Basketball) quaterFinalGames.get(1)).resetGame();
			}
			break;
		case "quater final 3":
			if(gameType.equals("Soccer")) {
				((Soccer) quaterFinalGames.get(2)).resetGame();
			}else if(gameType.equals("Tennis")) {
				((Tennis) quaterFinalGames.get(2)).resetGame();
			}else {
				((Basketball) quaterFinalGames.get(2)).resetGame();
			}
			break;
		case "quater final 4":
			if(gameType.equals("Soccer")) {
				((Soccer) quaterFinalGames.get(3)).resetGame();
			}else if(gameType.equals("Tennis")) {
				((Tennis) quaterFinalGames.get(3)).resetGame();
			}else {
				((Basketball) quaterFinalGames.get(3)).resetGame();
			}
			break;
		case "half final 1":
			if(gameType.equals("Soccer")) {
				((Soccer) halfFinalGames.get(0)).resetGame();
			}else if(gameType.equals("Tennis")) {
				((Tennis) halfFinalGames.get(0)).resetGame();
			}else {
				((Basketball) halfFinalGames.get(0)).resetGame();
			}
			break;
		case "half final 2":
			if(gameType.equals("Soccer")) {
				((Soccer) halfFinalGames.get(1)).resetGame();
			}else if(gameType.equals("Tennis")) {
				((Tennis) halfFinalGames.get(1)).resetGame();
			}else {
				((Basketball) halfFinalGames.get(1)).resetGame();
			}
			break;
		case "final":
			if(gameType.equals("Soccer")) {
				((Soccer) finalGame).resetGame();
			}else if(gameType.equals("Tennis")) {
				((Tennis) finalGame).resetGame();
			}else {
				((Basketball) finalGame).resetGame();
			}
			break;
		}
	}

	
	
	
}
