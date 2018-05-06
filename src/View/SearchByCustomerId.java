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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Customer;
import Model.DVD;


public class SearchByCustomerId extends JFrame {
	JLabel lmain;
	JTextField tmain;
	Button b1;
	String code;
	SearchByCustomerId(){
		code = JOptionPane.showInputDialog(
		        null, 
		        "Enter the 	Customer id", 
		        "Search by  Customer id", 
		        JOptionPane.QUESTION_MESSAGE
		    );
	 if(code!=null){
		 Customer c;
			JFrame jf=new JFrame("View Dvd by BarCode");
			jf.setContentPane(new JLabel(new ImageIcon("C:\\ss.jpg")));
			
			int ab=1;
			JLabel l1,l2,l3,l4;
			JLabel t1,t2,t3,t4;
			l1=new JLabel("Name");
			l2=new JLabel("Age");
			l3=new JLabel("Customer ID");
			l4=new JLabel("Phone No");
	
			
			l1.setForeground(Color.WHITE);
			l2.setForeground(Color.WHITE);
			l3.setForeground(Color.WHITE);
			l4.setForeground(Color.WHITE);
			
		
			jf.add(l1);
			jf.add(l2);
			jf.add(l3);
			jf.add(l4);
		
		
			try {
				ObjectInputStream x = new ObjectInputStream(new FileInputStream("Customer.ser"));
				
				while (true) {
					c= (Customer) x.readObject();
					if(c.getCustomerId().equals(code)){
						t1=new JLabel(c.getName());
						t2=new JLabel(c.getAges());
						t3=new JLabel(c.getCustomerId());
						t4=new JLabel(c.getPhoneNo());
						
						t1.setForeground(Color.WHITE);
						t2.setForeground(Color.WHITE);
						t3.setForeground(Color.WHITE);
						t4.setForeground(Color.WHITE);	
						
						jf.add(t1);
						jf.add(t2);
						jf.add(t3);
						jf.add(t4);
				
						ab++;
						
					
					}
					
				}
			}catch(Exception ghj){
				return;
			}
			finally{
				dispose();
				jf.setLayout(new GridLayout(ab, 4));
				jf.setVisible(true);
				jf.setSize(1000, (ab*10)+100);
				jf.validate();
			}
	}
		
	}
	
}