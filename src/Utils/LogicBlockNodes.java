package Utils;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class LogicBlockNodes<ClasseIn,ClasseOut> implements Serializable{

	ArrayList<ClasseIn> inNodeList;
	ArrayList<ClasseOut> outNodeList;
	ArrayList<Point> inPositionList;
	ArrayList<Point> outPositionList;
	public LogicBlockNodes() {
	
		inNodeList = new ArrayList<ClasseIn>();
		outNodeList = new ArrayList<ClasseOut>();
		inPositionList = new ArrayList<Point>();
		outPositionList = new ArrayList<Point>();
			
	}
	
	public void addInNode(ClasseIn node, Point pos) {
		inNodeList.add(node);
		inPositionList.add(pos);
	}
	
	public void addOutNode(ClasseOut node, Point pos) {
		outNodeList.add(node);
		inPositionList.add(pos);
	}
	
	
	public ArrayList<ClasseIn> getInNodeList() {
		return inNodeList;
	}

	public void setInNodeList(ArrayList<ClasseIn> inNodeList) {
		this.inNodeList = inNodeList;
	}

	public ArrayList<ClasseOut> getOutNodeList() {
		return outNodeList;
	}

	public void setOutNodeList(ArrayList<ClasseOut> outNodeList) {
		this.outNodeList = outNodeList;
	}

	public ArrayList<Point> getInPositionList() {
		return inPositionList;
	}

	public void setInPositionList(ArrayList<Point> inPositionList) {
		this.inPositionList = inPositionList;
	}

	public ArrayList<Point> getOutPositionList() {
		return outPositionList;
	}

	public void setOutPositionList(ArrayList<Point> outPositionList) {
		this.outPositionList = outPositionList;
	}

	public boolean saveNodes(String path) {
		FileOutputStream file;
		try {
			file = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this);
			out.close();
			file.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}
	
	public boolean loadNodes (String path) {
		FileInputStream fileIn;
		LogicBlockNodes<ClasseIn, ClasseOut> a;
		try {
			fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
	        a = (LogicBlockNodes<ClasseIn, ClasseOut>) in.readObject();
	        in.close();
	        fileIn.close();
	        
	        this.setInNodeList(a.getInNodeList());
	        this.setInPositionList(a.getInPositionList());
	        this.setOutNodeList(a.getOutNodeList());
	        this.setOutPositionList(a.getOutPositionList());
	        
	        return true;
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
		return false;
        
	}
	
	
	
}
