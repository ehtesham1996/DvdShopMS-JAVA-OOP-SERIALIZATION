package View;

import java.awt.Color;
import java.awt.Font;
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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Model.Billings;
import Model.Customer;
import Model.DVD;

public class GenrateBill extends JFrame {
	JLabel heading,l1,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField l2;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JRadioButton b1,b2;
	JButton add,generatebill,exit;
	JComboBox combo;
	String[] list=new String[101];
	JPanel p;
	long subtotal=0;
	DVD[] arraydvd=new DVD[100];
	int[] q=new int[100];
	int ab=0;
	long discount=0;
	GenrateBill(){
		setContentPane(new JLabel(new ImageIcon(getClass().getResource("bill.jpg"))));
		for(int loop=0;loop<101;loop++)
			list[loop]=String.valueOf(loop);
		combo=new JComboBox(list);
		setSize(1000,600);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		heading=new JLabel("Create Bill");
		heading.setFont(new Font("Arial", Font.BOLD, 32));
		
		l1=new JLabel("Bill id:");
		l2=new JTextField();
		l3=new JLabel("Customer:");
		l4=new JLabel("Customer id:");
		l5=new JLabel("Name :");
		l6=new JLabel("Age :");
		l7=new JLabel("id:");
		l8=new JLabel("Phone no :");
		l9=new JLabel("Bar Code :");
		l10=new JLabel("Quantity Given:");
		l11=new JLabel("Discount % : ");
		l12=new JLabel("Subtotal:");
		l13=new JLabel("------");
		l12.setFont(new Font("Serif",Font.BOLD, 20));

		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		t8=new JTextField();
		
		b1=new JRadioButton("New ");
		b2=new JRadioButton("Old");
		add=new JButton("ADD");
		generatebill=new JButton("Generate Bill");
		exit=new JButton("Close");
		
		ButtonGroup bg=new ButtonGroup();
		
		bg.add(b1);
		bg.add(b2);
		b1.setSelected(true);
		
		add(heading).setBounds(400, 10, 500, 30);
		add(l1).setBounds(10,50 , 50, 20);
		add(l2).setBounds(70, 50, 150, 20);
		add(l3).setBounds(10, 80, 100, 20);
		add(b1).setBounds(80, 80, 70, 20);
		add(b2).setBounds(150, 80, 100, 20);
		add(l4).setBounds(10, 100, 100, 20);
		add(t1).setBounds(100, 100, 150, 20);
		add(l5).setBounds(10, 130, 100, 20);
		add(t2).setBounds(100, 130, 150, 20);
		add(l6).setBounds(10, 150, 100, 20);
		add(t3).setBounds(100, 150, 150, 20);
		add(l7).setBounds(10, 170, 100, 20);
		add(t4).setBounds(100, 170, 150, 20);
		add(l8).setBounds(10, 190, 100, 20);
		add(t5).setBounds(100, 190, 150, 20);
		add(l9).setBounds(10, 220, 100, 20);
		add(t6).setBounds(100, 220, 150, 20);
		add(l10).setBounds(270, 220, 100, 20);
		add(t7).setBounds(360, 220, 40, 20);
		add(add).setBounds(340, 240, 80, 20);
		add(l11).setBounds(10, 260, 100, 20);
		add(combo).setBounds(100,260, 50, 20);
		add(l12).setBounds(300,400 , 150, 30);
		add(l13).setBounds(390,400, 150, 30);
		add(generatebill).setBounds(10,500,130,30);
		add(exit).setBounds(150, 500, 130, 30);
		
		l4.setEnabled(false);
		t1.setEditable(false);
		
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JComboBox combo1=(JComboBox) e.getSource();
					discount=Long.parseLong((String)combo1.getSelectedItem());
					System.out.println(discount);
				}
					
					
			}
		);
		
		
		
		generatebill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				DVD[] dvdarray=arraydvd;
				Customer c =null ;
				int[] qq=q;
				
				if(b2.isSelected()){
					System.out.println("first if");
					c=getCustomer();
					if(c==null){
						
						JOptionPane.showMessageDialog (null, "The customer with this id does not exists", "Invalid Id", JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
				if(b1.isSelected()){
					System.out.println("second if");
					c=new Customer(t2.getText(),t3.getText(),t4.getText(),t5.getText());
					new AddNewCustomer(c);
				}
				System.out.println(c.getName());
				System.out.println("dvd array" +arraydvd[0].getName());
				System.out.println("quantity" +q[0]);
				System.out.println("haaha" +discount);
				System.out.println("heello" +subtotal);
				System.out.println(t1.getText());
				System.out.println(subtotal);
				subtotal=(long) (subtotal-((discount/100.00)*subtotal));
				System.out.println(subtotal);
				Billings b=new Billings(c,arraydvd,q,subtotal,discount,l2.getText());
				boolean success = false;
                ObjectOutputStream outputStream = null;
		
				try {
		     			ArrayList<Billings> billList = readAllData();
		     			billList.add(b);
		     			outputStream = new ObjectOutputStream(new FileOutputStream("Billings.ser"));
		     			for(int i = 0 ; i < billList.size() ; i++)
		     				{
		     					outputStream.writeObject(billList.get(i));
		     				}
					} 
				catch(IOException error) 
				{
					System.out.println("IO Exception while opening file hehe ");
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
				new ViewBillByID(l2.getText());
					
				}
			});
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l4.setEnabled(false);
				t1.setEditable(false);
				t1.setText(null);
				
				l5.setEnabled(true);
				l6.setEnabled(true);
				l7.setEnabled(true);
				l8.setEnabled(true);
				
				t2.setEditable(true);
				t3.setEditable(true);
				t4.setEditable(true);
				t5.setEditable(true);
				
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l4.setEnabled(true);
				t1.setEditable(true);
				
				l5.setEnabled(false);
				l6.setEnabled(false);
				l7.setEnabled(false);
				l8.setEnabled(false);
				
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				
				t2.setEditable(false);
				t3.setEditable(false);
				t4.setEditable(false);
				t5.setEditable(false);
			}
		});
		add.addActionListener(new addlistener());
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		setVisible(true);
	}
	public Customer getCustomer(){
		Customer returner = null;
		try {
			Customer ccc;
			ObjectInputStream x = new ObjectInputStream(new FileInputStream("Customer.ser"));
			boolean a=true;
			while (true) {
				ccc= (Customer) x.readObject();
				if(ccc.getCustomerId().equals(t1.getText())){
					returner= ccc ;
					a=false;
				}}
				
			}
		catch(Exception ghj){
			
		}
		return returner;
		
	}
	public class addlistener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub
			DVD dvd;
			
			l13.setVisible(false);
			int variable=0,row=1;
			JLabel k1,k2,k3,k4;
			JLabel j1,j2,j3,j4 = null ;
			p=new JPanel();
			k1=new JLabel("Name");
			k2=new JLabel("Cost");
			k3=new JLabel("Barcode");
			k4=new JLabel("Quantity given");
			
		
			p.add(k1);
			p.add(k2);
			p.add(k3);
			p.add(k4);
			for(int i=0;arraydvd[i]!=null;i++){
				j1=new JLabel(arraydvd[i].getName());
				j2=new JLabel(String.valueOf(arraydvd[i].getCost()));
				j3=new JLabel(String.valueOf(arraydvd[i].getBarcode()));
				j4=new JLabel(String.valueOf(q[i]));
				variable++;
				System.out.println("for working ");
			
				p.add(j1);
				p.add(j2);
				p.add(j3);
				p.add(j4);
			}
		
			try {
				ObjectInputStream x = new ObjectInputStream(new FileInputStream("DVD.ser"));
				
				while (true) {
					dvd= (DVD) x.readObject();
						if(dvd.getBarcode()==Long.parseLong(t6.getText())){
						dvd.setStock(dvd.getStock()-Integer.parseInt(t7.getText()));
						arraydvd[ab]=dvd;
						q[ab]=Integer.parseInt(t7.getText());
						j1=new JLabel(dvd.getName());
						j2=new JLabel(String.valueOf(dvd.getCost()));
						j3=new JLabel(String.valueOf(dvd.getBarcode()));
						j4=new JLabel(t7.getText());
						subtotal=subtotal+(dvd.getCost()*q[ab]);
						new AddNewDvd(dvd);
					
						p.add(j1);
						p.add(j2);
						p.add(j3);
						p.add(j4);
					
						row++;
						ab++;
						
						}
					}
					
				
			}catch(Exception ghj){
				return;
			}
			finally{
				
				l13.setText(String.valueOf(subtotal)+" Rs");
				l13.setFont(new Font("Serif", Font.BOLD, 30));
				t6.setText(null);
				t7.setText(null);
				add(p).setBounds(600, 100, 330, ((ab+variable)*20)+100);
				p.setSize(330,((ab+variable)*20)+100);
				
				p.setLayout(new GridLayout(row+variable, 4));
				p.setVisible(true);
				l13.setVisible(true);
				
				p.validate();
				
			}
		}
		
		
	}
public ArrayList<Billings>  readAllData () { 
	ArrayList<Billings> billList = new ArrayList<Billings>(0);
	ObjectInputStream inputStream = null;
	try
	{
		inputStream = new ObjectInputStream(new FileInputStream("Billings.ser"));
		boolean EOF = false;
		while(!EOF) 
		{
				try 
				{
					Billings myObj = (Billings) inputStream.readObject();
					billList.add(myObj);
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
	return billList;
}								
}