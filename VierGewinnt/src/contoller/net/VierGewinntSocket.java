package contoller.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modell.Board;
import modell.Content;
import modell.Position;

/**
 * 
 * Class for sending and receiving messages via Sockets for VierGewinnt
 * @author eduzu
 *
 */
public class VierGewinntSocket {

	
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	
	/**
	 * Constructor 
	 * @param socket The socket for sending and receiving
	 */
	
	public VierGewinntSocket(Socket socket) {
		this.socket = socket;
		try {
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			try {
				socket.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}
}
	
	/**
	 * Method for closing the socket
	 */
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Receives an integer 
	 * @return The received integer or -1 in case of a failure
	 */
	
	public int receieveInt() {
		
		try {
			int id = in.readInt();
			System.out.println("Empfange ID " + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Receives a content
	 * @return The received Content or Content.Empty in case of a failure
	 */
	
	public Content receiveContent() {
		try {
			Content c = (Content) in.readObject();
			System.out.println("Empfange Content " + c);
			return c;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Content.EMPTY;
	}
	
	/**
	 * Receives a Board
	 * @return The received Board or null in case of a failure
	 */
	
	public Board receiveBoard() {
		try {
			Board board = (Board) in.readObject();
			System.out.println("Empfange Board " + board);
			return board;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Receives a Position
	 * @return The received Position or null in case of a failure
	 */
	public Position receivePosition() {
		try {
			Position position = (Position) in.readObject();
			return position;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Receives a Message as String
	 * @return The received String or "" in case of a failure
	 */
	
	public String receiveMessage() {
		try {
			String message = (String) in.readObject();
			System.out.println("Empfange Nachricht " + message);
			return message;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	/**
	 * Sends an integer
	 * @param id the int to send
	 */
	
	public void sent(int id) {
		System.out.println("Sende id " + id);
		try {
			out.writeInt(id);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a int
	 * @param position the position to send
	 */
     public void send(int position) {
    	 System.out.println("Sende int " + position);
    	 
    	 try {
			out.writeObject(position);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
	
	/**
	 * Sends a Content
	 * @param c The Content to send
	 */
	
	public void send(Content c) {
		System.out.println("Sende Content " + c);
		try {
			out.writeObject(c);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a board
	 * @param board The Board to send
	 */
	
	public void send(Board board) {
		System.out.println("Sende Board " + board);
		try {
			out.reset();
			out.writeObject(board);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a Position
	 * @param position The Position to send
	 */
	
	public void send(Position position) {
		System.out.println("Sende Position " + position );
		try {
			out.writeObject(position);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a String
	 * @param message The String to send
	 */
	
	public void send(String message) {
		System.out.println("SEnde Nachricht " + message);
		try {
			out.writeObject(message);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}