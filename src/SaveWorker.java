import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;

public class SaveWorker{

	public static void saveObject(String path, Object object) {
		FileOutputStream file;
		try {
			file = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(object);
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object getObject(String path) {
		Object a;
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
	        a = (Object) in.readObject();
	        in.close();
	        fileIn.close();
	        return a;	
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
