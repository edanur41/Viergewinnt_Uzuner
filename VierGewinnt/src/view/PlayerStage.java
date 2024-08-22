package view;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Class for construction a window
 * 
 * @author eduzu
 *
 */

public class PlayerStage extends Stage {

	private ScenePane scenePane;

	
	/**
	 * Constructor
	 * @param The root of the Scene Graph
	 */
	public PlayerStage(ScenePane scenePane) {
		super();
		this.scenePane = scenePane;
		setTitle("Vier Gewinnt 2020");
		Scene scene = new Scene(scenePane, 400, 400, Color.WHITESMOKE);
		setScene(scene);
	}

}
