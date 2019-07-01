package com.parse;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CsvParserTest {

	CSVParser parserTest = new CSVParser();
	int lineNum = 0;
	//String testFileName = "D:\\workspace\\FileParser\\src\\test\\resources\\employee.csv";
	String testFileName = "src/test/resources/employee.csv";
	

	@Test
	public void testReadGivenLineNoFromFile()
	{
		lineNum =5;
		List<Employee> list = parserTest.readLinesFromFile(testFileName, lineNum);
		assertEquals(list.size(), 1);				
	}

	@Test
	public void testReadAllLinesFromFile()
	{

		List<Employee> list = parserTest.readLinesFromFile(testFileName, lineNum);
		assertEquals(list.size(), 6);
	}
}
