package controller;

import java.io.IOException;
import java.net.Socket;

import contoller.net.VierGewinntSocket;

public class TestClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 6789);
			VierGewinntSocket vg = new VierGewinntSocket(socket);
			System.out.println(vg.receiveMessage());
			
			vg.send("Hallo Spiel");
			
			System.out.println(vg.receiveBoard());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
