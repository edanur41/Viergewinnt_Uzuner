
package controller.game;

import controller.player.Player;

import controller.saveload.FileWriterReader;
import modell.Board;
import modell.Content;
import modell.PersistenceObject;
import modell.SetBoard;
import modell.SetBoardMatrix;
/**
 * 
 * The Implementation of the Game interface
 * @author eduzu
 *
 */


public class GameImplementation implements Game {

	private Player player1;
	private Player player2;
	private SetBoard board;
	private int status;

	private final int NOTSTARTED = 0;
	private final int PLAYER1 = 1;
	private final int PLAYER2 = 2;
	private final int WINPLAYER1 = 3;
	private final int WINPLAYER2 = 4;
	private final int DRAW = 5;

	
	/**
	 * Constructor for the game. 
	 * @param player1 the first player
	 * @param player2 the second player
	 */
	
	public GameImplementation(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;

		player1.initialize(Content.CRED, this, 1);
		player2.initialize(Content.CYELLOW, this, 2);
		board = new SetBoardMatrix();
		status = NOTSTARTED;

	}

	@Override
	public void start() {
		status = PLAYER1;
		player1.enable();

	}

	@Override
	public void update() {
		if (status == PLAYER1) {
			if (board.setCRED(0, player1.placeContent())) {
				player1.disable();
				if (board.win(Content.CRED)) {
					status = WINPLAYER1;
					player1.win();
					player2.lose();
				} else if (board.finish()) {
					status = DRAW;
					player1.draw();
					player2.draw();

				} else {
					status = PLAYER2;
					player2.enable();

				}

			} else {
				player1.enable();
			}
		} else if (status == PLAYER2) {

			if (board.setCYELLOW(0, player2.placeContent())) {
				player2.disable();
				if (board.win(Content.CYELLOW)) {
					status = WINPLAYER2;
					player2.win();
					player1.lose();
				} else if (board.finish()) {
					status = DRAW;
					player1.draw();
					player2.draw();
				} else {
					status = PLAYER1;
					player1.enable();
				}
			} else {
				player2.enable();
			}
		}

	}

	@Override
	public void save() {
		PersistenceObject po = new PersistenceObject(board, status);
		FileWriterReader.writeToFile(po);
	}

	@Override
	public void load() {
		PersistenceObject po = FileWriterReader.readFromFile();
		if (po != null) {
			this.status = po.getStatus();
			this.board = po.getBoard();
			if (status == PLAYER1) {
				player1.enable();
				player2.disable();
			} else if (status == PLAYER2) {
				player2.enable();
				player1.disable();
				

			}
		}
	}

	@Override
	public Board getBoard() {

		return board;
	}

}