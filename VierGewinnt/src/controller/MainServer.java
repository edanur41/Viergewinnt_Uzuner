package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import controller.game.Game;
import controller.game.GameImplementation;
import controller.player.PlayerRemote;

public class MainServer {

	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(6789);
			Socket socket1 = serverSocket.accept();
			Socket socket2 = serverSocket.accept();
			Game game = new GameImplementation(new PlayerRemote(socket1), new PlayerRemote(socket2));
			game.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
