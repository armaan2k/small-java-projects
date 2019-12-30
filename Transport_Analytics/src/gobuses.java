/*
 * Author: Armaan Merchant
 * Program description: a go bus object
 */

public class gobuses extends vehicles{
	private String unitNum;
	private String ID;
	private int capacity;

	public gobuses(String unitNum, String ID, int capacity) {
		super(unitNum, ID);
		this.unitNum =  unitNum;
		this.ID = ID;
		this.capacity = capacity;
	}
	
	public String getUnitNum() { //getter method
		return unitNum;
	}

	public String getID() { //getter method
		return ID;
	}
	@Override
	public int getCapacity() { //getter method
		return capacity;
	}

	@Override
	public String toString() { //formats and returns object in string form
		String ret = String.format("%s,%s,%d", unitNum,ID,capacity);
		return ret;
	}

}
