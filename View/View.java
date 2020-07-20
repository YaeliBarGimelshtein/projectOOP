package View;

import java.util.ArrayList;

import Model.Model;
import Model.NotDigitsException;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class View {
	//buttons
	private RadioButton Tennis;
	private RadioButton Soccer;
	private RadioButton Basketball;
	private Button addParticipant;
	private Button startChampionship;
	private Button playAGame1;
	private Button playAGame2;
	private Button playAGame3;
	private Button playAGame4;
	private Button playAGame5;
	private Button playAGame6;
	private Button playAGame7;
	private Button exit;
	
	//texts and fields
	private TextField enterName;
	private Label participatName;
	private Label participat1;
	private Label participat2;
	private Label participat3;
	private Label participat4;
	private Label participat5;
	private Label participat6;
	private Label participat7;
	private Label participat8;
	private Label championship;
	private DropShadow blurry;
	private Label typeGameHeadLine;
	private String gameType;
	private Label winnerQuaterFinal1;
	private Label winnerQuaterFinal2;
	private Label winnerQuaterFinal3;
	private Label winnerQuaterFinal4;
	private Label winnerHalfFinal1;
	private Label winnerHalfFinal2;
	private Label winner;
	private Label exitLabel;
	private String gameStage;
	
	//layout
	private ToggleGroup group;
	private HBox hbox1;
	private HBox hbox2;
	private VBox vbox1;
	private VBox vbox2;
	private VBox vbox3;
	private VBox vbox4;
	private VBox vbox5;
	private VBox vbox6;
	private VBox vbox7;
	private BorderPane borders;
	private Pane centerScreen;
	private ArrayList<Label>allParticipantsLabels;
	private ArrayList<Label>winnersOfQuaterFinal;
	private ArrayList<Label>winnersOfHalfFinal;
	private ArrayList<Button> allPlayAGameButtons;
	private ArrayList<PlayAGame> quaterFinalGames;
	private ArrayList<PlayAGame> halfFinalGames;
	private PlayAGame finalGame;
	
	public View(Stage primaryStage) {
		//buttons
		exit= new Button("Exit");
		exit.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		this.Tennis=new RadioButton("Tennis");
		Tennis.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		this.group=new ToggleGroup();
		Tennis.setToggleGroup(group);
		this.Basketball= new RadioButton("Basketball");
		Basketball.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		Basketball.setToggleGroup(group);
		this.Soccer=new RadioButton("Soccer");
		Soccer.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		Soccer.setToggleGroup(group);
		this.addParticipant=new Button("Add participant");
		addParticipant.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		this.startChampionship=new Button("Start Championship");
		startChampionship.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		startChampionship.setDisable(true);
		
		//text 
		exitLabel= new Label("To exit press");
		exitLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		this.participatName= new Label("Participant name");
		this.participatName.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		this.enterName= new TextField();
		
		this.typeGameHeadLine=new Label("Choose game type");
		typeGameHeadLine.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		typeGameHeadLine.setTextFill(Color.BLUE);
		
		this.championship= new Label("Championship");
		this.championship.setFont(Font.font("Verdana", FontWeight.BOLD, 28));
		this.championship.setTextFill(Color.BLUE);
		this.blurry=new DropShadow();
		this.blurry.setColor(Color.BLACK);
		this.championship.setEffect(blurry);
		typeGameHeadLine.setEffect(blurry);
		
		this.participat1=new Label();
		this.participat2=new Label();
		this.participat3=new Label();
		this.participat4=new Label();
		this.participat5=new Label();
		this.participat6=new Label();
		this.participat7=new Label();
		this.participat8=new Label();
		allParticipantsLabels=new ArrayList<>();
		allParticipantsLabels.add(participat1);
		allParticipantsLabels.add(participat2);
		allParticipantsLabels.add(participat3);
		allParticipantsLabels.add(participat4);
		allParticipantsLabels.add(participat5);
		allParticipantsLabels.add(participat6);
		allParticipantsLabels.add(participat7);
		allParticipantsLabels.add(participat8);
		for (int i = 0; i < allParticipantsLabels.size(); i++) {
			allParticipantsLabels.get(i).setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			allParticipantsLabels.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 18));
			allParticipantsLabels.get(i).setMinSize(20, 20);
			allParticipantsLabels.get(i).setMaxSize(100, 30);
			allParticipantsLabels.get(i).setPrefSize(100, 30);
			allParticipantsLabels.get(i).setVisible(false);
			allParticipantsLabels.get(i).setEffect(blurry);
		}
		
		//layout
		this.vbox1= new VBox();
		vbox1.getChildren().addAll(typeGameHeadLine,Tennis,Basketball,Soccer);
		vbox1.setSpacing(13);
		vbox1.setAlignment(Pos.CENTER);
		VBox.setMargin(typeGameHeadLine, new Insets(0, 0, 0, 10));
		VBox.setMargin(Tennis, new Insets(0, 0, 0, 10));
		VBox.setMargin(Basketball, new Insets(0, 0, 0, 39));
		VBox.setMargin(Soccer, new Insets(0, 0, 0, 10));
		
		this.hbox1=new HBox();
		hbox1.getChildren().addAll(participatName,enterName);
		HBox.setMargin(enterName, new Insets(0, 0, 0, 15));
		
		this.hbox2= new HBox();
		hbox2.getChildren().add(championship);
		hbox2.setAlignment(Pos.CENTER);
		
		this.vbox2=new VBox();
		vbox2.getChildren().addAll(allParticipantsLabels);
		vbox2.setSpacing(30);
		vbox2.setAlignment(Pos.CENTER);
		VBox.setMargin(participat1, new Insets(0,30, 0, 0));
		VBox.setMargin(participat2, new Insets(0,30, 0, 0));
		VBox.setMargin(participat3, new Insets(0,30, 0, 0));
		VBox.setMargin(participat4, new Insets(0,30, 0, 0));
		VBox.setMargin(participat5, new Insets(0,30, 0, 0));
		VBox.setMargin(participat6, new Insets(0,30, 0, 0));
		VBox.setMargin(participat7, new Insets(0,30, 0, 0));
		VBox.setMargin(participat8, new Insets(0,30, 0, 0));
		
		this.vbox3=new VBox();
		vbox3.getChildren().addAll(hbox1,addParticipant,startChampionship);
		vbox3.setSpacing(35);
		vbox3.setAlignment(Pos.BOTTOM_CENTER);
		VBox.setMargin(hbox1, new Insets(410, 0, 0, 360));
		VBox.setMargin(addParticipant, new Insets(0, 0, 0, 360));
		VBox.setMargin(startChampionship, new Insets(0, 0, 0, 360));
		vbox3.setVisible(false);
		
		this.centerScreen=new Pane();
		centerScreen.getChildren().addAll(vbox3);
		this.borders=new BorderPane();
		borders.setLeft(vbox1);
		borders.setRight(vbox2);
		borders.setTop(hbox2);
		borders.setCenter(centerScreen);
		
		Scene scene = new Scene(borders,1600,1000);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public void updateWindow() {
		vbox3.setVisible(true);
		if(Tennis.isSelected()) {
			this.gameType="Tennis";
		}else if(Basketball.isSelected()) {
			this.gameType="Basketball";
		}else {
			this.gameType="Soccer";
		}
	}
	
	public String getGameType() {
		return this.gameType;
	}
	
	public boolean checkIfNameValid() {
		if(enterName.getText().isEmpty()) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Must add a name");
			msg.setTitle("Name is not Valid");
			msg.show();
			return false;
		}
		return true;
	}
	
	public String getParticipantName() {
		return enterName.getText();
	}
	
	public void updateParticipant(String addedParticipant,int index) {
		allParticipantsLabels.get(index).setText(addedParticipant);
		allParticipantsLabels.get(index).setVisible(true);
		enterName.setText("");
	}
	
	public void updateWindowToMaxParticipants() {
		this.addParticipant.setVisible(false);
		this.enterName.setVisible(false);
		this.participatName.setVisible(false);
		startChampionship.setDisable(false);
	}
	
	public void updateWindowToStartChampionship() {
		//fresh page
		borders.setLeft(null);
		borders.setRight(null);
		borders.setCenter(null);
		centerScreen.getChildren().removeAll(vbox3);
		vbox1.getChildren().removeAll(typeGameHeadLine,Tennis,Basketball,Soccer);
		vbox2.getChildren().removeAll(allParticipantsLabels);
		vbox3.getChildren().removeAll(hbox1,addParticipant,startChampionship);
		vbox4=new VBox();
		vbox5=new VBox();
		vbox6=new VBox();
		vbox7=new VBox();
		//new page
		playAGame1 = new Button("Play a game");
		playAGame2 = new Button("Play a game");
		playAGame3 = new Button("Play a game");
		playAGame4 = new Button("Play a game");
		playAGame5 = new Button("Play a game");
		playAGame5.setDisable(true);
		playAGame6 = new Button("Play a game");
		playAGame6.setDisable(true);
		playAGame7 = new Button("Play a game");
		playAGame7.setDisable(true);
		allPlayAGameButtons=new ArrayList<>();
		allPlayAGameButtons.add(playAGame1);
		allPlayAGameButtons.add(playAGame2);
		allPlayAGameButtons.add(playAGame3);
		allPlayAGameButtons.add(playAGame4);
		allPlayAGameButtons.add(playAGame5);
		allPlayAGameButtons.add(playAGame6);
		allPlayAGameButtons.add(playAGame7);
		for (int i = 0; i < allPlayAGameButtons.size(); i++) {
			allPlayAGameButtons.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		}
		
		this.winnerQuaterFinal1=new Label();
		this.winnerQuaterFinal2=new Label();
		this.winnerQuaterFinal3=new Label();
		this.winnerQuaterFinal4=new Label();
		winnersOfQuaterFinal=new ArrayList<>();
		winnersOfQuaterFinal.add(winnerQuaterFinal1);
		winnersOfQuaterFinal.add(winnerQuaterFinal2);
		winnersOfQuaterFinal.add(winnerQuaterFinal3);
		winnersOfQuaterFinal.add(winnerQuaterFinal4);
		for (int i = 0; i < winnersOfQuaterFinal.size(); i++) {
			winnersOfQuaterFinal.get(i).setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			winnersOfQuaterFinal.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 18));
			winnersOfQuaterFinal.get(i).setMinSize(20, 20);
			winnersOfQuaterFinal.get(i).setMaxSize(100, 30);
			winnersOfQuaterFinal.get(i).setPrefSize(100, 30);
			winnersOfQuaterFinal.get(i).setEffect(blurry);
		}
		this.winnerHalfFinal1=new Label();
		this.winnerHalfFinal2=new Label();
		winnersOfHalfFinal=new ArrayList<>();
		winnersOfHalfFinal.add(winnerHalfFinal1);
		winnersOfHalfFinal.add(winnerHalfFinal2);
		for (int i = 0; i < winnersOfHalfFinal.size(); i++) {
			winnersOfHalfFinal.get(i).setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			winnersOfHalfFinal.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 18));
			winnersOfHalfFinal.get(i).setMinSize(20, 20);
			winnersOfHalfFinal.get(i).setMaxSize(100, 30);
			winnersOfHalfFinal.get(i).setPrefSize(100, 30);
			winnersOfHalfFinal.get(i).setEffect(blurry);
		}
		this.winner=new Label();
		winner.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		winner.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		winner.setMinSize(20, 20);
		winner.setMaxSize(100, 30);
		winner.setPrefSize(100, 30);
		winner.setEffect(blurry);
		
		quaterFinalGames= new ArrayList<>();
		halfFinalGames= new ArrayList<>();
				
		vbox1.getChildren().addAll(allParticipantsLabels);
		vbox1.setSpacing(80);
		vbox1.setAlignment(Pos.CENTER);
		VBox.setMargin(participat1, new Insets(80, 0, 0, 30));
		VBox.setMargin(participat2, new Insets(0, 0, 0, 30));
		VBox.setMargin(participat3, new Insets(0, 0, 0, 30));
		VBox.setMargin(participat4, new Insets(0, 0, 0, 30));
		VBox.setMargin(participat5, new Insets(0, 0, 0, 30));
		VBox.setMargin(participat6, new Insets(0, 0, 0, 30));
		VBox.setMargin(participat7, new Insets(0, 0, 0, 30));
		VBox.setMargin(participat8, new Insets(0, 0, 0, 30));
		vbox2.getChildren().addAll(playAGame1,playAGame2,playAGame3,playAGame4);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setSpacing(190);
		VBox.setMargin(playAGame1, new Insets(70, 0, 0, 0));
		vbox3.getChildren().addAll(winnersOfQuaterFinal);
		vbox3.setAlignment(Pos.CENTER);
		vbox3.setSpacing(190);
		VBox.setMargin(winnerQuaterFinal1, new Insets(70, 0, 0, 0));
		vbox4.getChildren().addAll(playAGame5,playAGame6);
		vbox4.setAlignment(Pos.CENTER);
		vbox4.setSpacing(400);
		VBox.setMargin(playAGame5, new Insets(75, 0, 0, 0));
		vbox5.getChildren().addAll(winnersOfHalfFinal);
		vbox5.setAlignment(Pos.CENTER);
		vbox5.setSpacing(400);
		VBox.setMargin(winnerHalfFinal1, new Insets(75, 0, 0, 0));
		vbox6.getChildren().add(playAGame7);
		vbox6.setAlignment(Pos.CENTER);
		VBox.setMargin(playAGame7, new Insets(90, 0, 0, 0));
		vbox7.getChildren().add(winner);
		vbox7.setAlignment(Pos.CENTER);
		VBox.setMargin(winner, new Insets(90, 0, 0, 0));
		HBox allLayout= new HBox();
		allLayout.getChildren().addAll(vbox1,vbox2,vbox3,vbox4,vbox5,vbox6,vbox7);
		HBox.setMargin(vbox2, new Insets(0, 0, 0, 80));
		HBox.setMargin(vbox3, new Insets(0, 0, 0, 80));
		HBox.setMargin(vbox4, new Insets(0, 0, 0, 80));
		HBox.setMargin(vbox5, new Insets(0, 0, 0, 80));
		HBox.setMargin(vbox6, new Insets(0, 0, 0, 80));
		HBox.setMargin(vbox7, new Insets(0, 0, 0, 80));
		centerScreen.getChildren().add(allLayout);
		borders.setLeft(centerScreen);
		
		//lines
		for (int i = 0; i < 8; i++) {
			Line l = new Line(140, 92+111*i, 140+100, 92+111*i);
			centerScreen.getChildren().add(l);
		}
		for (int i = 0; i < 4; i++) {
			Line l = new Line(240, 92+i*222, 240, 92+30+222*i);
			centerScreen.getChildren().add(l);
		}
		for (int i = 0; i < 4; i++) {
			Line l = new Line(240, 173+i*222, 240, 173+30+222*i);
			centerScreen.getChildren().add(l);
		}
		
		
		for (int i = 0; i < 4; i++) {
			Line l = new Line(330, 145+219*i, 330+56, 145+219*i);
			centerScreen.getChildren().add(l);
		}
		
		
		for (int i = 0; i < 4; i++) {
			Line l = new Line(520, 145+219*i, 520+120, 145+219*i);
			centerScreen.getChildren().add(l);
		}
		for (int i = 0; i < 2; i++) {
			Line l = new Line(640, 145+438*i, 640, 145+85+438*i);
			centerScreen.getChildren().add(l);
		}
		for (int i = 0; i < 2; i++) {
			Line l = new Line(640, 305+438*i, 640, 305+59+438*i);
			centerScreen.getChildren().add(l);
		}
		
		for (int i = 0; i < 2; i++) {
			Line l = new Line(705, 262+425*i, 705+56, 262+425*i);
			centerScreen.getChildren().add(l);
		}
		
		for (int i = 0; i < 2; i++) {
			Line l = new Line(890, 262+425*i, 890+100, 262+425*i);
			centerScreen.getChildren().add(l);
		}
		Line l2= new Line(990,262,990,262+183);
		centerScreen.getChildren().add(l2);
		Line l3= new Line(990,512,990,687);
		centerScreen.getChildren().add(l3);
		Line l1= new Line(1090,488,1145,488);
		centerScreen.getChildren().add(l1);
	}
	
	public int getIndexOfButton(EventTarget target) {
		return allPlayAGameButtons.indexOf(target);
	}
	public void setGameStage(int index) {
		switch (index) {
		case 0:
			this.gameStage="quater final 1";
			break;
		case 1:
			this.gameStage="quater final 2";
			break;
		case 2:
			this.gameStage="quater final 3";
			break;
		case 3:
			this.gameStage="quater final 4";
			break;
		case 4:
			this.gameStage="half final 1";
			break;
		case 5:
			this.gameStage="half final 2";
			break;
		case 6:
			this.gameStage="final";
			break;
		}
	}
	
	public String getGameStage() {
		return this.gameStage;
	}
	
	public void createPlayAGameWindow(String participant1, String participant2) {
		PlayAGame game= new PlayAGame(participant1,participant2,this.gameType, new Stage());
		if(gameStage.equals("quater final 1") || gameStage.equals("quater final 2")|| gameStage.equals("quater final 3")
				|| gameStage.equals("quater final 4")) {
			quaterFinalGames.add(game);
		}else if (gameStage.equals("half final 1") || gameStage.equals("half final 2")) {
			halfFinalGames.add(game);
		} else {
			finalGame=game;
		}
	}
	
	public boolean checkInfoIsValid(int numOfPlays) throws NotDigitsException {
		boolean isValid=false;
		switch (gameStage) {
		case "quater final 1":
			isValid=quaterFinalGames.get(0).checkInfoIsValid(numOfPlays);
			break;
		case "quater final 2":
			isValid=quaterFinalGames.get(1).checkInfoIsValid(numOfPlays);
			break;
		case "quater final 3":
			isValid=quaterFinalGames.get(2).checkInfoIsValid(numOfPlays);
			break;
		case "quater final 4":
			isValid=quaterFinalGames.get(3).checkInfoIsValid(numOfPlays);
			break;
		case "half final 1":
			isValid=halfFinalGames.get(0).checkInfoIsValid(numOfPlays);
			break;
		case "half final 2":
			isValid=halfFinalGames.get(1).checkInfoIsValid(numOfPlays);
			break;
		case "final":
			isValid=finalGame.checkInfoIsValid(numOfPlays);
			break;
		}
		return isValid;
	}
	
	public int getScoreParticipant1(int numOfPlays) {
		int score=0;
		switch (gameStage) {
		case "quater final 1":
			score=quaterFinalGames.get(0).calculateScorePlayer1(numOfPlays);
			break;
		case "quater final 2":
			score=quaterFinalGames.get(1).calculateScorePlayer1(numOfPlays);
			break;
		case "quater final 3":
			score=quaterFinalGames.get(2).calculateScorePlayer1(numOfPlays);
			break;
		case "quater final 4":
			score=quaterFinalGames.get(3).calculateScorePlayer1(numOfPlays);
			break;
		case "half final 1":
			score=halfFinalGames.get(0).calculateScorePlayer1(numOfPlays);
			break;
		case "half final 2":
			score=halfFinalGames.get(1).calculateScorePlayer1(numOfPlays);
			break;
		case "final":
			score=finalGame.calculateScorePlayer1(numOfPlays);
		}
		return score;
	}
	
	public int getScoreParticipant2(int numOfPlays) {
		int score=0;
		switch (gameStage) {
		case "quater final 1":
			score=quaterFinalGames.get(0).calculateScorePlayer2(numOfPlays);
			break;
		case "quater final 2":
			score=quaterFinalGames.get(1).calculateScorePlayer2(numOfPlays);
			break;
		case "quater final 3":
			score=quaterFinalGames.get(2).calculateScorePlayer2(numOfPlays);
			break;
		case "quater final 4":
			score=quaterFinalGames.get(3).calculateScorePlayer2(numOfPlays);
			break;
		case "half final 1":
			score=halfFinalGames.get(0).calculateScorePlayer2(numOfPlays);
			break;
		case "half final 2":
			score=halfFinalGames.get(1).calculateScorePlayer2(numOfPlays);
			break;
		case "final":
			score=finalGame.calculateScorePlayer2(numOfPlays);
		}
		return score;
	}
	
	public void setWinner(String winner) {
		switch (gameStage) {
		case "quater final 1":
			winnersOfQuaterFinal.get(0).setText(winner);
			break;
		case "quater final 2":
			winnersOfQuaterFinal.get(1).setText(winner);
			break;
		case "quater final 3":
			winnersOfQuaterFinal.get(2).setText(winner);
			break;
		case "quater final 4":
			winnersOfQuaterFinal.get(3).setText(winner);
			break;
		case "half final 1":
			winnersOfHalfFinal.get(0).setText(winner);
			break;
		case "half final 2":
			winnersOfHalfFinal.get(1).setText(winner);
			break;
		case "final":
			this.winner.setText(winner);
		}
	}
	
	public void closeCurrentPlayAGameWindow() {
		switch (gameStage) {
		case "quater final 1":
			quaterFinalGames.get(0).getStage().close();
			break;
		case "quater final 2":
			quaterFinalGames.get(1).getStage().close();
			break;
		case "quater final 3":
			quaterFinalGames.get(2).getStage().close();
			break;
		case "quater final 4":
			quaterFinalGames.get(3).getStage().close();
			break;
		case "half final 1":
			halfFinalGames.get(0).getStage().close();
			break;
		case "half final 2":
			halfFinalGames.get(1).getStage().close();
			break;
		case "final":
			finalGame.getStage().close();
		}
	}
	
	public void updatePlayAGameWindow(int numOfPlays) {
		switch (gameStage) {
		case "quater final 1":
			quaterFinalGames.get(0).updatePlayFiels(numOfPlays);
			break;
		case "quater final 2":
			quaterFinalGames.get(1).updatePlayFiels(numOfPlays);
			break;
		case "quater final 3":
			quaterFinalGames.get(2).updatePlayFiels(numOfPlays);
			break;
		case "quater final 4":
			quaterFinalGames.get(3).updatePlayFiels(numOfPlays);
			break;
		case "half final 1":
			halfFinalGames.get(0).updatePlayFiels(numOfPlays);
			break;
		case "half final 2":
			halfFinalGames.get(1).updatePlayFiels(numOfPlays);
			break;
		case "final":
			finalGame.updatePlayFiels(numOfPlays);
		}
	}
	
	public void disableButton() {
		switch (gameStage) {
		case "quater final 1":
			allPlayAGameButtons.get(0).setDisable(true);
			break;
		case "quater final 2":
			allPlayAGameButtons.get(1).setDisable(true);
			break;
		case "quater final 3":
			allPlayAGameButtons.get(2).setDisable(true);
			break;
		case "quater final 4":
			allPlayAGameButtons.get(3).setDisable(true);
			break;
		case "half final 1":
			allPlayAGameButtons.get(4).setDisable(true);
			break;
		case "half final 2":
			allPlayAGameButtons.get(5).setDisable(true);
			break;
		case "final":
			allPlayAGameButtons.get(6).setDisable(true);
		}
	}
	
	public void updateWindowInEndOfPlays(Model model) {
		switch (gameStage) {
		case  "quater final 4":
			model.createHalfFinalGames();
			allPlayAGameButtons.get(4).setDisable(false);
			allPlayAGameButtons.get(5).setDisable(false);
			break;
		case "half final 2":
			model.createFinalGame();
			allPlayAGameButtons.get(6).setDisable(false);
			break;
		case "final":
			Alert msg1 = new Alert(AlertType.INFORMATION);
			msg1.setContentText("The winner is "+winner.getText());
			msg1.setHeaderText("WINNER");
			msg1.show();
			HBox exitBox= new HBox();
			exitBox.getChildren().addAll(exitLabel, exit);
			exitBox.setAlignment(Pos.CENTER_RIGHT);
			exitBox.setSpacing(25);
			HBox.setMargin(exitLabel, new Insets(0, 0, 100, 500));
			HBox.setMargin(exit, new Insets(0, 40, 100, 0));
			borders.setBottom(exitBox);
		}
	}
	
	public void updatePlayGameWindowToNotDigitsException() {
		Alert msg1 = new Alert(AlertType.ERROR);
		msg1.setContentText("Enter only digits");
		msg1.setHeaderText("Not Valid input");
		msg1.show();
		
		switch (gameStage) {
		case "quater final 1":
			quaterFinalGames.get(0).resetTheWrongScores();
			break;
		case "quater final 2":
			quaterFinalGames.get(1).resetTheWrongScores();
			break;
		case "quater final 3":
			quaterFinalGames.get(2).resetTheWrongScores();
			break;
		case "quater final 4":
			quaterFinalGames.get(3).resetTheWrongScores();
			break;
		case "half final 1":
			halfFinalGames.get(0).resetTheWrongScores();
			break;
		case "half final 2":
			halfFinalGames.get(1).resetTheWrongScores();
			break;
		case "final":
			finalGame.resetTheWrongScores();
		}	
	}
	
	public void updatePlayGameWindowToTieException() {
		Alert msg1 = new Alert(AlertType.ERROR);
		msg1.setContentText("Enter different scores");
		msg1.setHeaderText("No winner");
		msg1.show();
		
		switch (gameStage) {
		case "quater final 1":
			quaterFinalGames.get(0).resetTheScores();
			quaterFinalGames.get(0).resetTheFields();
			break;
		case "quater final 2":
			quaterFinalGames.get(1).resetTheScores();
			quaterFinalGames.get(1).resetTheFields();
			break;
		case "quater final 3":
			quaterFinalGames.get(2).resetTheScores();
			quaterFinalGames.get(2).resetTheFields();
			break;
		case "quater final 4":
			quaterFinalGames.get(3).resetTheScores();
			quaterFinalGames.get(3).resetTheFields();
			break;
		case "half final 1":
			halfFinalGames.get(0).resetTheScores();
			halfFinalGames.get(0).resetTheFields();
			break;
		case "half final 2":
			halfFinalGames.get(1).resetTheScores();
			halfFinalGames.get(1).resetTheFields();
			break;
		case "final":
			finalGame.resetTheScores();
			finalGame.resetTheFields();
		}
	}
	
	//controller connections
	
	public void addChangeListenerToGames(ChangeListener<Toggle> typeGameChanged) {
		group.selectedToggleProperty().addListener(typeGameChanged);
	}


	public void addEventHandlerToAddParticipant(EventHandler<ActionEvent> addAParticipantPressed) {
		addParticipant.setOnAction(addAParticipantPressed);
	}


	public void addEventHandlerToStartChampionship(EventHandler<ActionEvent> startChampionshipIsPressed) {
		startChampionship.setOnAction(startChampionshipIsPressed);
	}
	

	public void addEventHandlerToAllPlayGames(EventHandler<ActionEvent> playAGameIsPressed) {
		for (int i = 0; i < allPlayAGameButtons.size(); i++) {
			allPlayAGameButtons.get(i).setOnAction(playAGameIsPressed);
		}
	}

	public void addEventHandlerToDonePlayGames(EventHandler<ActionEvent> doneIsPressed) {
		switch (gameStage) {
		case "quater final 1":
			quaterFinalGames.get(0).addEventHandlerToDonePlayGames(doneIsPressed);
			break;
		case "quater final 2":
			quaterFinalGames.get(1).addEventHandlerToDonePlayGames(doneIsPressed);
			break;
		case "quater final 3":
			quaterFinalGames.get(2).addEventHandlerToDonePlayGames(doneIsPressed);
			break;
		case "quater final 4":
			quaterFinalGames.get(3).addEventHandlerToDonePlayGames(doneIsPressed);
			break;
		case "half final 1":
			halfFinalGames.get(0).addEventHandlerToDonePlayGames(doneIsPressed);
			break;
		case "half final 2":
			halfFinalGames.get(1).addEventHandlerToDonePlayGames(doneIsPressed);
			break;
		case "final":
			finalGame.addEventHandlerToDonePlayGames(doneIsPressed);
			break;
		}
	}

	public void addEventHandlerToExit(EventHandler<ActionEvent> exitIsPressed) {
		exit.setOnAction(exitIsPressed);
	}

	

	

	

	

	

	

	

	

	

	

	

	

	

	



	



	



	







	



	

}
