package modell;

public interface Board {
	/**
	 * 
	 * Method for checking if the position p is in bounds and the content is empty
	 * @param column - the position to check
	 * @return true if the given column is in bounds and the content is empty otherwise false
	 */
	public boolean checkPosition(int column);
	
	/**
	 * Checks whether a given column is in bounds
	 * @param column - the position to check
	 * @return true if the given column is in bounds
	 */
	public boolean inBounds(int column);
	
	/**
	 * Checks if the player with the given content has won
	 * @param c - the content indicating the player
	 * @return true if there is a complete row, complete column or one of the diags filled with c
	 */
	public boolean win(Content c);
	
	/**
	 * Checks whether there is an empty content in the board
	 * @return false if there is no empty content in the board.
	 */
	public boolean finish();
	
	/**
	 * Returns the content of the given position
	 * @param row and column - the position in the board
	 * @return the content row and column, when outside the bounds it returns empty
	 */
	public Content getContent(int row, int column);


}
