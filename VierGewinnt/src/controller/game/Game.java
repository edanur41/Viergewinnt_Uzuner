package controller.game;

import modell.Board;

public interface Game {
	
	
	/**
	 * Method for starting the game
	 */
	
	public void start();
	
	/**
	 * The game-loop where all the logic happens.
	 */
	
	public void update();
	/*
	 * if(status == PLAYER1){
	 *  if(board.setCRED(player1.placeContent()){
	 *     player1.disable();
	 *      if(board.win(Content.CRED)){
	 *         status = WINPLAYER;
	 *      } else if (board.finish()){
	 *         status = DRAW;
	 *      } else{
	 *             status = PLAYER2;
	 *      }
	 *   }  else{
	 *       player1.enable();
	 *   } else if(status == PLAYER2);
	 *      if(board.setCYELLOW(player2.placeContent()){
	 *          player2.disable();
	 *      if(board.win(Content.CYELLOW)){
	 *          status = WINPLAYER2;
	 *       } else {
	 *             status = PLAYER1;
	 *       }
	 *     } else { 
	 *          player2.enable();
	 *     }
	 *     
	 *                   }
	 *                   
	 *                   }
	 *          
	 *      if(status == PLAYER1){
	 *      player	.enable();
	 *      } else if(status == PLAYER2){
	 *        player2.enable();
	 *        } else if(status == WINPLAYER2){
	 *        player1.lose();
	 *        player2.win();
	 *        } else{
	 *        player1.draw();
	 *        player2.draw();
	 *        }        
	 *                       
	 * 
	 * 
	 * 
	 */
	
	
	/**
	 * Method for saving the game
	 */
	
	public void save();
	
	/**
	 * Method for loading a previously saved game
	 */
	
	public void load();
	
	/**
	 * Method for returning the current board
	 * @return The board for displaying
	 */
	public Board getBoard();
	

}
