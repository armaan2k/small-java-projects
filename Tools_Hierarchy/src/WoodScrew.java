/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public class WoodScrew extends Screw implements Serializable{

	// Setting the serialVersionID and defining the variable point for the wood screw
	private static final long serialVersionUID = 5822653680337943157L;
	private String point;
	

	//constructor for wood screw
	public WoodScrew(double l, String t, String m, String f, String h, String d, String p, double u, int n) throws IllegalFastener {
		
		//passes variables up to screw
		super(l,t,m,f,h,d,p,u,n);
		
		//throws an exception is an invalid point is used
		if ( p.equals("Double Cut") || p.equals("Sharp") || p.equals("Type 17") )
			this.point = p;
		else
			throw new IllegalFastener("Invalid entery for point");
		
	}
	
	//string representation of wood screw.
	public String toString() {
		return "Wood Screw, " + point + " point, " + super.toString();
	}

}
