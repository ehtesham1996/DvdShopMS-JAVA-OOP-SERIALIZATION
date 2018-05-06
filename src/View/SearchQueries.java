package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Model.Customer;
import Model.DVD;



public class SearchQueries extends JFrame {
	JButton close,back,ViewAllCustomer,ViewAllDvd,ViewGames,ViewSoftware,ViewSongs,ViewMovies,SearchByName,SearchDvdByBarcode,ViewBillByID;
	JButton searchbycustomerid;
	JLabel l1;
	
	SearchQueries(){
		super("Search Queries ");
		setContentPane(new JLabel(new ImageIcon(getClass().getResource("background.jpg"))));
		setSize(1200,600);
		setLayout(null);
		close=new JButton("close");
		back=new JButton("back");
		ViewAllCustomer=new JButton("VIew All CuSTOMER dATA");
		ViewAllDvd=new JButton("View All Dvd in Shop");
		ViewGames=new JButton("VIew All Games Dvd");
		ViewSoftware = new JButton("View All Software Dvd");
		ViewSongs=new JButton("View All Songs Dvd");
		ViewMovies=new JButton("View All Movies");
		SearchByName=new JButton("Serach DVD by Name");
		SearchDvdByBarcode =new JButton("Search by BarCode");
		ViewBillByID=new JButton("View bill by id");
		searchbycustomerid=new JButton("Search Customer by id");
		
		l1=new JLabel("Search Queries");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Arial",Font.BOLD,24));
		close.addActionListener(new ls());
		back.addActionListener(new ls());
		ViewAllCustomer.addActionListener(new ls());
		ViewAllDvd.addActionListener(new ls());
		ViewGames.addActionListener(new ls());
		ViewSongs.addActionListener(new ls());
		ViewMovies.addActionListener(new ls());
		ViewSoftware.addActionListener(new ls());
		add(l1).setBounds(550, 10, 300, 100);
		add(back).setBounds(10, 10, 100, 30);
		add(ViewAllCustomer).setBounds(200,100 ,200, 50);
		add(close).setBounds(950, 500, 100, 50);
		add(ViewAllDvd).setBounds(200,200 , 200, 50);
		add(ViewGames).setBounds(200, 300, 200, 50);
		add(ViewMovies).setBounds(550, 300, 200, 50);
		add(ViewSongs).setBounds(550, 200, 200,50);
		add(ViewSoftware).setBounds(200, 400, 200, 50);
		add(SearchByName).setBounds(550, 100, 200, 50);
		add(SearchDvdByBarcode).setBounds(550, 400, 200, 50);
		add(ViewBillByID).setBounds(900, 100, 200, 50);
		add(searchbycustomerid).setBounds(900, 200, 200, 50);
		
		searchbycustomerid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchByCustomerId();
			}
		});
		ViewBillByID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String code = JOptionPane.showInputDialog(
					        null, 
					        "Enter the Bill no", 
					        "Search by bill no", 
					        JOptionPane.QUESTION_MESSAGE
					    );
				 if(code!=null){
					 new ViewBillByID(code);
				 }
			}
		});
		SearchDvdByBarcode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchDvdByBarcode();
			}
		});
		SearchByName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SerachByDvdName();
			}
		});
		setVisible(true);
		setResizable(false);
	
	}
	public class ls implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) throws InputMismatchException {
			// TODO Auto-generated method stub
			ViewAllCustomer m;
			MainMenu d;
			if(e.getSource()==ViewAllCustomer)
			m=new ViewAllCustomer();
			if(e.getSource()==close)
				dispose();
			if(e.getSource()==back)
			{
				dispose();
				d=new MainMenu();
			}
			if(e.getSource()==ViewSongs){
				DVD song;
				JFrame jf=new JFrame("View All Songs");
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
						song= (DVD) x.readObject();
						if(song.getSubType().equals("Song")){
							t1=new JLabel(song.getName());
							t2=new JLabel(song.getMediaType());
							t3=new JLabel(String.valueOf(song.getCost()));
							t4=new JLabel(String.valueOf(song.getStock()));
							t5=new JLabel(String.valueOf(song.getBarcode()));
							t6=new JLabel(song.getSubType());
							
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
			if(e.getSource()==ViewSoftware){
				DVD dvd;
				JFrame jf=new JFrame("View All Software");
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
						if(dvd.getSubType().equals("Software")){
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
			if(e.getSource()==ViewMovies){
				DVD dvd;
				JFrame jf=new JFrame("View All Movies");
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
						if(dvd.getSubType().equals("Movies")){
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
			if(e.getSource()==ViewGames){
				DVD dvd;
				JFrame jf=new JFrame("View All Games");
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
						if(dvd.getSubType().equals("Games")){
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
			if(e.getSource()==ViewAllDvd)
			{
				DVD dvd;
				JFrame jf=new JFrame("View All Dvd");
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
}}}