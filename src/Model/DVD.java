package Model;

import java.io.Serializable;

public class DVD implements Serializable{

	private int Cost;
	private long  Barcode;
	private String MediaType;
	private String Name;
	private int  Stock;
	private String SubType;
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public long getBarcode() {
		return Barcode;
	}
	public void setBarcode(long barcode) {
		Barcode = barcode;
	}
	public String getMediaType() {
		return MediaType;
	}
	public void setMediaType(String mediaType) {
		MediaType = mediaType;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getSubType() {
		return SubType;
	}
	public void setSubType(String subType) {
		SubType = subType;
	}
	public DVD() {
		super();
	}
	public DVD(int cost, long barcode, String mediaType, String name, int stock, String subType) {
		super();
		Cost = cost;
		Barcode = barcode;
		MediaType = mediaType;
		Name = name;
		Stock = stock;
		SubType = subType;
	}
	
}
	