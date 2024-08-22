package controller.saveload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modell.PersistenceObject;
import modell.SetBoard;
import modell.SetBoardMatrix;


/**
 * Writes a PersistenceObject in the file board.ser
 * @param the PersistenceObject for saving
 */

public class FileWriterReader {
	
	public static void writeToFile(PersistenceObject po) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("board.ser"));
			oos.writeObject(po);
			oos.flush();
			oos.close();
			
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * Reads a PersistenceObject from the file board.ser
	 * @return In a success, the PersistenceObject that was loaded, null otherwise
	 */
	public static PersistenceObject readFromFile() {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("board.ser"));
		    Object o = ois.readObject();
		    ois.close();
		    PersistenceObject po = (PersistenceObject) o;
		    return po;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 

}
