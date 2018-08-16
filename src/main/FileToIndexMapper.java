package main;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileToIndexMapper {
	private Map<Integer, FileStruct > indexToFileMap;
	private int fileIndexCounter;
	
	FileToIndexMapper () {
		fileIndexCounter = 0;
		indexToFileMap = new HashMap< Integer, FileStruct>();
	}

	public void buildIndexingForFile (String[] fileNames) {
		for( String fileName : fileNames) {
			boolean isValid = validateFile(fileName);
			if(isValid) {
				indexToFileMap.put(fileIndexCounter, new FileStruct(fileName, fileIndexCounter));
				fileIndexCounter++;
			}
		}
	}
	
	private boolean validateFile( String fileName ) {
		File fileDir = new File("files/" + fileName);
		boolean exists = fileDir.exists();
		return exists;
	}

	public Map<Integer, FileStruct> getIndexToFileMap() {
		return indexToFileMap;
	}

	public void setIndexToFileMap(Map<Integer, FileStruct> indexToFileMap) {
		this.indexToFileMap = indexToFileMap;
	}
	
	
}
