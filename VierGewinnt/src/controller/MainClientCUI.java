package controller;

import java.io.IOException;
import java.net.Socket;

import controller.game.Game;
import controller.game.GameRemote;
import controller.player.PlayerCUI;

public class MainClientCUI {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 6789);
			Game game = new GameRemote(new PlayerCUI(), socket);
			game.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
