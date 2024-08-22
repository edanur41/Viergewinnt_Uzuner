package controller;

import java.net.Socket;

import controller.game.Game;
import controller.game.GameRemote;
import controller.player.PlayerGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainClientGUI extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {
		Socket socket = new Socket("localhost", 6789);
		Game game = new GameRemote(new PlayerGUI(), socket);
		game.start();
		
	}

}
