/*
 * Author: Armaan Merchant
 * Program description: a person object
 */

public class person {
	private String pID;
	private String transport;
	private String age;
	private String hour;
	private String date;
	
	public person(String pID, String transport, String age, String hour, String date) {
		this.pID = pID;
		this.transport = transport;
		this.age = age;
		this.hour = hour;
		this.date = date;
	}
	
	public String getPID() {//getter
		return pID;
	}
	public String getTransport() {//getter
		return transport;
	}
	public String getAge() {//getter
		return age;
	}
	public String getHour() {//getter
		return hour;
	}
	public String getDate() {//getter
		return date;
	}
	
	
	@Override
	public String toString() {//formats and returns object in string form
		String ret = String.format("Person ID: %s, Transport: %s, Age Group: %s, Hour: %s, Date: %s", pID, transport, age, hour, date);
		return ret;
	}
	
	

}
