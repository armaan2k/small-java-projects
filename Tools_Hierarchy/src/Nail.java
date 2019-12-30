/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public class Nail extends Fastener implements Serializable{
	
	// Setting the serialVersionID
	private static final long serialVersionUID = -2870562617165732206L;

	//constructor for nail
	public Nail(String s, double l, double g, String f, double u, int n ) throws IllegalFastener {
		
		//passes variables up to fastener
		super("Steel",f,u,n);
		}
	
	//string representation of nail
	public String toString() {
		return super.toString();
	}
	
	}
	
