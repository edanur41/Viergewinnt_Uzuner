package controller.player;

import java.util.Random;

import controller.game.Game;
import modell.Board;
import modell.Content;
import modell.Position;

/**
 * 
 * Implementation of a simple Computer - Player
 * @author eduzu
 *
 */

public class PlayerKI implements Player {

	private Content content;
	private Game game;
	private int id;
	private Random random;
	private int column;
	private int position;
	
	public PlayerKI() {
		content = Content.EMPTY;
		game = null;
		id = -1;
		random = new Random();
	}
	
	
	
	@Override
	public void initialize(Content content, Game game, int id) {
		this.content = content;
		this.game = game;
		this.id = id;
		
	}

	@Override
	public int placeContent() {
		Board board = game.getBoard();
		int column = -1;
		do {
		int column1 = random.nextInt(3);
		} while (!board.checkPosition(column));
		return column ;
	}


	@Override
	public void enable() {
	game.update();

	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void win() {
		System.out.println(game.getBoard());
		System.out.println("Robo " + id + " hat gewonnen");

	}

	@Override
	public void lose() {
		System.out.println();

	}

	@Override
	public void draw() {
		System.out.println(game.getBoard());
		System.out.println("Untentschieden");

	}

}
