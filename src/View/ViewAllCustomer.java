package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import Model.Customer;


public class ViewAllCustomer extends JFrame {
	private JLabel l;
	private JTextField t;
	private Button b;
	
	ViewAllCustomer(){
		
		Customer s;
		
		setContentPane(new JLabel(new ImageIcon(getClass().getResource("ss.jpg"))));
		
		int ab=1;
		JLabel l1,l2,l3,l4;
		JLabel t1,t2,t3,t4;
		l1=new JLabel("Name");
		l1.setForeground(Color.WHITE);
		
		
		l2=new JLabel("Age");
		l3=new JLabel("Customer ID");
		l4=new JLabel("Phone");
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
	
		
	
		try {
			ObjectInputStream x = new ObjectInputStream(new FileInputStream("Customer.ser"));
			
			while (true) {
				s = (Customer) x.readObject();
				
					t1=new JLabel(s.getName());
					t2=new JLabel(s.getAges());
					t3=new JLabel(s.getCustomerId());
					t4=new JLabel(s.getPhoneNo());
					t1.setForeground(Color.WHITE);
					t2.setForeground(Color.WHITE);
					t3.setForeground(Color.WHITE);
					t4.setForeground(Color.WHITE);	
					add(t1);
					add(t2);
					add(t3);
					add(t4);
				
					ab++;
					
					
				
				
			}
		}catch(Exception ghj){
			return;
		}
		finally{
			setLayout(new GridLayout(ab, 4));
			setVisible(true);
			setSize(1000, (ab*10)+100);
			validate();
		}
	}

	}
