/*
 * Author: Armaan Merchant
 * Program description: a street car object
 */

public class streetcars extends vehicles{
	private String unitNum;
	private String ID;
	private String type;

	public streetcars(String unitNum, String ID, String type) {
		super(unitNum, ID);
		this.unitNum = unitNum;
		this.ID = ID;
		this.type = type;
	}

	@Override
	public int getCapacity() {
		int ret;
		if( type.equals("S") ) {
			ret = 40;
		} else {
			ret = 80;
		}
		return ret;
	}

	@Override
	public String toString() {//formats and returns object in string form
		String ret = String.format("%s,%s,%s", unitNum,ID,type);
		return ret;
	}

	
}
