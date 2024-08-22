package controller.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.game.Game;
import modell.Board;
import modell.Content;
import modell.Position;

/**
 * Command User Interface implemenatation of the player
 * @author eduzu
 *
 */

public class PlayerCUI implements Player {

	private Content content;
	private Game game;
	private int id;
	private Position position;
	private int column;

	
	/**
	 * Constructor of the Player, sets everything with dummy values
	 */
	
	public PlayerCUI() {
		this.content = Content.EMPTY;
		this.game = null;
		this.id = 0;
		this.position = new Position(-1, -1);

	}

	@Override
	public void initialize(Content content, Game game, int id) {
		this.content = content;
		this.game = game;
		this.id = id;
	}
	
	/**
	 * Private Method for reading an int from terminal
	 * @return the value that is typed in the terminal, or -1 if there was an error
	 */

	private int readInt() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			int i = Integer.parseInt(input);
			System.out.println(i);
			return i;
		} catch (IOException e) {
			return -1;
		} catch(NumberFormatException e) {
			return -1;
		}
		
	}
	

	@Override
	public int placeContent() {

		return column;
	}

	@Override
	public void enable() {
		Board board = game.getBoard();
		System.out.println("spieler " + id + "ist dran");
		System.out.println(board);
		int input = -1;

		do {
			System.out.println("Wollen Sie ein " + content + " platzieren, oder speichern oder laden?");
			System.out.println(" 0 \t für platzieren \n 1 \t für speichern \n 2 \t für laden");
			input = readInt();
		} while (input < 0 || input > 2);

		if (input == 2) {
			game.save();
		} else if (input == 2) {
			game.load();
			return;
		}

		do {
			
			
			int row = readInt();
			System.out.println("Wählen Sie eine Spalte");
			int column = readInt();
			position = new Position(row, column);
		} while (!board.checkPosition(column));

		game.update();

	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void win() {
		System.out.println("Spieler " + id + " hat gewonnen!");

	}

	@Override
	public void lose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		
		System.out.println("Unentschieden!");

	}

}
