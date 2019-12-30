/*
 * Author: Armaan Merchant
 * Program description: a bus object
 */

public class buses extends vehicles{
	private String unitNum;
	private String ID;
	private int capacity;

	public buses(String unitNum, String ID, int capacity) {
		super(unitNum, ID);
		this.unitNum = unitNum;
		this.ID = ID;
		this.capacity = capacity;
	}
	
	public String getUnitNum() {//getter
		return unitNum;
	}

	public String getID() {//getter
		return ID;
	}

	@Override
	public int getCapacity() {//getter
		return capacity;
	}

	@Override
	public String toString() {//formats and returns object in string form
		String ret = String.format("%s,%s,%d", unitNum,ID,capacity);
		return ret;
	}

}
