package modell;

public interface SetBoard extends Board {

	/**
	 * Sets a CRED at the desired row and column , when the column was in bounds and it was empty before
	 * @param row and column  for setting the circle CRED
	 * @return true, if the given row and column  on the board is Content.EMPTY, false otherwise
	 */
	public boolean setCRED(int row,int column);
	
	/**
	 * Sets a CYELLOW at the desired row and column , when the column was in bounds and it was empty before
	 * @param row and column  for setting the circle CYELLOW
	 * @return true, if the given row and column  on the board is Content.EMPTY, false otherwise
	 */
	
	public boolean setCYELLOW(int row, int column);

	
	
}
