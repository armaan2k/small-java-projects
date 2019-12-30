/*
 * Author: Armaan Merchant
 * Program description: an abstract vehicle object
 */

public abstract class vehicles {
	private String unitNum;
	private String ID;
	
	public vehicles(String unitNum, String ID) {
		this.unitNum = unitNum;
		this.ID = ID;
	}
	
	public String getID() {//getter
		return ID;
	}
	
	public String getUnitNum() {//getter
		return unitNum;
	}
	
	public abstract int getCapacity();
	
	public abstract String toString();
	

}
