package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InMemoryDatabaseBuilder {
	private Map<Integer, FileStruct> indexToFileMap;
	private Trie trie; 
	public InMemoryDatabaseBuilder( Map<Integer, FileStruct> _indexToFileMap) {
		// TODO Auto-generated constructor stub
		this.indexToFileMap = _indexToFileMap;
		trie = new Trie();
	}

	public void buildDatabase() throws IOException {
		for(Map.Entry<Integer, FileStruct> eachFileEntry: indexToFileMap.entrySet()) {
			processFile(eachFileEntry.getValue());
		}	
	}
	
	private void processFile ( FileStruct fileObj) throws IOException {
		String fileName = fileObj.getFileName();
		try {
			FileReader fileReader = new FileReader("files/" + fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			int lineNumber = 0;
			while( (line = bufferedReader.readLine()) != null) {
				processLine ( line, fileObj, lineNumber);
				lineNumber++;
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processLine(String line, FileStruct fileObj, int lineNumber ) {
		String[] words = line.split(" ");
		String encodedFileLineString = fileObj.getFileIndex()+"#"+fileObj.getFileName()+"#"+lineNumber;
		
//		System.out.println("encoded file line string is: "+ encodedFileLineString);
		
		fileObj.getEncodeFileMap().setEncodeFileMapEntry(encodedFileLineString, line);
		for( String word : words ) {
			word = word.replaceAll("[@!#$.]", "");
			trie.insert(word, encodedFileLineString);	
		}
	}
	
	public String searchFor( String word) {
		List<String> encodedStrings = trie.getCorrespondingLines(word);
		if( encodedStrings == null)
			return "unmatch";
		System.out.println("Printing the matched lines");
		for(int i = 0; i < encodedStrings.size(); i++) {
			String encodedString = encodedStrings.get(i);
			int fileNumber = Integer.parseInt(encodedString.substring(0, encodedString.indexOf("#")));
			FileStruct fileObj = indexToFileMap.get(fileNumber);
			String line = fileObj.getEncodeFileMap().getEncodeToLineMap().get(encodedString);
			line = line.replaceAll(" "+ word," "+ word.toUpperCase());
			System.out.println(line);
		}
		return "matched";
	}
}
