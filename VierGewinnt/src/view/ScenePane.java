package view;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Class for the root node of the Scene Graph extends a Border Pane
 * @author eduzu
 *
 */

public class ScenePane extends BorderPane {

	private PlayerPane playerPane;
	private int id;
	
	private Color playerColor;
	
	private Label label;
	private ProgressBar progressBar;
	
	private String labelDisable;
	private String labelEnable;
	private String labelWin;
	private String labelLose;
	private String labelDraw;
	
	/**
	 * The constructor of the scene pane, 
	 * @param the node for displaying the board
	 * @param id
	 */
	
	public ScenePane(PlayerPane playerPane, int id, MenuItem menuSave, MenuItem menuLoad) {
		super();
		this.playerPane= playerPane;
		this.id = id;
		
		playerColor = id == 1 ? Color.RED : Color.YELLOW;
		
		label = new Label("");
		progressBar = new ProgressBar();
		labelDisable = "Warten auf Spieler " + ((id % 2) + 1);
		labelEnable = "Machen Sie Ihren Zug";
		labelWin = "Sie haben gewonnen";
		labelLose = "Sie haben verloren";
		labelDraw = "Unentschieden";
		init();
		setMenu(menuSave, menuLoad);
	}
	
	private void init() {
		AnchorPane center = new AnchorPane();
		center.getChildren().add(playerPane);
		AnchorPane.setTopAnchor(playerPane, 60.);
		AnchorPane.setLeftAnchor(playerPane, 80.);
		
		this.setCenter(center);
		
		HBox bottomBox = new HBox(30);
		
		Text text = new Text("Spieler " + id);
		text.setFill(playerColor);
		text.setEffect(new Lighting());
		text.setFont(Font.font(Font.getDefault().getFamily(), 50));
		
		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(progressBar, label);
		
		bottomBox.getChildren().addAll(text, vbox);
		this.setBottom(bottomBox);
	}
	
	private void setMenu(MenuItem menuSave, MenuItem menuLoad) {
	MenuBar menuBar = new MenuBar();
	menuBar.setUseSystemMenuBar(true);
	
	Menu menu = new Menu("Speichern / Laden");
	menu.getItems().addAll(menuSave, menuLoad);
	
	menuBar.getMenus().add(menu);
	
	this.setTop(menuBar);
	
	}
	
	
	/**
	 * Display the label for disable 
	 */
	
	public void disable() {
		label.setText(labelDisable);
		progressBar.setProgress(-1);
	}
	
	/**
	 * Display the label for enable 
	 */
	
	public void enable() {
		label.setText(labelEnable);
		progressBar.setProgress(1);
	}
	
	/**
	 * Display the label for win 
	 */
	
	public void win() {
		label.setText(labelWin);
	}
	
	/**
	 * Display the label for lose 
	 */
	
	public void lose() {
		label.setText(labelLose);
	}
	
	/**
	 * Display the label for draw 
	 */
			
	public void draw() {
		label.setText(labelDraw);
	}
}
