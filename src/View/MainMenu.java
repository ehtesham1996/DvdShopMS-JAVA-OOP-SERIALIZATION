package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;

public class MainMenu extends JFrame {
	JLabel l1;
	JButton b1,b2,adddel,queries,bill,back,close,update;
	MainMenu(){
		super("MainMenu");
		
		setSize(1366,768);
		l1=new JLabel("Main Menu");
		l1.setFont(new Font("Arial", Font.BOLD, 30));
		l1.setForeground(Color.WHITE);
		
		setContentPane(new JLabel(new ImageIcon(getClass().getResource("background.jpg"))));
		adddel=new JButton("ADD/DELETE MENU");
		queries=new JButton("SEARCH QUERIES");
		bill=new JButton("Generate Bill");
		update = new JButton("Update Menu");
		back=new JButton("Back");
		back.setIcon(new ImageIcon(getClass().getResource("back.png")));
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		close=new JButton("Close");
		back.addActionListener(new ls());
		close.addActionListener(new ls());
		add(close).setBounds(1150, 650, 150, 50);
		add(back).setBounds(30, 10, 150, 60);
		
		setLayout(null);
		add(l1).setBounds(570, 100, 200, 50);
		add(adddel).setBounds(550, 200, 200, 80);
		add(queries).setBounds(550, 300, 200, 80);
		add(bill).setBounds(550, 400, 200, 80);
		
		bill.addActionListener(new ls());
		adddel.addActionListener(new ls());
		queries.addActionListener(new ls());
		
		setResizable(false);
		setVisible(true);
		
		
	}
	private class ls implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			AddDel d;
			SearchQueries av;
			WelcomeScreen w;
			
			if(arg0.getSource()==adddel){
				d=new AddDel();
			}
			if(arg0.getSource()==b2){
				System.exit(1);
			}
			if(arg0.getSource()==close){
				dispose();
			}
			if(arg0.getSource()==back){
				dispose();
				w=new WelcomeScreen();
			}
			if(arg0.getSource()==queries)
				av=new SearchQueries();
			if(arg0.getSource()==bill)
				new GenrateBill();
			
		
		}
				
		}
		
	}
	

