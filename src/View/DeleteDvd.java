package View;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Customer;
import Model.DVD;

public class DeleteDvd extends JFrame {
	String code;
	DeleteDvd(){
		code = JOptionPane.showInputDialog(
		        null, 
		        "Enter the 	Dvd Name or BarCode", 
		        "Search by  Dvd Name or BarCode", 
		        JOptionPane.QUESTION_MESSAGE
		    );
	 if(code!=null){
	
            
            ArrayList<DVD> dvdList = readAllData() ;
    
            
            for(int i = 0 ; i<dvdList.size() ; i++){
            	if(dvdList.get(i).getName().equalsIgnoreCase(code)||dvdList.get(i).getBarcode()==Long.parseLong(code))
            	{
            		dvdList.remove(i);
            		JOptionPane.showMessageDialog(null,"Succesfully Deleted!");
            	}
            
            }
            
            try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DVD.ser"));
				for(int i = 0 ; i<dvdList.size() ; i++){
					out.writeObject(dvdList.get(i));
				}
	            }
				
             catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
}public ArrayList<DVD>  readAllData ()
{
//  ArrayList initialized with size 0
ArrayList<DVD> dvdList = new ArrayList<DVD>(0);
//Input stream
ObjectInputStream inputStream = null;
try
{
//open file for reading
inputStream = new ObjectInputStream(new FileInputStream("DVD.ser"));
//End Of File flag
boolean EOF = false;
//Keep reading file until file ends
while(!EOF) {
try {
//read object and type cast into CarDetails object
DVD myObj = (DVD) inputStream.readObject();
//add object into ArrayList
dvdList.add(myObj);
//System.out.println("Read: " + myObj.getName());
} catch (ClassNotFoundException e) {
//System.out.println("Class not found");
} catch (EOFException end) {
//EOFException is raised when file ends
//set End Of File flag to true so that loop exits
EOF = true;
}
}
} catch(FileNotFoundException e) {
//System.out.println("Cannot find file");
} catch (IOException e) {
//System.out.println("IO Exception while opening stream");
//e.printStackTrace();
} finally { // cleanup code to close stream if it was opened
try {
if(inputStream != null)
inputStream.close( );
} catch (IOException e) {
//TODO Auto-generated catch block
System.out.println("IO Exception while closing file");
}
}return dvdList;
}
}
