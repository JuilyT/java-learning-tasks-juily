package org.multithreading.part2;

public enum FileFormatType {
	TAB_SEPARATED("Multithreading_Task_2_fortune1000companies.txt","\t"), 
	COMMA_SEPARATED("Multithreading_Task_2_java Keywords.txt",","), 
	LINE_SEPARATED("Multithreading_Task2_ProgrammingLanguages.txt","\n");
	
	private String fileName;
	private String delimiter;
	
	private FileFormatType(String fileName, String delimiter) {
		this.fileName = fileName;
		this.setDelimiter(delimiter);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	} 
}
