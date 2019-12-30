/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public abstract class Screw extends Fastener implements Serializable{

	// Setting the serialVersionID and defining variables for the screw
	private static final long serialVersionUID = 3056418792099539941L;
	private double length;
	private String thread;
	private String head;
	private String drive;
	
	//constructor for screw
	public Screw(double l, String t, String m, String f, String h, String d, String p, double u, int n) throws IllegalFastener {
		
		//passes variables up to fastener
		super(m,f,u,n);
		
		//throws an exception if an illegal length is used
		if((l >= 0.5 & l <= 6) & (l % 0.25 == 0))
			this.length = l;
		else if((l >= 6 & l <= 11) & (l % 0.5 == 0))
			this.length = l;
		else if((l >= 11 & l <= 20) & (l % 1 == 0))
			this.length = l;
		else
			throw new IllegalFastener("Incorrect length entered screw");
		
		//throws an exception is an illegal thread value is used
		if(t.equals("#8-13") || t.equals("#8-15") || t.equals("#8-32") ||
			t.equals("#10-13") || t.equals("#10-24") || t.equals("#10-32") ||
			t.equals("#1/4-20") || t.equals("#5/16-18") || t.equals("#3/8-16") ||
			t.equals("#7/16-14") || t.equals("#1/2-13") || t.equals("#5/8-11") || t.equals("#3/4-10")) {
				this.thread = t;
			}
		else
			throw new IllegalFastener("Incorrect thread value entered");
		
		//throws exception if an illegal head value is used
		if( h.equals("Bugle") || h.equals("Flat") || h.equals("Oval") || h.equals("Pan") || h.equals("Round")) {
			this.head = h;
		}
		else {
			throw new IllegalFastener("Invalid head value entered");
		}
		
		
		//throws an exception if an illegal drive value is used
		if( d.equals("6-Lobe") || d.equals("Philips") || d.equals("Slotted") || d.equals("Square")) {
			this.drive = d;
		} else {
			throw new IllegalFastener("Invalid drive value entered");
		}
		
		
		//throws exception if bolt tried using a finish only available to steel screws
		if ( (f.equals("Black Phosphate") || f.equals("ACQ 1000 Hour") || f.equals("Lubricated")) && !(m.equals("Steel") ) )
			throw new IllegalFastener("This finish is only available to steel screws");
		
		
		//throws an exception if bolt tries using a finish that is only available to nail
		if (f.equals("Bright"))
			throw new IllegalFastener("This Finish is only available to nails");
			
		}
	
	//string representation of screw
	public String toString() {
		return head + " head, " + drive + " drive, " + length + "\" long, " + thread + "thread, " + super.toString();
	}
	
	
	
	
}