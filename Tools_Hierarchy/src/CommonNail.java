/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public class CommonNail extends Nail implements Serializable{

	// Setting the serialVersionID and defining variables for the nail
	private static final long serialVersionUID = -7996452392050778463L;
	private double length;
	private String size;
	private double gauge;
	

	//constructor for common nail
	public CommonNail(String s, double l, double g, String f, double u, int n) throws IllegalFastener {
		
		//passes variables up to nail
		super(s,l,g,f,u,n);
		
		//throws exception if an illegal finish is entered
		if( !(f.equals("Bright") || f.equals("Hot Dipped Galvanized") ) )
			throw new IllegalFastener("Invalid Finish for a common nail");
		
		//throws exception if an illegal size for nail is entered
		if ( s.equals("6D") || s.equals("8D") ||s.equals("10D") ||s.equals("12D") ||s.equals("16D") ||s.equals("60D"))
			this.size = s;
		else
			throw new IllegalFastener("Invalid size entered");
		
		
		//throws an exception if an illegal length is used
		if ( l == 2 || l == 2.5 || l == 3 || l == 3.25 || l == 3.5 || l == 6)
			this.length = l;
		else
			throw new IllegalFastener("Invalid length entered");
		
		//throws an exception if an illegal gauge value is used
		if ( g == 2 || g == 8 || g == 9 || g == 10.25 || g == 11.5)
			this.gauge = g;
		else
			throw new IllegalFastener("Invalid gauge entered");
			
	}
	
	
	//string representation of commmon nail
	public String toString() {
		return "Common Nail, " + size + " size, " + length + "\" long, " + gauge + " gauge, " + super.toString();
	}
	
	
}
