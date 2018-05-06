package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class WelcomeScreen extends JFrame {
	JLabel l1;
	JButton b1,b2;
	
	WelcomeScreen(){
super("Welcome Screen");

setContentPane(new JLabel(new ImageIcon(getClass().getResource("background.jpg"))));
		
		setSize(1366,768);
		l1=new JLabel("Welcome TO Dvd Shop Managment System");
		
		b1=new JButton("Open Main Menu");
		b1.addActionListener(new ls());
		b2=new JButton("Exit");
		l1.setFont(new Font("Serif", Font.BOLD,28 ));
		l1.setForeground(Color.WHITE);
		setLayout(null);
		add(l1).setBounds(400,100, 600, 100);
		add(b1).setBounds(550, 300, 200, 80);
		add(b2).setBounds(1000, 650,200, 80);
		b2.addActionListener(new ls());
		setResizable(false);
		setVisible(true);
	}
	private class ls implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MainMenu m;
			if(arg0.getSource()==b1){
				dispose();
				m=new MainMenu();
			}
			
			
			if(arg0.getSource()==b2){
				System.exit(1);
			}
				
		}
		
	}
}
