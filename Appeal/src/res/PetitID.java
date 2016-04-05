package res;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PetitID extends Object implements Serializable {
	
	private static final long serialVersionUID = -3895203507200457732L;
	
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public  PetitID readPetitID() {
		try{
	        FileInputStream fileOut = new FileInputStream("D:\\Appeals3\\Appeal\\res\\PetitID.bin");
	        ObjectInputStream in = new ObjectInputStream(fileOut);
	        PetitID object = (PetitID) in.readObject();
	        in.close();
	        System.out.println("This is info : " + object.getNum()+"   "+ object.toString());
	        return object;
	    }catch(IOException i){
	        i.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public  void writePetitID(int num) {
		try{
			PetitID object = new PetitID();
			object.setNum(num);
	        FileOutputStream fileOut = new FileOutputStream("D:\\Appeals3\\Appeal\\res\\PetitID.bin");
	        System.out.println("This is info@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ : " + object.getNum()+"   "+ object.toString());
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(object);
	        out.close();
	    }catch(IOException i){
	        i.printStackTrace();
	    }		
	}
}
