package controller;

import controller.player.PlayerGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modell.Content;
import modell.SetBoard;
import modell.SetBoardMatrix;
import view.PlayerPane;
import view.PlayerStage;
import view.ScenePane;

public class TestGUI extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*PlayerPane pane = new PlayerPane();
		SetBoard board = new SetBoardMatrix();
		board.setCRED(3);
		board.setCYELLOW(2);
		board.setCRED(3);
		
		
		
		pane.addCRED(0, 2);
		
		PlayerPane pane2 = new PlayerPane();
		pane2.update(board);
		
		ScenePane scenePane = new ScenePane(pane, 1);
		ScenePane scenePane2 = new ScenePane(pane, 2);
		scenePane.enable();
		scenePane.disable();
		
		PlayerStage stage1 = new PlayerStage(scenePane);
		PlayerStage stage2 = new PlayerStage(scenePane2);
		
		stage1.show();
		stage2.show();
		
		
		
		
		/*Scene scene = new Scene(pane);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		*/
		
		PlayerGUI player = new PlayerGUI();
		player.initialize(Content.CRED, null, 1);
	}

	
	public static void main(String[] args) {
	    launch(args);
	}

	
}
