/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public class CarriageBolt extends Bolt implements Serializable{
	
	
	// Setting the serialVersionID
	private static final long serialVersionUID = -6018613361762201344L;

	//constructor for carriage bolt
	public CarriageBolt(double l, String t, String m, String f, double u, int n) throws IllegalFastener {
		
		//passes variables up to bolt
		super(l,t,m,f,u,n);
	}
	
	//string representation of carriage bolt
	public String toString() {
		return "Carriage Bolt " + super.toString();
	}

}
