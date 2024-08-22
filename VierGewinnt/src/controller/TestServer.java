package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import contoller.net.VierGewinntSocket;
import modell.SetBoard;
import modell.SetBoardMatrix;

public class TestServer {

	
	public static void main(String[]args) {
	    try {
			ServerSocket ssocket = new ServerSocket(6789);
			Socket socket = ssocket.accept();
			VierGewinntSocket vgs = new VierGewinntSocket(socket);
			
			
			vgs.send("Hallo Spieler");
			
			
			System.out.println(vgs.receiveMessage());
			SetBoard board = new SetBoardMatrix();
			board.setCRED(2,1);
			vgs.send(board);
			vgs.close();
		
	    
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
}
	
	
}
