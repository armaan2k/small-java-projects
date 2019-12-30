/*
 * Author: Armaan Merchant
 * Program description: a gotrain object
 */

public class gotrains extends vehicles{
	private int capacity;
	private String unitNum;
	private String ID;
	
	public gotrains(String unitNum, String ID, int capacity) {
		super(unitNum,ID);
		this.unitNum = unitNum;
		this.ID = ID;
		this.capacity = capacity;
	}

	@Override
	public int getCapacity() {//getter
		return capacity;
	}
	
	public String getUnitNum() {//getter
		return unitNum;
	}
	
	public String getID() {//getter
		return ID;
	}

	@Override
	public String toString() {//formats and returns object in string form
		String ret = String.format("%s,%s,%d", unitNum,ID,capacity);
		return ret;
	}
	
	

}
