package controller.player;

import java.net.Socket;

import contoller.net.VierGewinntSocket;
import controller.game.Game;
import modell.Content;
import modell.Position;

/**
 * The Player-Stub on Server-side
 * @author eduzu
 *
 */

public class PlayerRemote implements Player {
	
	private VierGewinntSocket socketToPlayer;
	private Game game;
	
	/**
	 * Constructor with the corresponding Socket
	 * @param socket The socket to send and receive data from the client
	 */
	
	public PlayerRemote(Socket socket) {
		
		socketToPlayer = new VierGewinntSocket(socket);
		game = null;
	}
	
	/**
	 * Waiting for a response of the client. It is almost analog to the interface Game.
	 */
	
	private void listen() {
		System.out.println("Client wartet auf Nachricht");
		String s = socketToPlayer.receiveMessage();
		switch(s) {
		case "update": game.update();  break;
		case "save" : game.save(); listen(); break;
		case "load" : game.load(); break;
		default: listen();
		}
	}
	

	@Override
	public void initialize(Content content, Game game, int id) {
		this.game = game;
		socketToPlayer.send("initialize");
		socketToPlayer.send(content);
        socketToPlayer.sent(id);
	}

	@Override
	public int placeContent() {
		socketToPlayer.send("place");
		Position p = socketToPlayer.receivePosition();
		return 0;
	}

	@Override
	public void enable() {
		socketToPlayer.send("enable");
        socketToPlayer.send(game.getBoard());
	}

	@Override
	public void disable() {
	socketToPlayer.send("disable");
	socketToPlayer.send(game.getBoard());

	}

	@Override
	public void win() {
		socketToPlayer.send("win");

	}

	@Override
	public void lose() {
		socketToPlayer.send("lose");

	}

	@Override
	public void draw() {
		socketToPlayer.send("draw");

	}

}
