package View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Customer;
import Model.DVD;

public class AddNewDvd extends JFrame {
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel l1,l2,l3,l4,l5,l6,l10;
	JButton b1,b2;
	JComboBox box1,box2;
	String mediatype="DVD",subtype="Games";
	AddNewDvd(DVD a){
		DVD d=a;
		boolean success = false;
        ObjectOutputStream outputStream = null;

		try {
     			ArrayList<DVD> dvdList = readAllData();
     			
     			
     			outputStream = new ObjectOutputStream(new FileOutputStream("DVD.ser"));
     			for(int i = 0 ; i < dvdList.size() ; i++)
     				{	
     					if(dvdList.get(i).getBarcode()==a.getBarcode())
     						dvdList.get(i).setStock(a.getStock());
     					
     				}
     			for(int i=0 ;i <dvdList.size() ;i++){
     				outputStream.writeObject(dvdList.get(i));
			}} 
		catch(IOException error) 
		{
			System.out.println("IO Exception while opening file");
		} 
		finally 
		{ 
			try 
			{
				if(outputStream != null) 
				{
					outputStream.close();	
				}
			} 
			catch (IOException error) 
			{
				System.out.println("IO Exception while closing file");
			}
		}
		
			
		}
	
	AddNewDvd(){
			super("Add Dvd");
			setSize(500,300);
			setLayout(new BorderLayout());
			l10=new JLabel("Add New Game Dvd Form");
			add(l10,BorderLayout.NORTH);
			JPanel p=new JPanel();
			JPanel p1=new JPanel();
			
			l1=new JLabel("Name");
			l2=new JLabel("Barcode");
			l3=new JLabel("Media Type");
			l4=new JLabel("Copies");
			l5=new JLabel("Sub Type");
			l6=new JLabel("Cost");
			
			t1=new JTextField();
			t2=new JTextField();
			t3=new JTextField();
			t4=new JTextField();
			t5=new JTextField();
			t6=new JTextField();
			
			String[] forbox1={"Dvd","CD","BluRay"};
			String[] forbox2={"Games","Movies","Software","Song"};
			
			box1=new JComboBox(forbox1);
			box2=new JComboBox(forbox2);
			
			p.setLayout(new GridLayout(8 ,2));
			p.add(l1);
			p.add(t1);
			p.add(l2);p.add(t2);p.add(l3);p.add(box1);p.add(l4);p.add(t4);p.add(l5);p.add(box2);p.add(l6);p.add(t6);
			
			add(p,BorderLayout.CENTER);
			setResizable(false);
			p1.setLayout(new FlowLayout());
			
			b1=new JButton("ADD");
			b2=new JButton("Cancel");
			
			p1.add(b1);
			p1.add(b2);
			
			box1.addActionListener(new ActionListener() {

				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JComboBox combo=(JComboBox) arg0.getSource();
					mediatype= (String) combo.getSelectedItem();
					
				}
			});
			box2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JComboBox combo=(JComboBox) e.getSource();
					subtype= (String) combo.getSelectedItem();
				}
			});

			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					DVD d=new DVD(Integer.parseInt(t6.getText()),Long.parseLong(t2.getText()),mediatype,t1.getText(),Integer.parseInt(t4.getText()),subtype);
					boolean success = false;
	                ObjectOutputStream outputStream = null;
			
					try {
			     			ArrayList<DVD> dvdList = readAllData();
			     			dvdList.add(d);
			     			outputStream = new ObjectOutputStream(new FileOutputStream("DVD.ser"));
			     			for(int i = 0 ; i < dvdList.size() ; i++)
			     				{
			     					outputStream.writeObject(dvdList.get(i));
			     				}
						} 
					catch(IOException error) 
					{
						System.out.println("IO Exception while opening file");
					} 
					finally 
					{ 
						try 
						{
							if(outputStream != null) 
							{
								outputStream.close();	
							}
						} 
						catch (IOException error) 
						{
							System.out.println("IO Exception while closing file");
						}
					}
					dispose();
					JOptionPane.showMessageDialog (null, "Your data has been saved", "Result", JOptionPane.INFORMATION_MESSAGE);
						
					}
				});
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
			add(p1,BorderLayout.SOUTH);
			setVisible(true);
			}
	public ArrayList<DVD>  readAllData () { 
				ArrayList<DVD> dvdList = new ArrayList<DVD>(0);
				ObjectInputStream inputStream = null;
				try
				{
					inputStream = new ObjectInputStream(new FileInputStream("DVD.ser"));
					boolean EOF = false;
					while(!EOF) 
					{
							try 
							{
								DVD myObj = (DVD) inputStream.readObject();
								dvdList.add(myObj);
							}
							catch (ClassNotFoundException e) 
							{
							}
							catch (EOFException end) 
							{
								EOF = true;
							}
					}
				} 
				catch(FileNotFoundException e) 
				{
				} 
				catch (IOException e) 
				{
				} 
				finally 
				{ 	
					try 
					{
						if(inputStream != null)
							inputStream.close( );
					} 
					catch (IOException e) 
					{
						System.out.println("IO Exception while closing file");
					}
				}
				return dvdList;
	 }											
}
	