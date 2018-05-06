package View;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Customer;


public class AddNewCustomer extends JFrame implements Serializable{
	JButton b1,b2;
	JTextField t1,t2,t3,t4;
	JLabel l1,l2,l3,l4,l10;
	AddNewCustomer(){
			super("Add New Customer");
			setSize(500,200);
			setLayout(new BorderLayout());
			l10=new JLabel("Add New Dvd Form");
			add(l10,BorderLayout.NORTH);
			JPanel p=new JPanel();
			JPanel p1=new JPanel();
			l1=new JLabel("Name");
			l2=new JLabel("Age");
			l3=new JLabel("Customer ID");
			l4=new JLabel("Phone No");
			t1=new JTextField();
			t2=new JTextField();
			t3=new JTextField();
			t4=new JTextField();
			p.setLayout(new GridLayout(4 ,2));
			p.add(l1);
			p.add(t1);
			p.add(l2);p.add(t2);p.add(l3);p.add(t3);p.add(l4);p.add(t4);
			add(p,BorderLayout.CENTER);
			setResizable(false);
			p1.setLayout(new FlowLayout());
			b1=new JButton("ADD");
			b2=new JButton("Cancel");
			p1.add(b1);
			p1.add(b2);
			b1.addActionListener(new mylistener());
			b2.addActionListener(new mylistener());
			add(p1,BorderLayout.SOUTH);
			setVisible(true);
			
		}
	AddNewCustomer(Customer c){
				Customer c1=c;
				
		        boolean success = false;
		        ObjectOutputStream outputStream = null;
		
		try {
		            // Read old objects
			ArrayList<Customer> CustomerList = readAllData();
			// Append new object into existing list
			CustomerList.add(c1);
			// Open Stream for writing
			outputStream = new ObjectOutputStream(new FileOutputStream("Customer.ser"));
			
			// Write all objects (old and new one) into the file
			for(int i = 0 ; i < CustomerList.size() ; i++) {
				outputStream.writeObject(CustomerList.get(i));
			}
		} catch(IOException error) {
			System.out.println("IO Exception while opening file");
		} finally { // cleanup code which closes output stream if its object was created
			try {
				if(outputStream != null) {
					outputStream.close();
					// flag of success
					
				}
		
			} catch (IOException error) {
				System.out.println("IO Exception while closing file");
			}
		}
			
		
		
			}
	public ArrayList<Customer>  readAllData ()
    {
      //  ArrayList initialized with size 0
ArrayList<Customer> CustomerList = new ArrayList<Customer>(0);
// Input stream
ObjectInputStream inputStream = null;
try
{
// open file for reading
inputStream = new ObjectInputStream(new FileInputStream("Customer.ser"));
// End Of File flag
boolean EOF = false;
// Keep reading file until file ends
while(!EOF) {
try {
// read object and type cast into CarDetails object
Customer myObj = (Customer) inputStream.readObject();
// add object into ArrayList
CustomerList.add(myObj);
//System.out.println("Read: " + myObj.getName());
} catch (ClassNotFoundException e) {
//System.out.println("Class not found");
} catch (EOFException end) {
// EOFException is raised when file ends
// set End Of File flag to true so that loop exits
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
// TODO Auto-generated catch block
System.out.println("IO Exception while closing file");
}
}return CustomerList;
    }
		public class mylistener implements ActionListener ,Serializable{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==b2){
					dispose();
				}
				if(e.getSource()==b1){
					Customer c1=new Customer(t1.getText(),t2.getText(),t3.getText(),t4.getText());
					
	                boolean success = false;
	                ObjectOutputStream outputStream = null;
			
			try {
	                    // Read old objects
				ArrayList<Customer> CustomerList = readAllData();
				// Append new object into existing list
				CustomerList.add(c1);
				// Open Stream for writing
				outputStream = new ObjectOutputStream(new FileOutputStream("Customer.ser"));
				
				// Write all objects (old and new one) into the file
				for(int i = 0 ; i < CustomerList.size() ; i++) {
					outputStream.writeObject(CustomerList.get(i));
				}
			} catch(IOException error) {
				System.out.println("IO Exception while opening file");
			} finally { // cleanup code which closes output stream if its object was created
				try {
					if(outputStream != null) {
						outputStream.close();
						// flag of success
						
					}

				} catch (IOException error) {
					System.out.println("IO Exception while closing file");
				}
			}
				
			dispose();
			JOptionPane.showMessageDialog (null, "Your data has been saved", "Result", JOptionPane.INFORMATION_MESSAGE);
				}}
			
				
				
			}
			
		}
	

