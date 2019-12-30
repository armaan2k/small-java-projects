/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public abstract class Fastener implements Serializable{

	// Setting the serialVersionID and defining variables for the fastener
	private static final long serialVersionUID = 9153299792417486436L;
	private int numberPerUnit;
	private double unitPrice;
	private String material;
	private String finish;
	
	//the fastener constructor
	public Fastener(String m, String f, double u, int n ) throws IllegalFastener{
		
		//throws error if material is not one of the specified materials
		if (!(m.equalsIgnoreCase("Brass") || m.equalsIgnoreCase("Steel") || m.equalsIgnoreCase("Stainless Steel")))
        	throw new IllegalFastener("Invalid value entered1");	
		
		//throws error if the material is steel and it doesn't use one of the required finishes
		if (m.equalsIgnoreCase("Steel") && !(f.equalsIgnoreCase("Chrome") || f.equalsIgnoreCase("Hot Dipped Galvanized") || 
			f.equalsIgnoreCase("Plain") || f.equalsIgnoreCase("Yellow Zinc") || f.equalsIgnoreCase("Zinc") || 
			f.equalsIgnoreCase("Black Phosphate") || f.equalsIgnoreCase("ACQ 1000 Hour") || f.equalsIgnoreCase("Lubricated") || 
			f.equalsIgnoreCase("Bright")))
	        throw new IllegalFastener("Invalid value entered2");
		
		//throws if finish for brass or stainless steel is not Plain
		if ((m.equalsIgnoreCase("Brass") || m.equalsIgnoreCase("Stainless Steel")) && !(f.equalsIgnoreCase("Plain")))
	        throw new IllegalFastener("Invalid value entered3");
		
		//throws exception if an illegal finish is used
		if (!(f.equalsIgnoreCase("Chrome") || f.equalsIgnoreCase("Hot Dipped Galvanized") || f.equalsIgnoreCase("Plain") || 
			f.equalsIgnoreCase("Yellow Zinc") || f.equalsIgnoreCase("Zinc") || f.equalsIgnoreCase("Black Phosphate") || 
			f.equalsIgnoreCase("ACQ 1000 Hour") || f.equalsIgnoreCase("Lubricated") || f.equalsIgnoreCase("Bright")))
	        throw new IllegalFastener("Invalid value entered4");
			
		//throws exception if unit price is less than 0
		if (!(u > 0))
        	throw new IllegalFastener("Invalid value entered5");
		
		//throws exception if and illegal number per unit is entered
		if ( (n < 1 | n > 10000) | (n != 1 & n % 5 != 0))
        	throw new IllegalFastener("Invalid value entered6");	
		
		//after checking for exceptions sets the variables for fastener from the ones given by the child classes
		this.material = m;
		this.finish = f;
		this.unitPrice = u;
		this.numberPerUnit = n;
		
	}
	
	
	//toString method to return an object Fastener in string format
	public String toString() {
		return material + ", with a " + finish + ". " + numberPerUnit + " in a unit, " + "$" + unitPrice + " per unit.";
	}
	
	
	//gets the total cost of an order by multiplying price by units
	public double getOrderCost(int units) {
		return unitPrice*(double)units;
	}
	
}
