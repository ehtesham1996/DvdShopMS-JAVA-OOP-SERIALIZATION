package Model;

import java.io.Serializable;

public class Billings implements Serializable{
	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}
	public  String billno;
	private Customer customer;
	private DVD[] dvd;
	private int[] quantity;
	private long subtotal;
	private long discount;
	public Billings(Customer customer, DVD[] dvd, int[] quantity, long subtotal, long discount,String string) {
		super();
		billno=string;
		this.customer = customer;
		this.dvd = dvd;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.discount = discount;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DVD[] getDvd() {
		return dvd;
	}
	public void setDvd(DVD[] dvd) {
		this.dvd = dvd;
	}
	public int[] getQuantity() {
		return quantity;
	}
	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}
	public long getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(long subtotal) {
		this.subtotal = subtotal;
	}
	public long getDiscount() {
		return discount;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
	}
}
	