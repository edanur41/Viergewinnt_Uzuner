package controller;


import controller.saveload.FileWriterReader;
import modell.BoardMatrix;
import modell.Content;
import modell.SetBoard;
import modell.SetBoardMatrix;

public class TestBoard {

	public static void main(String[] args) {
    SetBoardMatrix sbm = new SetBoardMatrix();

    

  /*  sbm.setCYELLOW(4);
   * sbm.setCRED(4);
   * sbm.setCYELLOW(3);
   *sbm.setCRED(2);
   *sbm.setCYELLOW(1);
   *sbm.setCRED(5);
   *sbm.setCYELLOW(2);
   *sbm.setCRED(5);
   */
    
    System.out.println(sbm);
   
    System.out.println("Rot hat gewonnen?" + sbm.win(Content.CRED));
	System.out.println("Gelb hat gewonnen?" + sbm.win(Content.CYELLOW));
     
	//FileWriterReader.writeToFile(sbm);
	
	//SetBoard sb = FileWriterReader.readFromFile();
	//System.out.println(sb);
	
	} 

}
