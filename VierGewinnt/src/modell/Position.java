package modell;

import java.io.Serializable;

/**
 * A class for representing a position in the board
 * @author eduzu
 *
 */

public class Position implements Serializable{


	private int row;
	private int column;
	
	/**
	 * The constructor with a given row and column
	 * @param row - a row in the board
	 * @param column - a column in the board
	 */
	
	public Position(int row, int column){
		this.row = row;
		this.column = column;
		}
	
	/**
	 * get-Method for row
	 * @return the row 
	 */
	
	public int getRow(){
		return row;
		
	}
	
	/**
	 * get-Method for column
	 * @return the column
	 */
	
	public int getColumn() {
		return column;
	}
	
	public String toString() {
		return " ( " + row +"," + column + ")";	
	}
	
	public boolean equals(Object o){
		if(o instanceof Position){
			Position p = (Position) o;
			return (p.getRow() == row && p.getColumn() == column);
			
		}
		return false;
			}
}

