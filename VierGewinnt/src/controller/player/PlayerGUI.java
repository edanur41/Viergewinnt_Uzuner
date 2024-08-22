package controller.player;

import controller.game.Game;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import modell.Content;
import modell.Position;
import view.PlayerPane;
import view.PlayerStage;
import view.ScenePane;


/**
 * Class for the bridge between controller and view
 * @author eduzu
 *
 */
public class PlayerGUI implements Player{

	private PlayerPane playerPane;
	private ScenePane scenePane;
	private PlayerStage stage;
	
	private MenuItem menuSave;
	private MenuItem menuLoad;
	
	private Content content;
	private Game game;
	private int id;
	private Position position;
	private boolean enable;
	
	public PlayerGUI() {
		
	}
	

	
	@Override
	public void initialize(Content content, Game game, int id) {
		this.content = content;
		this.game = game;
		this.id = id;
		
		
		
		 playerPane = new PlayerPane();	
		 
		playerPane.setOnMouseClicked(
				(MouseEvent me) -> { System.out.println("click"); 
			        if(enable) {
					position = new Position(
							(int) me.getY() / playerPane.getUnit(),
							(int) me.getX() / playerPane.getUnit());
					System.out.println(position.getRow() + "," + position.getColumn());
					if(game.getBoard().checkPosition(position.getColumn())) {
						
					
				game.update();
					}
			        }	
				});		 
		 
		menuSave = new MenuItem("Speichern");
		menuSave.setOnAction((ActionEvent ae) -> {
			if(enable) {
				game.save();
			}
		});
		
		menuLoad = new MenuItem("Laden");
		menuLoad.setOnAction((ActionEvent ae) -> {
			if(enable) {
				game.load();
				playerPane.reset();
			}
		});
		
		menuSave.setDisable(true);
		menuLoad.setDisable(true);
		
		
         scenePane = new ScenePane(playerPane, id, menuSave, menuLoad );
		
         stage = new PlayerStage(scenePane);
		 stage.show();	
		
	}
	
	
	

	@Override
	public int placeContent() {
		int temp = position.getColumn();
	    position = new Position (-1,-1);
		return temp;
	}

	@Override
	public void enable() {
	this.enable = true;
	playerPane.update(game.getBoard());
	scenePane.enable();
	menuSave.setDisable(false);
	menuLoad.setDisable(false);
	}

	@Override
	public void disable() {
		this.enable = false;
		playerPane.update(game.getBoard());
		scenePane.disable();
		menuSave.setDisable(true);
		menuLoad.setDisable(true);	
	}

	@Override
	public void win() {
	scenePane.win();
		
	}

	@Override
	public void lose() {
		scenePane.lose();
		
	}

	@Override
	public void draw() {
		scenePane.draw();
		
	}

}
