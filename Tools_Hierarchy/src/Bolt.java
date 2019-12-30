/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public abstract class Bolt extends Fastener implements Serializable{
	
	// Setting the serialVersionID and defining variables for the bolt
	private static final long serialVersionUID = -1289431781004071643L;
	private double length;
	private String thread;
	
	//constructor for bolt
	public Bolt(double l, String t, String m, String f, double u, int n) throws IllegalFastener {
		
		//passes variables up to fastener
		super(m,f,u,n);
		
		//throws exception if length is not valid
		if((l >= 0.5 & l <= 6) & (l % 0.25 == 0))
			this.length = l;
		else if((l >= 6 & l <= 11) & (l % 0.5 == 0))
			this.length = l;
		else if((l >= 11 & l <= 20) & (l % 1 == 0))
			this.length = l;
		else
			throw new IllegalFastener("Incorrect length entered screw");
		
		//throws exception if bolt tried using a finish only available to steel screws
		if (f.equals("Black Phosphate") || f.equals("ACQ 1000 Hour") || f.equals("Lubricated"))
			throw new IllegalFastener("This finish is only available to steel screws");
		
		//throws an exception if bolt tries using a finish that is only available to nail
		if (f.equals("Bright"))
			throw new IllegalFastener("This Finish is only available to nails");
		
		//throws an exception if an illegal thread value is entered
		if(t.equals("8-13") || t.equals("8-15") || t.equals("8-32") ||
				t.equals("10-13") || t.equals("10-24") || t.equals("10-32") ||
				t.equals("1/4-20") || t.equals("5/16-18") || t.equals("3/8-16") ||
				t.equals("7/16-14") || t.equals("1/2-13") || t.equals("5/8-11") || t.equals("3/4-10")) {
					this.thread = t;
		} else {
				throw new IllegalFastener("Incorrect thread value entered");
		}
		}
	
	//string representation of bolt
	public String toString() {
		return length + "\" long, " + thread + "thread, " + super.toString();
	}
		
}

