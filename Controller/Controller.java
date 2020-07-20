package Controller;


import Model.Model;
import Model.NotDigitsException;
import Model.TieException;
import View.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model theModel, View theView) {
		this.model=theModel;
		this.view=theView;
		
		ChangeListener<Toggle> typeGameChanged= new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				view.updateWindow();
				model.updateGameType(view.getGameType());
			}
		};
		view.addChangeListenerToGames(typeGameChanged);
		
		EventHandler<ActionEvent> addAParticipantPressed= new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean isValid=view.checkIfNameValid();
				if(isValid) {
					boolean addMore=model.addParticipant(view.getParticipantName());
					view.updateParticipant(model.getAddedParticipant(), model.getNumOfParticipants());
					if (!addMore) {
						view.updateWindowToMaxParticipants();
					}
				}
			}
		};
		view.addEventHandlerToAddParticipant(addAParticipantPressed);
		
		EventHandler<ActionEvent> startChampionshipIsPressed= new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.updateWindowToStartChampionship();
				model.createQuterFinalGames();
				createEventHandlerForPlayAGame();
			}
		};
		view.addEventHandlerToStartChampionship(startChampionshipIsPressed);
		
		EventHandler<ActionEvent> exitIsPressed= new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		};
		view.addEventHandlerToExit(exitIsPressed);
	}

	private void createEventHandlerForPlayAGame() {
		EventHandler<ActionEvent> playAGameIsPressed= new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.setGameStage(view.getIndexOfButton(event.getTarget()));
				model.setGameStage(view.getGameStage());
				view.createPlayAGameWindow(model.getParticipant1(),model.getParticipant2());
				createEventHandlerToDone();
			}
		};
		view.addEventHandlerToAllPlayGames(playAGameIsPressed);
	}

	private void createEventHandlerToDone() {
		EventHandler<ActionEvent> doneIsPressed= new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean isValid;
				try {
					isValid = view.checkInfoIsValid(model.getNumOfPlays());
					if(isValid) {
						model.setScoreParticipant1(view.getScoreParticipant1(model.getNumOfPlays()));
						model.setScoreParticipant2(view.getScoreParticipant2(model.getNumOfPlays()));
						boolean isWinner= model.checkIsWinner();
						if(isWinner) {
							model.setWinner();
							view.setWinner(model.getWinner());
							view.closeCurrentPlayAGameWindow();
							view.disableButton();
							view.updateWindowInEndOfPlays(model);
						}else {
							model.updateNumOfPlays();
							view.updatePlayAGameWindow(model.getNumOfPlays());
						}
					}
				} catch (NotDigitsException e) {
					view.updatePlayGameWindowToNotDigitsException();
				} catch (TieException e) {
					view.updatePlayGameWindowToTieException();
					model.resetGame();
				}
			}
		};
		view.addEventHandlerToDonePlayGames(doneIsPressed);
	}

}
