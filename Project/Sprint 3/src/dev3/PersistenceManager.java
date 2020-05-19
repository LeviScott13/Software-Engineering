package dev3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class PersistenceManager {

	/**
	 * 
	 */
	// private static final long serialVersionUID = -6024446693705877688L;

	public PersistenceManager() {

	}

	public static void save(SiteManager sm, File file) throws IOException {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(file));
			outputStream.writeObject(sm);
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static SiteManager read(File file) throws IOException {
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			SiteManager sm = (SiteManager) in.readObject();
			in.close();
			return sm;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {

		}
		return null;
	}
}
