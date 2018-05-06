package Model;

import java.io.Serializable;

public class Person implements Serializable {

	private String Name;
	private String Ages;
	
	public Person(String name, String ages) {
		
		Name = name;
		Ages = ages;
	}
	
	public Person(){
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAges() {
		return Ages;
	}

	public void setAges(String ages) {
		Ages = ages;
	}
}
