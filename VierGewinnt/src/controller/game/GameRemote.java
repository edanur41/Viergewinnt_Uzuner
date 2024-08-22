package controller.game;

import java.net.Socket;

import contoller.net.ListenService;
import contoller.net.VierGewinntSocket;
import controller.player.Player;
import javafx.concurrent.WorkerStateEvent;
import modell.Board;
import modell.Content;


/**
 * Game-stub on Client-Side 
 * @author eduzu
 *
 */
public class GameRemote implements Game {
	
	private Player player;
	private VierGewinntSocket socketToGame;
	private Board board;
	private ListenService listenService;
	
	/**
	 * Constructor with the corresponding player and Socket for the connection to server
	 * @param player The Player on the client
	 * @param socket The Socket for sending data to the server and the (real) game
	 */
	
	public GameRemote(Player player, Socket socket) {
		this.player = player;
		this.socketToGame = new VierGewinntSocket(socket);
		this.board = null;
		listenService = new ListenService(socketToGame);
		listenService.setOnSucceeded(
				(WorkerStateEvent t) -> {
					String s = (String) t.getSource().getValue();
					listenService.reset();
					process(s);
				}				
					
				);
	}
	
	/**
	 * Method for waiting of a response of the server. 
	 * It is analog to the interface of Player with the respective keywords
	 */
	
	private void listen() {
		System.out.println("Client wartet auf Nachricht");
		String s = socketToGame.receiveMessage();
		switch(s) {
		case "initialize": initialize(); break;
		case "enable": enable(); break;
		case "disable": disable();  break;
		case "place": place(); break;
		case "win" : win(); break;
		case "lose": lose(); break;
		case "draw" : draw(); break;
		}
	}
	
	private void process(String s) {
		switch(s) {
		case "initialize": initialize(); break;
		case "enable": enable(); break;
		case "disable": disable();  break;
		case "place": place(); break;
		case "win" : win(); break;
		case "lose": lose(); break;
		case "draw" : draw(); break;
		}
	}
	

	private void initialize() {
		Content c = socketToGame.receiveContent();
		int id = socketToGame.receieveInt();
		player.initialize(c, this, id);
		listenService.start();
	}
	
	private void enable() {
		board = socketToGame.receiveBoard();
		player.enable();
	}
	
	private void disable() {
		board = socketToGame.receiveBoard();
		player.disable();
		listenService.start();
	}
	
	private void place() {
		socketToGame.send(player.placeContent());
		listenService.start();
		}
	
	private void win() {
	    player.win();
	    socketToGame.close();
	}
	
	private void lose() {
		player.lose();
		socketToGame.close();
	}
	
	private void draw() {
		player.draw();
		socketToGame.close();
	}
	
	@Override
	public void start() {
		listenService.start();

	}

	@Override
	public void update() {
		socketToGame.send("update");
		listenService.start();

	}

	@Override
	public void save() {
		socketToGame.send("save");
        
	}

	@Override
	public void load() {
		socketToGame.send("load");
		listenService.start();
	}

	@Override
	public Board getBoard() {
	
		return board;
	}

}
