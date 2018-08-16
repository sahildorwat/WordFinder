package main;

import java.util.HashMap;
import java.util.Map;

public class EncodeFile {
	private Map<String, String> encodeToLineMap;
	
	EncodeFile () {
		encodeToLineMap = new HashMap<>();
	}
	
	public Map<String, String> getEncodeToLineMap() {
		return encodeToLineMap;
	}
	
	public void setEncodeToLineMap(Map<String, String> encodeToLineMap) {
		this.encodeToLineMap = encodeToLineMap;
	}
	
	public void setEncodeFileMapEntry(String encodedString, String line) {
		encodeToLineMap.put(encodedString, line);
	}
}
