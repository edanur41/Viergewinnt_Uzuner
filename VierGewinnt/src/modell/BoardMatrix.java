package modell;

import java.io.Serializable;

/**
 * 
 * Implementation of the Board using Arrays
 * @author eduzu
 * 
 */

public class BoardMatrix implements Board, Serializable {

	protected Content[][] board;
	protected int size1;
	protected int size2;

/**
 * Constructor of the class generating a board of size 6 x 7
 * 
 **/
	

	public BoardMatrix() {
		size1 = 6;
		size2 = 7;
		board = new Content[size1][size2];
		for (int row = 0; row < size1; row++) {
			for (int column = 0; column < size2; column++) {
				board[row][column] = Content.EMPTY;
			}
		}

	}

	@Override
	public boolean checkPosition(int column) {
		int row = 0;
		if (inBounds(column))
			for (row = 0; row < size1; row++) {
				if (board[row][column] == Content.EMPTY) {
					return true;
				}

			}
		return false;
	}

	@Override
	public boolean inBounds(int column) {
		return column < size2 && column >= 0;
	}

	@Override
	public boolean win(Content c) {
		for(int row = 0; row < size1; row++) {
			if(winRow(c,row)) {
				return true;
			}
		}
		for(int column = 0; column < size1; column++) {
			if(winColumn(c,column)) {
				return true;
			}
		}
		return winDiagRight(c) || winDiagLeft(c);
	}
	
	private boolean winRow(Content c, int row) {
		int counter=0;
		for(int column = 0; column < size2; column++) {
			if(getContent(row,column) == c) {
				counter++;
			}else if(getContent(row, column) != c && (c != Content.EMPTY)) {
				counter=0;
			}
			if(counter>=4) {
				return true;
			}
		}
		return false;
	}
	
	private boolean winColumn(Content c, int column) {
		int counter=0;
		for(int row = 0; row < size1; row++) {
			if(getContent(row,column) == c) {
				counter++;
			}else if(getContent(row, column)!= c &&(c != Content.EMPTY)) {
				counter=0;
			}
			if(counter>=4) {
				return true;
			}
		}
		return false;
	}
	private Content getContent(Position position) {

		return board[position.getRow()][position.getColumn()];
	}
	

	private boolean winDiagRight(Content c) {
		for(int i = 0; i < size1-3; i++) {
			for(int j = 0; j < size2-3; j++) {
				if((board[i][j] == c)&&(board[i+1][j+1] == c)&&(board[i+2][j+2]== c)&&(board[i+3][j+3] == c)){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean winDiagLeft(Content c) {
		for(int i = 0; i < size1-3; i++) {
			for(int j = 6; j >2; j--) {
				if((board[i][j] == c)&&(board[i+1][j-1] == c)&&(board[i+2][j-2]== c)&&(board[i+3][j-3] == c)){
					return true;
				}
			}
		}
		return false;
	}
	

	@Override
	public boolean finish() {
		for (Content[] row : board) {
			for (Content c : row) {
				if (c == Content.EMPTY) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public Content getContent(int row, int column) {
		if (inBounds(column)) {
			return board[row][column];
		}
		return Content.EMPTY;

	}
	
	public String toString() {
		String s = "";
		for (Content[] row : board) {
			for (Content c : row) {
				s += c + "\t";
			}
			s += "\n";
		}
		return s;
	}


}
