package View;

import java.util.ArrayList;

import Model.NotDigitsException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class PlayAGame {
	
	private Button done;
	private TextField score11;
	private TextField score12;
	private TextField score21;
	private TextField score22;
	private TextField score31;
	private TextField score32;
	private TextField score41;
	private TextField score42;
	private TextField score51;
	private TextField score52;
	private Label gameType;
	private Label participant1;
	private Label participant2;
	private HBox participant1Box;
	private HBox participant2Box;
	private VBox namesAndScores;
	private BorderPane borders;
	private Pane centerScreen;
	private DropShadow blurry;
	private ArrayList<TextField> allScores;
	private Stage stage;
	
	public PlayAGame(String participant1, String participant2, String gameType,Stage stage) {
		this.done= new Button("Done");
		done.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		
		this.gameType= new Label();
		this.gameType.setText(gameType +" game");
		this.gameType.setTextFill(Color.BLUE);
		this.blurry=new DropShadow();
		this.blurry.setColor(Color.BLACK);
		this.gameType.setEffect(blurry);
		this.gameType.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		
		this.participant1= new Label();
		this.participant1.setText(participant1);
		this.participant1.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		this.participant1.setPrefSize(100, 30);
		this.participant2= new Label();
		this.participant2.setText(participant2);
		this.participant2.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		this.participant2.setPrefSize(100, 30);
		
		allScores=new ArrayList<>();
		score11 = new TextField();
		allScores.add(score11);
		score12 = new TextField();
		allScores.add(score12);
		score21 = new TextField();
		allScores.add(score21);
		score22 = new TextField();
		allScores.add(score22);
		score31 = new TextField();
		allScores.add(score31);
		score32 = new TextField();
		allScores.add(score32);
		score41 = new TextField();
		allScores.add(score41);
		score42 = new TextField();
		allScores.add(score42);
		score51 = new TextField();
		allScores.add(score51);
		score52 = new TextField();
		allScores.add(score52);
		
		switch (gameType) {
		case "Tennis":
			score41.setVisible(false);
			score42.setVisible(false);
			score51.setVisible(false);
			score52.setVisible(false);
			break;
		case "Soccer":
			score31.setVisible(false);
			score32.setVisible(false);
			score41.setVisible(false);
			score42.setVisible(false);
			score51.setVisible(false);
			score52.setVisible(false);
			break;
		case "Basketball":
			score51.setVisible(false);
			score52.setVisible(false);
		}
		
		participant1Box= new HBox();
		participant1Box.getChildren().addAll(this.participant1, score11,score21,score31,score41,score51);
		participant1Box.setSpacing(20);
		HBox.setMargin(this.participant1, new Insets(100, 0, 0, 60));
		HBox.setMargin(this.score11, new Insets(100, 0, 0, 0));
		HBox.setMargin(this.score21, new Insets(100, 0, 0, 0));
		HBox.setMargin(this.score31, new Insets(100, 0, 0, 0));
		HBox.setMargin(this.score41, new Insets(100, 0, 0, 0));
		HBox.setMargin(this.score51, new Insets(100, 0, 0, 0));
		participant2Box= new HBox();
		participant2Box.getChildren().addAll(this.participant2, score12,score22,score32,score42,score52);
		participant2Box.setSpacing(20);
		HBox.setMargin(this.participant2, new Insets(0, 0, 0, 60));
		namesAndScores= new VBox();
		namesAndScores.getChildren().addAll(participant1Box,participant2Box);
		namesAndScores.setSpacing(35);
		namesAndScores.setAlignment(Pos.CENTER);
		VBox doneBox= new VBox();
		doneBox.getChildren().add(done);
		doneBox.setAlignment(Pos.CENTER);
		VBox.setMargin(done, new Insets(0, 0, 120, 0));
		
		centerScreen= new Pane();
		centerScreen.getChildren().add(namesAndScores);
		
		
		borders= new BorderPane();
		VBox headLine= new VBox();
		headLine.getChildren().add(this.gameType);
		headLine.setAlignment(Pos.CENTER);
		borders.setTop(headLine);
		borders.setLeft(centerScreen);
		borders.setBottom(doneBox);
		
		this.stage=stage;
		Scene scene = new Scene(borders,1200,520);
		this.stage.setScene(scene);
		this.stage.show();
	}


	public boolean checkInfoIsValid(int numOfPlays) throws NotDigitsException {
		for (int i = 0; i < numOfPlays*2; i++) {
			if(allScores.get(i).getText().isEmpty()) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Must fill out all scores");
				msg.setTitle("Score is not Valid");
				msg.show();
				return false;
			}
			for (int j = 0; j < allScores.get(i).getText().length(); j++) {
				if(allScores.get(i).getText().charAt(j)<'0' || allScores.get(i).getText().charAt(j)>'9' ) {
					throw new NotDigitsException("Input incorrect- not all digits");
				}
			}
			
		}
		return true;
	}
	
	public int calculateScorePlayer1(int numOfPlays) {
		int score=0;
		switch (numOfPlays) {
		case 2:
			score=score+Integer.parseInt(score11.getText());
			score=score+Integer.parseInt(score21.getText());
			break;
		case 3:
			score=score+Integer.parseInt(score11.getText());
			score=score+Integer.parseInt(score21.getText());
			score=score+Integer.parseInt(score31.getText());
			break;
		case 4:
			score=score+Integer.parseInt(score11.getText());
			score=score+Integer.parseInt(score21.getText());
			score=score+Integer.parseInt(score31.getText());
			score=score+Integer.parseInt(score41.getText());
			break;
		case 5:
			score=score+Integer.parseInt(score11.getText());
			score=score+Integer.parseInt(score21.getText());
			score=score+Integer.parseInt(score31.getText());
			score=score+Integer.parseInt(score41.getText());
			score=score+Integer.parseInt(score51.getText());
		}
		return score;
	}
	
	public int calculateScorePlayer2(int numOfPlays) {
		int score=0;
		switch (numOfPlays) {
		case 2:
			score=score+Integer.parseInt(score12.getText());
			score=score+Integer.parseInt(score22.getText());
			break;
		case 3:
			score=score+Integer.parseInt(score12.getText());
			score=score+Integer.parseInt(score22.getText());
			score=score+Integer.parseInt(score32.getText());
			break;
		case 4:
			score=score+Integer.parseInt(score12.getText());
			score=score+Integer.parseInt(score22.getText());
			score=score+Integer.parseInt(score32.getText());
			score=score+Integer.parseInt(score42.getText());
			break;
		case 5:
			score=score+Integer.parseInt(score12.getText());
			score=score+Integer.parseInt(score22.getText());
			score=score+Integer.parseInt(score32.getText());
			score=score+Integer.parseInt(score42.getText());
			score=score+Integer.parseInt(score52.getText());
		}
		return score;
	}
	
	public Stage getStage() {
		return this.stage;
	}

	public void updatePlayFiels(int numOfPlays) {
		switch (numOfPlays) {
		case 5:
			score41.setVisible(true);
			score42.setVisible(true);
			score51.setVisible(true);
			score52.setVisible(true);
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Adding two more sets");
			msg.setHeaderText("No winner");
			msg.show();
			break;
		case 3:
			score31.setVisible(true);
			score32.setVisible(true);
			Alert msg1 = new Alert(AlertType.ERROR);
			msg1.setContentText("Adding one more half");
			msg1.setHeaderText("No winner");
			msg1.show();
			break;
		case 4:
			score41.setVisible(true);
			score42.setVisible(true);
			Alert msg2 = new Alert(AlertType.ERROR);
			msg2.setContentText("Adding penelty kicks");
			msg2.setHeaderText("No winner");
			msg2.show();
			break;
		}
	}
	
	public void resetTheWrongScores() {
		for (int i = 0; i < allScores.size(); i++) {
			for (int j = 0; j < allScores.get(i).getText().length(); j++) {
				if(allScores.get(i).getText().charAt(j)<'0' ||allScores.get(i).getText().charAt(j)>'9') {
					allScores.get(i).setText("");
				}
			}
		}
	}
	
	public void resetTheScores() {
		for (int i = 0; i < allScores.size(); i++) {
			allScores.get(i).setText("");
		}
	}
	
	public void resetTheFields() {
		switch (this.gameType.getText()) {
		case "Tennis game":
			score41.setVisible(false);
			score42.setVisible(false);
			score51.setVisible(false);
			score52.setVisible(false);
			break;
		case "Soccer game":
			score31.setVisible(false);
			score32.setVisible(false);
			score41.setVisible(false);
			score42.setVisible(false);
			score51.setVisible(false);
			score52.setVisible(false);
			break;
		case "Basketball game":
			score51.setVisible(false);
			score52.setVisible(false);
		}
	}
	
	public void addEventHandlerToDonePlayGames(EventHandler<ActionEvent> doneIsPressed) {
		this.done.setOnAction(doneIsPressed);
	}


	


	


	


	


	


	


	






	
}
