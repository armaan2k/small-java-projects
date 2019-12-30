/*
 * Author: Armaan Merchant
 * Program description: a subway object
 */

public class subways extends vehicles{
	private String unitNum;
	private String ID;
	private int numCars;
	private int passPerCar;
	private String opStatus;
	private int opDate;
	
	
	public subways(String unitNum, String ID, int numCars, int passPerCar, String opStatus, int opDate) {
		super(unitNum, ID);
		this.unitNum = unitNum;
		this.ID = ID;
		this.numCars = numCars;
		this.passPerCar = passPerCar;
		this.opStatus = opStatus;
		this.opDate = opDate;
		
	}

	@Override
	public int getCapacity() {//getter
		return passPerCar * numCars;
	}
	
	public String getUnitNum() {//getter
		return unitNum;
	}
	public String getID() {//getter
		return ID;
	}
	public int getNumCars() {//getter
		return numCars;
	}
	public int getPassPerCar() {//getter
		return passPerCar;
	}
	public String getOpStatus() {//getter
		return opStatus;
	}
	public int getOpDate() {//getter
		return opDate;
	}
	
	@Override
	public String toString() {//formats and returns object in string form
		String ret = String.format("%s,%s,%d,%d,%s%d",unitNum, ID, numCars, passPerCar, opStatus, opDate);
		return ret;
	}
	

}
