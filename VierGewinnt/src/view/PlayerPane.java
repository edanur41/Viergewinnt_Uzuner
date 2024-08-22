package view;

import javafx.animation.TranslateTransition;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import modell.Board;
import modell.Content;
import modell.Position;
import modell.SetBoardMatrix;

/**
 * Class for the graphical representation of the board
 * 
 * @author eduzu
 *
 */

public class PlayerPane extends Pane {

	private int unit;
	private double offset;

	private Board board;

	/**
	 * Constructor
	 */

	public PlayerPane() {
		super();
		this.board = board;
		this.unit = 80;
		this.offset = unit / 8;
		this.setPrefSize(6 * unit, 7 * unit);
		setGrid();
	}

	/**
	 * Returns the width / height of one cell as int
	 * @return The unit of one cell
	 */
	
	public int getUnit() {
		return unit;
	}

	private void setGrid() {
		 
			Rectangle rct = new Rectangle(7*unit, 6*unit, Color.ROYALBLUE);
			getChildren().add(rct);
			for(int row = 0; row < 6; row++)
				for(int column = 0; column < 7; column++) {
					double centerWidth = column* unit +unit/2;
					double radius = unit/2 -offset;	
					double centerHeight =row*unit +unit/2;
					
					Circle lightsteelblue= new Circle(centerWidth,centerHeight,radius,Color.LIGHTSTEELBLUE);
					getChildren().add(lightsteelblue);
				}
	}

	/**
	 * Draws a Circle CRED at a given row and column
	 * @param Row and column to insert the circle
	 */
	
	public void addCRED(int row, int column) {
		double centerX = column * unit + unit / 2;
		double centerY = row * unit + unit / 2;
		double radius = unit / 2 - offset;
		Circle circle = new Circle(centerX, centerY, radius, Color.DARKRED);

		Light.Distant light = new Light.Distant();
		light.setAzimuth(45.0);

		Lighting lighting = new Lighting();
		lighting.setLight(light);
		lighting.setSurfaceScale(5.0);
		circle.setEffect(lighting);

		getChildren().add(circle);

	}
	
	/**
	 * Draws a Circle CYELLOW at a given row and column 
	 * @param Row and column to insert the circle
	 */
	public void addCYELLOW(int row, int column) {
		double centerX = column * unit + unit / 2;
		double centerY = row * unit + unit / 2;
		double radius = unit / 2 - offset;

		Circle circle = new Circle(centerX, centerY, radius, Color.YELLOW);

		Light.Distant light = new Light.Distant();
		light.setAzimuth(45.0);

		Lighting lighting = new Lighting();
		lighting.setLight(light);
		lighting.setSurfaceScale(5.0);
		circle.setEffect(lighting);

		getChildren().add(circle);

	}

	
	public void reset() {
		this.board = new SetBoardMatrix();
		
	}
	
	/**
	 * Draws a complete board
	 * @param The board to draw.
	 */
	
	public void update(Board board) {
		System.out.println(board);
		getChildren().clear();
		setGrid();

		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 7; column++) {

				if (board.getContent(row, column) == Content.CRED) {
					addCRED(row, column);
				} else if (board.getContent(row, column) == Content.CYELLOW) {
					addCYELLOW(row, column);

				}

			}
		}
	}
}
