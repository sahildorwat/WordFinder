package main;

public class FileStruct {
	private String fileName;
	private int fileIndex;
	private EncodeFile encodeFileMap;
	
	FileStruct(String _fileName, int _fileIndex) {
		this.fileIndex = _fileIndex;
		this.fileName = _fileName;
		this.encodeFileMap = new EncodeFile();
	}
	
	public void getFileDetails() {
		System.out.println("file name is : "+ fileName);
		System.out.println("file index is : " + fileIndex);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileIndex() {
		return fileIndex;
	}

	public void setFileIndex(int fileIndex) {
		this.fileIndex = fileIndex;
	}

	public EncodeFile getEncodeFileMap() {
		return encodeFileMap;
	}

	public void setEncodeFileMap(EncodeFile encodeFileMap) {
		this.encodeFileMap = encodeFileMap;
	}
	
}
