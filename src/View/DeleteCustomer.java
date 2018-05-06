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

public class DeleteCustomer extends JFrame {
		String code;
		DeleteCustomer(){
			code = JOptionPane.showInputDialog(
			        null, 
			        "Enter the 	Customer id or Name", 
			        "Search by  Customer id or Name", 
			        JOptionPane.QUESTION_MESSAGE
			    );
		 if(code!=null){
			 Customer M;
	            
	            ArrayList<Customer> CustomerList = readAllData() ;
	    
	            
	            for(int i = 0 ; i<CustomerList.size() ; i++){
	            	if(CustomerList.get(i).getName().equalsIgnoreCase(code)||CustomerList.get(i).getCustomerId().equalsIgnoreCase(code))
	            	{
	            		CustomerList.remove(i);
	            		JOptionPane.showMessageDialog(null,"Succesfully Deleted!");
	            	}
	            
	            }
	            
	            try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Customer.ser"));
					for(int i = 0 ; i<CustomerList.size() ; i++){
						out.writeObject(CustomerList.get(i));
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
}public ArrayList<Customer>  readAllData ()
{
    //  ArrayList initialized with size 0
ArrayList<Customer> CustomerList = new ArrayList<Customer>(0);
//Input stream
ObjectInputStream inputStream = null;
try
{
//open file for reading
inputStream = new ObjectInputStream(new FileInputStream("Customer.ser"));
//End Of File flag
boolean EOF = false;
//Keep reading file until file ends
while(!EOF) {
try {
//read object and type cast into CarDetails object
Customer myObj = (Customer) inputStream.readObject();
//add object into ArrayList
CustomerList.add(myObj);
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
}return CustomerList;
  }
}
