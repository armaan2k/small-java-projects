/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public class WingNut extends InnerThreaded implements Serializable{
	
	// Setting the serialVersionID
	private static final long serialVersionUID = -288466255794945090L;

	//constructor for wing nut
	public WingNut(String t, String m, String f, double u, int n) throws IllegalFastener {
		
		//passes variables to inner threaded
		super(t,m,f,u,n);
		
	}

	//string representation of wing nut
	public String toString() {
		return "Wing Nut " + super.toString();
	}
}
