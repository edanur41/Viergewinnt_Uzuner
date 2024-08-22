package modell;

import java.io.Serializable;

public class PersistenceObject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632423027912527248L;
	private SetBoard board;
	private int status;
    
	public PersistenceObject(SetBoard board, int status) {
    	this.board = board;
    	this.status = status;
    }
	
	public SetBoard getBoard() {
		return board;
	}
	
	public int getStatus() {
		return status;
	}
}
