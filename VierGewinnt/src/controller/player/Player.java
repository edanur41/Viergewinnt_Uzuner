package controller.player;

import controller.game.Game;

import modell.Content;
import modell.Position;



public interface Player {
	
	/**
	 * Method for initializing the player with the Content and id and the corresponding game
	 * @param content The content, either CRED or CYELLOW
	 * @param game The corresponding game
	 * @param id The id of the player
	 */
	
	public void initialize(Content content, Game game, int id);
	
	/**
	 * Method for returning the chosen column for placing the content
	 * @return the chosen column 
	 */
	
	public int placeContent();
	
	/**
	 * Enables the player. Now the player can choose a position
	 */
	
	public void enable();
	
	/**
	 * Disables the player. The other player will be enabled or the game is over.
	 */
	
	public void disable();
	
	/**
	 * Displaying that the player has won
	 */
	
	public void win();
	
	/**
	 * Displaying that the player has lost
	 */
	
	public void lose();
	
	/**
	 * Displaying that there is no winner
	 */
	
	public void draw();
	
	
	
	

}
