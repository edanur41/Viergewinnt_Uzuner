
package modell;

import java.io.Serializable;

/**
 * Extended BoardMatrix, that implements SetBoard for setting Circle CRED and CYELLOW
 * @author eduzu
 *
 */
public class SetBoardMatrix extends BoardMatrix implements SetBoard, Serializable {

	public SetBoardMatrix() {
		super();
	}

	@Override
	public boolean setCRED(int row, int column) {
		if (!checkPosition(column)) {
			return false;
		}
		int row1 = 0;

		while (row1 + 1 < size1 && board[row1 + 1][column] == Content.EMPTY)
			row1++;
		board[row1][column] = Content.CRED;

		return true;
	}

	@Override
	public boolean setCYELLOW(int row, int column) {
		if (!checkPosition(column)) {
			return false;
		}
		int row1 = 0;

		while (row1 + 1 < size1 && board[row1 + 1][column] == Content.EMPTY)
			row1++;
		board[row1][column] = Content.CYELLOW;

		return true;
	}

}
