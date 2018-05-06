package View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Billings;
import Model.Customer;
import Model.DVD;


public class ViewBillByID extends JFrame implements Serializable,Printable {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26;
	JPanel p1;
	JButton print,exit;
	Billings bill,usingbill;
	int total=0;
	
	ViewBillByID(String s){
		try {
			ObjectInputStream x = new ObjectInputStream(new FileInputStream("Billings.ser"));
			
			while (true) {
				bill= (Billings) x.readObject();
				System.out.println("name is" +bill.getCustomer().getName());
				if(bill.getBillno().equals(s)){
					usingbill=bill;
					
				}
				
			}
		}catch(Exception ghj){
			
			return;
		}
		finally{
			setContentPane(new JLabel(new ImageIcon(getClass().getResource("bill.jpg"))));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		setSize(800,600);
		setLayout(null);
		p1=new JPanel();
		
		l1=new JLabel("Bill View");
		l2=new JLabel("Name: ");
		l3=new JLabel(usingbill.getCustomer().getName());
		l4=new JLabel("ID:");
		l5=new JLabel(usingbill.getCustomer().getCustomerId());
		l6=new JLabel("Phone:");
		l7=new JLabel(usingbill.getCustomer().getPhoneNo());
		l8=new JLabel("Dvd Bought");
		l10=new JLabel("Name");
		l11=new JLabel("Type");
		l12=new JLabel("Quantity");
		l13=new JLabel("Barcode");
		l14=new JLabel("Cost");
		
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l8.setFont(new Font("Arial",Font.BOLD,16));
		
		add(l1).setBounds(330, 10, 100, 20);
		add(l2).setBounds(50, 50, 100, 20);
		add(l3).setBounds(110, 50, 100, 20);
		add(l4).setBounds(290, 50, 100, 20);
		add(l5).setBounds(340, 50, 100, 20);
		add(l6).setBounds(500, 50, 100, 20);
		add(l7).setBounds(550, 50, 100, 20);
		add(l8).setBounds(50, 90, 100, 18);
		
		p1.add(l10);p1.add(l11);p1.add(l12);p1.add(l13);p1.add(l14);
		int row=1;
		System.out.println(usingbill.getDvd()[0].getName());
		for(int i=0;usingbill.getDvd()[i]!=null;i++){
			l15=new JLabel(usingbill.getDvd()[i].getName());
			l16=new JLabel(usingbill.getDvd()[i].getSubType());
			l17=new JLabel(String.valueOf(usingbill.getQuantity()[i]));
			l18=new JLabel(String.valueOf(usingbill.getDvd()[i].getBarcode()));
			l19=new JLabel(String.valueOf(usingbill.getDvd()[i].getCost()));
			row++;
			total=total+(usingbill.getDvd()[i].getCost()*usingbill.getQuantity()[i]);
			p1.add(l15);
			p1.add(l16);
			p1.add(l17);
			p1.add(l18);
			p1.add(l19);
		}
		
		
		p1.setLayout(new GridLayout(row, 5));
		p1.setSize(700,(row*10)+50);
		l20=new JLabel("Total=");
		l21=new JLabel(String.valueOf(total));
		l22=new JLabel("Discount % =");
		l23=new JLabel(String.valueOf(usingbill.getDiscount()));
		l24=new JLabel("SubTotal=");
		l25=new JLabel(String.valueOf(usingbill.getSubtotal()));
		l26=new JLabel("Thanks For Shopping With Us");
		l26.setFont(new Font("Serif",Font.BOLD,20));
		
		print=new JButton("Print it");
		exit=new JButton("Exit");
		
		
		p1.setOpaque(true);
		add(p1).setBounds(50, 120, 700, (row*10)+50);
		add(l20).setBounds(500, 400, 100, 30);
		add(l21).setBounds(600, 400, 100, 30);
		add(l22).setBounds(500, 430, 100, 30);
		add(l23).setBounds(600, 430, 100, 30);
		add(l24).setBounds(500, 460, 100, 30);
		add(l25).setBounds(600, 460, 100, 30);
		add(l26).setBounds(30, 460, 400, 30);
		add(print).setBounds(480, 495, 100, 30);
		add(exit).setBounds(610, 495, 100, 30);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrinterJob job = PrinterJob.getPrinterJob();
			     
		        PageFormat format = job.defaultPage();
		        format.setOrientation(PageFormat.LANDSCAPE);
		        dispose();
		        ViewBillByID vv=new ViewBillByID(usingbill.billno);
		        vv.print.setVisible(false);
		        vv.exit.setVisible(false);
		        job.setPrintable(vv, format);
		         
		        try{
		        	
		            if(job.printDialog()) job.print();
		        }
		        catch(Exception e1){e1.printStackTrace();}
			}
		});
		
		setVisible(true);
		}	
	}
	 public int print(Graphics g, PageFormat format, int pagenum) {
         
	       if (pagenum > 0){
	           return Printable.NO_SUCH_PAGE;
	       }
	        
	       g.translate((int)format.getImageableX(), (int)format.getImageableY());
	               
	       float pageWidth = (float)format.getImageableWidth();
	       float pageHeight = (float)format.getImageableHeight();
	        
	       float imageHeight = (float)this.getHeight();
	       float imageWidth = (float)this.getWidth();
	        
	       float scaleFactor = Math.min((float)pageWidth/(float)imageWidth, (float)pageHeight/(float)imageHeight);
	  
	       int scaledWidth = (int)(((float)imageWidth)*scaleFactor);
	        
	       int scaledHeight = (int)(((float)imageHeight)*scaleFactor);  
	        
	       BufferedImage canvas = new BufferedImage( this.getWidth(),  this.getHeight(), BufferedImage.TYPE_INT_RGB);
	       Graphics2D gg = canvas.createGraphics();
	       this.paint( gg );  
	       Image img = canvas ;
	  
	       g.drawImage(img, 0, 0, scaledWidth, scaledHeight, null );
	  
	       return Printable.PAGE_EXISTS;
	        
	    }
}
