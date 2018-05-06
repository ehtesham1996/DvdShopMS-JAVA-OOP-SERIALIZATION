package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddDel extends JFrame {
	JButton b1,b2,b3,b4,close,addstock;
	JLabel l1;
	
	AddDel(){
		super("Add Del Sub Menu");
		setContentPane(new JLabel(new ImageIcon(getClass().getResource("ss.jpg"))));
		setSize(600,330);
		setLayout(null);
		b1=new JButton("Add Dvd");
		b2=new JButton("Delete Dvd");
		b3=new JButton("Add Customer");
		b4=new JButton("Del Customer");
		addstock=new JButton("Add Stocks");
		close=new JButton("Close");
		l1=new JLabel("ADD Delete SubMenu");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 20));
		b1.addActionListener(new ls());
		b2.addActionListener(new ls());
		b3.addActionListener(new ls());
		b4.addActionListener(new ls());
		add(l1).setBounds(230, 10, 300, 70);
		add(b1).setBounds(50, 60, 150, 50);
		add(b2).setBounds(230,60 ,150, 50);
		add(b3).setBounds(50, 140, 150, 50);
		add(b4).setBounds(230, 140, 150, 50);
		add(addstock).setBounds(410, 60, 150, 50);
		
		addstock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddStock();
			}
		});
		add(close).setBounds(280, 230, 100, 50);
		close.addActionListener(new ls());
		setVisible(true);
		setResizable(false);
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeleteCustomer();
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeleteDvd();
			}
		});
	}
	public class ls implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddNewDvd s;
			AddNewCustomer m;
			if(e.getSource()==b1)
			s=new AddNewDvd();
			if(e.getSource()==b3)
				m=new AddNewCustomer();
			
			if(e.getSource()==close)
				dispose();
		}
		
}
}