package com.parse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;									
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 * Java program to read CSV file using BufferedReader and String split()
 * method
 */		
public class CSVParser implements IParser 
{

	public List<Employee> readLinesFromFile(String fileName, int lineNum) 
	{
		List<Employee> employeesList = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		// create an instance of BufferedReader				
		// using try with resource, Java 7 feature to close resources
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) 
		{

			if (lineNum != 0)
			{
				String line = Files.readAllLines(pathToFile).get(lineNum);
				splitandCreateEmployee(employeesList, line);
			}
			else
			{
				// read the first line from the text file
				String line = br.readLine();
								
				// loop until all lines are read
				while (line != null) 
				{
					splitandCreateEmployee(employeesList, line);

					// read next line before looping
					// if end of file reached, line would be null
					line = br.readLine();
				}
			}

		} 
		catch(FileNotFoundException fne)
		{
			//We need to write custom message or log message here
			System.out.println("File was not found");
													
		}
		catch (IOException ioe) 
		{
			System.out.println("Exception occured while processing the file");
		}

		return employeesList;
	}

	private void splitandCreateEmployee(List<Employee> employeesList, String line) {
		// use string.split to load a string array with the values from
		// each line of
		// the file, using a comma as the delimiter
		String[] attributes = line.split(",");

		Employee employee = createEmployee(attributes);

		// adding Employee into ArrayList
		employeesList.add(employee);
	}
	
	private Employee createEmployee(String[] metadata) {
        String name = metadata[0];
        int empId = Integer.parseInt(metadata[1]);
        String designation = metadata[2];

        // create and return Employee of this metadata
        return new Employee(name, empId, designation);
    }

}