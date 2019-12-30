/*
 * Name: Armaan Merchant    student ID: 16am122      student number:20047267
 */

import java.io.Serializable;

public class IllegalFastener extends Exception  implements Serializable{
	
	// Setting the serialVersionID
	private static final long serialVersionUID = -5562365087370073412L;

	public IllegalFastener (String message) {
		super(message);
	}
	
}
