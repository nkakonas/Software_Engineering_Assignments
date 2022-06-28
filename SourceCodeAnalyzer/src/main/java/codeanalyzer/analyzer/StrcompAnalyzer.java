package codeanalyzer.analyzer;

import java.io.IOException;
import java.util.List;

import codeanalyzer.reader.SourceFileReader;

/**
 * Analyzes the contents of a Java source code file using string comparison
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes.
 * @author nkakonas
 *
 */
public class StrcompAnalyzer implements SourceCodeAnalyzer {
    
    
	private SourceFileReader fileReader;
	
	public StrcompAnalyzer(SourceFileReader fileReader) {
		this.fileReader = fileReader;
	}
	
	/**
	 * Calculates the LOC metric.
	 * @param filepath the path of the file
	 * @throws IOException
	 */	
	@Override
	public int calculateLOC(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int nonCodeLinesCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
				nonCodeLinesCounter++;
		}
		int loc = sourceCodeList.size() - nonCodeLinesCounter;
		return loc; 
	}
	
	/**
	 * Calculates the NOM metric.
	 * @param filepath the path of the file
	 * @throws IOException
	 */	
	@Override
	public int calculateNOM(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int methodCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //clear all leading and trailing white spaces
			if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
					|| line.contains("void") || line.contains("int") || line.contains("String"))
				&& line.contains("(") && line.contains(")") && line.contains("{") )
				methodCounter++;
		}
		return methodCounter; 
	}
	
	/**
	 * Calculates the NOC metric.
	 * @param filepath the path of the file
	 * @throws IOException
	 */	
	@Override
	public int calculateNOC(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int classCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //remove leading and trailing white spaces
			if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				classCounter++;
			}
		}
		return classCounter; 
	}
	

}
