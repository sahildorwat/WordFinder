package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
//import java.util.Map;

public class FileMapper {

	private static String[] getFileDetails() throws IOException {
		
		
		System.out.println("Please enter the file names: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fileNameString = br.readLine();
		String[] fileNames = fileNameString.split(" ");
		return fileNames;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to String Searcher Application :");
		
//		GETTING INPUT FROM USER
		String[] fileNames = getFileDetails();
		System.out.println("Building database for further queries :");
		FileToIndexMapper fileIndexMap = new FileToIndexMapper();
		fileIndexMap.buildIndexingForFile(fileNames);
		
//		BUILDING DATABASE FOR QUERY SEARCH
		
		Map<Integer, FileStruct> indexToFileMap =  fileIndexMap.getIndexToFileMap();
		InMemoryDatabaseBuilder imdb = new InMemoryDatabaseBuilder(indexToFileMap);
		imdb.buildDatabase();
		System.out.println("Database is ready");
		Scanner inputWord = new Scanner(System.in);
		System.out.println("Please enter word for searching :");
		
//		BUILDING COMMAND LINE INTERFACE
		
		int totalQueries = 0, successQueries = 0;
		
		
		while(inputWord.hasNext()) {
			String word = inputWord.next();
			if( word.equals("-1")) {
				System.out.println("Exiting the command line interface.");
				break;
			}
			totalQueries++;
			String result = imdb.searchFor(word);
			if( result.equals("matched"))
				successQueries++;
			else System.out.println("The word you are looking for is not present.");
			System.out.println("Please enter word for searching : or press -1 to exit.");
		}
		
//		DISPLAY SUMMARY
		
		printHistory(totalQueries, successQueries);
		
	}

	private static void printHistory ( int totalQueries, int successQueries ) {
		System.out.println("printing the history of words :");
		System.out.println("Total number of queries are : " + totalQueries);
		System.out.println("Total successfull number of queries are : " + successQueries);
	}
}










//for( String s : fileNames ) {
//System.out.println(s);
//}


//for(Map.Entry<Integer, FileStruct> mapping: fileIndexMap.indexToFileMap.entrySet()) {
//System.out.println("file index id: "+ mapping.getKey());
//System.out.println("file details are: ");
//mapping.getValue().getFileDetails();
//}

