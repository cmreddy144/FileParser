package com.parse;

import java.util.List;

public interface IParser {
	
	public List<Employee> readLinesFromFile(String fileName, int lineNum);								

}		
		