package controller;

import controller.game.Game;
import controller.game.GameImplementation;
import controller.player.PlayerGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainGUI extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		Game game = new GameImplementation(new PlayerGUI(), new PlayerGUI());
		game.start();
	}

	
	
	
	public static void main(String[] args) {
		launch(args);

	}

	

}
