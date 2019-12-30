/*
 * Author: Armaan Merchant 
 * Program description: Using hierarchies, it creates vehicle and person objects in order to calculate the demand for each mode of 
 * transport for each hour of the day
 * 
 * Note: Uses append method for writing files so you have to delete previous files if running multiple times
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MTOptimizer {
	
	public static void main(String args[]) {
		String[] lines = readFile("ridership.txt"); //the lines of ridership.txt
		String[] words; //to store the array of words in each line.
		ArrayList<person> people = new ArrayList<person>(66104);//to store people
		boolean allNums1; //to check if a string only contains numbers for ID
		boolean allNums2;//hours
		boolean allNums3;//dates
		
		

		
		for(int i = 0;i<lines.length;i++) {
			allNums1 = true;
			allNums2 = true;
			allNums3 = true;
			
			words = lines[i].split(","); //tokenization
			
			//check to see if there an incorrect amount of variables in person
			if(words.length != 5) {
				writeFile("errorlog.txt",String.join(",", words));
				writeFile("errorlog.txt","Invalid arguments");
				continue;
			}
			
			//checks to see if the strings only has numbers
			allNums1 = (words[0]).matches("[0-9]+"); //ID
			allNums2 = (words[3]).matches("[0-9]+"); //hour
			allNums3 = (words[4]).matches("[0-9]+"); //date
			//end check
			
			
			
			//checks for valid id
			if ( (words[0].length() != 7) || !allNums1 ) {
				if( words[0].equals("*")) {
				}else {
					writeFile("errorlog.txt",String.join(",", words));
					writeFile("errorlog.txt","Invalid ID");
					continue;
				} 
		
			//checks for valid modality
			} else if (  words[1].toCharArray()[0] != 'S' && words[1].toCharArray()[0] != 'G' && words[1].toCharArray()[0] != 'X' && 
					words[1].toCharArray()[0] != 'C' && words[1].toCharArray()[0] != 'D') {
				writeFile("errorlog.txt",String.join(",", words));
				writeFile("errorlog.txt","Invalid mode of transport");
				continue;
				
			//checks for valid age group
			} else if ( words[2].toCharArray()[0] != 'A' && words[2].toCharArray()[0] != 'C' && words[2].toCharArray()[0] != 'S' ) {
				writeFile("errorlog.txt",String.join(",", words));
				writeFile("errorlog.txt","Invalid Age Group");
				continue;
				
			//checks for valid hour
			} else if ( !allNums2 ) {
				writeFile("errorlog.txt",String.join(",", words));
				writeFile("errorlog.txt","Invalid Hour");
				continue;
				
			//checks for valid date
			} else if( !allNums3 ) {
				writeFile("errorlog.txt",String.join(",", words));
				writeFile("errorlog.txt","Invalid Date");
				continue;
			}
			
			person newPerson = new person(words[0],words[1],words[2],words[3],words[4]);
			people.add(newPerson);
		} //end of BIG for loop for adding to person's to ArrayList people
	
		
		//Array lists to store vehicle objects
		ArrayList<subways> subwaysArr = new ArrayList<subways>();
		ArrayList<gotrains> gotrainsArr = new ArrayList<gotrains>();
		ArrayList<streetcars> streetcarsArr = new ArrayList<streetcars>();
		ArrayList<buses> busesArr = new ArrayList<buses>();
		ArrayList<gobuses> gobusesArr = new ArrayList<gobuses>();
		
		//adding subways to array list
		lines = readFile("subways.txt");
		for(int i = 0;i<20;i++) {
			if(lines[i] != null) {
				words = lines[i].split(","); //tokenization
				subways newSubway = new subways(words[0], words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]), words[4], Integer.parseInt(words[5]) );
				subwaysArr.add(newSubway);
			}
		}//done adding subways
		
		//adding gotrains to array list
		lines = readFile("gotrains.txt");
		for(int i = 0;i<10;i++) {
			if(lines[i] != null) {
				words = lines[i].split(","); //tokenization
				gotrains newGotrain = new gotrains(words[0], words[1], Integer.parseInt(words[2]) );
				gotrainsArr.add(newGotrain);
			}
		}//done adding gotrains
		
		//adding streetcars to array list
		lines = readFile("streetcars.txt");
		for(int i = 0;i<30;i++) {
			if(lines[i] != null) {
				words = lines[i].split(","); //tokenization
				streetcars newStreetcar = new streetcars(words[0], words[1], words[2] );
				streetcarsArr.add(newStreetcar);
			}
		}//done adding streetcars
		
		//adding buses to of array list
		lines = readFile("buses.txt");
		for(int i = 0;i<50;i++) {
			if(lines[i] != null) {
				words = lines[i].split(","); //tokenization
				buses newBus = new buses(words[0], words[1], Integer.parseInt(words[2]) );
				busesArr.add(newBus);
			}
		}//done adding buses
		
		//adding gobuses to array list
		lines = readFile("gobuses.txt");
		for(int i = 0;i<15;i++) {
			if(lines[i] != null) {
				words = lines[i].split(","); //tokenization
				gobuses newGoBus = new gobuses(words[0], words[1], Integer.parseInt(words[2]) );
				gobusesArr.add(newGoBus);
			}
		}//done adding gobuses
		
		
		
		//for loop for counting passenger for each of the vehicles for each hour
		int[] subwayHours = new int[24];
		int[] gotrainHours = new int[24];
		int[] streetcarHours = new int[24];
		int[] busHours = new int[24];
		int[] gobusHours = new int[24];
		for(person passenger :people) {
			int hour = Integer.parseInt(passenger.getHour());
			String age = passenger.getAge();
			String transport = passenger.getTransport();
			double personValue;
			
			//check to see value of each person based on their age group
			if(age.equals("A")) {
				personValue = 1;
			} else if (age.equals("C")) {
				personValue = 0.75;
			} else {
				personValue = 1.25;
			}
			
			if(transport.equals("S") ) {
				subwayHours[hour-1] += personValue;
			} else if (transport.equals("G") ) {
				gotrainHours[hour-1] += personValue;
			} else if (transport.equals("X") ) {
				streetcarHours[hour-1] += personValue;
			} else if (transport.equals("C") ) {
				busHours[hour-1] += personValue;
			} else if (transport.equals("D") ) {
				gobusHours[hour-1] += personValue;
			}
		}//end of passenger count loop
		
		//for loop to calculate which trains are needed to meet train demand for 24 hours. Writes train part of InOperations.txt
		writeFile("InOperationFleets.txt", "[Trains]");
		for(int i = 0; i<24 ; i++) {
			int capInOp = 0; //current capacity in operation
			int requiredCap = subwayHours[i];
			int j = 0;
			writeFile("InOperationFleets.txt", "[Hour = " + i + " ]");
			while(capInOp < requiredCap) {
				capInOp += subwaysArr.get(j).getCapacity();
				writeFile("InOperationFleets.txt","train: " +  subwaysArr.get(j).toString());
				j++;
			}
		}//end of train loop
		writeFile("InOperationFleets.txt", "");//blank line
		
		//for loop to calculate which GoTrains are needed to meet gotrain demand for 24 hours. Writes GoTrain part of InOperations.txt
		writeFile("InOperationFleets.txt", "[GoTrains]");
		for(int i = 0; i<24 ; i++) {
			int capInOp = 0; //current capacity in operation
			int requiredCap = gotrainHours[i];
			int j = 0;
			writeFile("InOperationFleets.txt", "[Hour = " + i + " ]");
			while(capInOp < requiredCap) {
				capInOp += gotrainsArr.get(j).getCapacity();
				writeFile("InOperationFleets.txt","gotrain: " +  gotrainsArr.get(j).toString());
				j++;
			}
		}//end of gotrain loop
		writeFile("InOperationFleets.txt", ""); //blank line
		
		//for loop to calculate which StreetCars are needed to meet StreetCar demand for 24 hours. Writes StreetCar part of InOperations.txt
		writeFile("InOperationFleets.txt", "[StreetCars]");
		for(int i = 0; i<24 ; i++) {
			int capInOp = 0; //current capacity in operation
			int requiredCap = streetcarHours[i];
			int j = 0;
			writeFile("InOperationFleets.txt", "[Hour = " + i + " ]");
			while(capInOp < requiredCap) {
				capInOp += streetcarsArr.get(j).getCapacity();
				writeFile("InOperationFleets.txt","streetcar: " +  streetcarsArr.get(j).toString());
				j++;
			}
		}//end of streetcar loop
		writeFile("InOperationFleets.txt", ""); //blank line
		
		//for loop to calculate which Buses are needed to meet Bus demand for 24 hours. Writes Bus part of InOperations.txt
		writeFile("InOperationFleets.txt", "[Buses]");
		for(int i = 0; i<24 ; i++) {
			int capInOp = 0; //current capacity in operation
			int requiredCap = busHours[i];
			int j = 0;
			writeFile("InOperationFleets.txt", "[Hour = " + i + " ]");
			while(capInOp < requiredCap) {
				capInOp += busesArr.get(j).getCapacity();
				writeFile("InOperationFleets.txt","bus: " +  busesArr.get(j).toString());
				j++;
			}
		}//end of bus loop
		writeFile("InOperationFleets.txt", "");//blank line
		
		//for loop to calculate which GoBuses are needed to meet GoBus demand for 24 hours. Writes GoBus part of InOperations.txt
		writeFile("InOperationFleets.txt", "[GoBuses]");
		for(int i = 0; i<24 ; i++) {
			int capInOp = 0; //current capacity in operation
			int requiredCap = gobusHours[i];
			int j = 0;
			writeFile("InOperationFleets.txt", "[Hour = " + i + " ]");
			while(capInOp < requiredCap) {
				capInOp += gobusesArr.get(j).getCapacity();
				writeFile("InOperationFleets.txt","gobus: " +  gobusesArr.get(j).toString());
				j++;
			}
		}//end of bus loop
		
		
		
	}//end of main
	
	
	
	
	
	
	
	
	
	
	
	//reads a given file
	public static String[] readFile(String fileName) {
		String[] lines = new String[66104];
		
		Scanner fromFileStream = null;
		try {
			fromFileStream = new Scanner(new FileInputStream(fileName));
			}
		catch (FileNotFoundException e) {	
			System.out.println("Error opening the file");
			System.exit(0);
			}
		
		String inputLine;
		int i= 0;
			
		while (fromFileStream.hasNextLine()) {
			inputLine = fromFileStream.nextLine();
			lines[i] = inputLine;
			i++;
			}

		fromFileStream.close();
		return lines;
	}
	
	private static void writeFile(String fileName, String text) { //creates a file if it doesn't exist and appends if it does
		File file = new File(fileName);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {	
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(text);
			} catch (IOException e) {
				e.printStackTrace();
				} finally {
					try {
						pr.close();
						br.close();
						fr.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
					}
		}


}
