package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.DVD;

public class AddStock extends JFrame {
	JLabel lmain;
	JTextField tmain;
	Button b1;
	String code;
	AddStock(){
		 code = JOptionPane.showInputDialog(
		        null, 
		        "Enter the Barcode", 
		        "Update Stock", 
		        JOptionPane.QUESTION_MESSAGE
		    );
	 if(code!=null){
		 DVD dvd;
			JFrame jf=new JFrame("View Dvd by BarCode");
			jf.setContentPane(new JLabel(new ImageIcon("C:\\ss.jpg")));
			
			int ab=1;
			JLabel l1,l2,l3,l4,l5,l6;
			JLabel t1,t2,t3,t4,t5,t6;
			l1=new JLabel("Name");
			l2=new JLabel("Media Type");
			l3=new JLabel("Cost");
			l4=new JLabel("Stock");
			l5=new JLabel("Barcode");
			l6=new JLabel("Sub Type");
			
			l1.setForeground(Color.WHITE);
			l2.setForeground(Color.WHITE);
			l3.setForeground(Color.WHITE);
			l4.setForeground(Color.WHITE);
			l5.setForeground(Color.WHITE);
			l6.setForeground(Color.WHITE);
		
			jf.add(l1);
			jf.add(l2);
			jf.add(l3);
			jf.add(l4);
			jf.add(l5);
			jf.add(l6);
	
		
			try {
				ObjectInputStream x = new ObjectInputStream(new FileInputStream("DVD.ser"));
				
				while (true) {
					dvd= (DVD) x.readObject();
					if(dvd.getBarcode()==(Long.parseLong(code))){
						String stock=JOptionPane.showInputDialog(
						        null, 
						        "Enter the Stock", 
						        "Update Stock", 
						        JOptionPane.QUESTION_MESSAGE
						    );
						dvd.setStock(dvd.getStock()+Integer.parseInt(stock));
						new AddNewDvd(dvd);
						t1=new JLabel(dvd.getName());
						t2=new JLabel(dvd.getMediaType());
						t3=new JLabel(String.valueOf(dvd.getCost()));
						t4=new JLabel(String.valueOf(dvd.getStock()));
						t5=new JLabel(String.valueOf(dvd.getBarcode()));
						t6=new JLabel(dvd.getSubType());
						
						t1.setForeground(Color.WHITE);
						t2.setForeground(Color.WHITE);
						t3.setForeground(Color.WHITE);
						t4.setForeground(Color.WHITE);	
						t5.setForeground(Color.WHITE);
						t6.setForeground(Color.WHITE);
					
						jf.add(t1);
						jf.add(t2);
						jf.add(t3);
						jf.add(t4);
						jf.add(t5);
						jf.add(t6);
				
						ab++;
						
					
					}
					
				}
			}catch(Exception ghj){
				return;
			}
			finally{
				
				jf.setLayout(new GridLayout(ab, 6));
				jf.setVisible(true);
				jf.setSize(1000, (ab*10)+100);
				jf.validate();
			}
	}
	
}}

