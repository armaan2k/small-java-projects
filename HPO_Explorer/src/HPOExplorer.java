/*
 * Name: armaan merchant   student number: 20047267   student id: 16am122
 * description: the main controller while opens and the HPO database and returns informations on queries provided
 */



import java.util.*;
import java.io.*;


public class HPOExplorer {
	
	private static Formatter writeFile; //variable used to write to the results.txt file
	
	public static void main(String[] args) throws FileNotFoundException{
		String[] results = new String[5];
		
		//creates the results.txt file
		try {
			writeFile = new Formatter("results.txt");
			System.out.println("results.txt successfully created");
		}
		catch (Exception e) {
			System.out.println("Error: could not make file");
		}
		
		//search through all 5 queries
		for(int i=0;i<5;i++) 
			results[i] = openQueries()[i].getNumber();
		
		for(int i=0;i<5;i++) {
		System.out.println("(Query ID: "+results[i]+")\n"); //does all queries
		writeFile.format("%s", "(Query ID: "+results[i]+")\n");
		termFormat(results[i]);
		}
		
		writeFile.close();

	}
	
	public static void termFormat(String query) {
		
		Scanner fromFileStream = null;
		try {
			fromFileStream = new Scanner(new FileInputStream("HPO.txt")); //using specified path
		}
		catch (FileNotFoundException e) {	
			System.out.println("Error: cannot open 'HPO.txt' ");
			System.exit(0);
		}
		
		//for the root node
				if(query.equals("0000001")) {
					System.out.println("id: HP:0000001");
					System.out.println("name: All");
					System.out.println("comment: Root of all terms in the Human Phenotype Ontology.");
					System.out.println("xref: UMLS:C0444868");
					System.out.println("");
					return;
				}
		
		String inputToken = null;
		inputToken = fromFileStream.nextLine();
		while(!inputToken.contains("id: HP:"+query)) {
			inputToken = fromFileStream.nextLine();
		}
		
		
		String line = "";
		String next = null; 
		Term nextTerm = null;
		int count = 0; //counts to see if is_a is found in the term
		
		//keep looping while nextLine is blank
		while(!inputToken.equals("")) {
			//if obsolete us true then new term
			writeFile.format("%s%n", inputToken); //writes line to results.txt
			if(inputToken.contains("is_obsolete: true")) {
				inputToken = fromFileStream.nextLine(); 
				int index = inputToken.indexOf("HP:")+3; 
				Term newTerm = new Term(inputToken.substring(index,index+7)); 
				termFormat(newTerm.getTermInfo()); 
			}
			line += inputToken +"\n";
			if(inputToken.contains("is_a:") && count == 0) {
				next = inputToken.substring(9,16); 
				nextTerm = new Term(next);
				count = 1; 
			}
			inputToken = fromFileStream.nextLine();
		}
		writeFile.format("%n"); //writes line to results.txt
		System.out.println(line);
		termFormat(next);
	}
	
	public static Query[] queries = new Query[6]; // making a array to store queries 
	public static Query[] openQueries() {
		Scanner fromFileStream = null;
		try {
			fromFileStream = new Scanner(new FileInputStream("queries.txt")); // using specified path
		}
		catch (FileNotFoundException e) {	
			System.out.println("Error: could not open 'queries.txt'");
			System.exit(0);
		}
		
		Query[] queries = new Query[5];
		for(int i = 0; i < 5; i++) {
			String inputLine = null;
			inputLine = fromFileStream.nextLine();
			int index = inputLine.indexOf("HP:")+3;
			Query query = new Query(inputLine.substring(index,index+7));
			queries[i] = query;
		}
		return queries;
	}
	
	public static void createResults() {
		
	}
	

}
