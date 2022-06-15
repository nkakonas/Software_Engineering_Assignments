package codeanalyzer.analyzer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import codeanalyzer.reader.SourceFileReader;

/**
 * Uses regex in order to analyze the contents of a Java source
 * code file and claculate the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes. 
 * @author nkakonas
 *
 */
public class RegexAnalyzer implements SourceCodeAnalyzer {
    private SourceFileReader fileReader;
	
	public RegexAnalyzer(SourceFileReader fileReader) {
		this.fileReader = fileReader;
	}
	
	/**
	 * Calculates the LOC metric.
	 * @param filepath the path of the file
	 * @throws IOException
	 */	
	@Override
	public int calculateLOC(String filepath) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
	    Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);
	    int nonCodeLinesCounter = 0;
	    while (nonCodeLinesMatcher.find()) {
	        nonCodeLinesCounter++;
	    }	
	    int sourceFileLength = sourceCode.split("\n").length;
	    int loc =  sourceFileLength - nonCodeLinesCounter;
	    return loc;
	}
	
	/**
	 * Calculates the NOM metric.
	 * @param filepath the path of the file
	 * @throws IOException
	 */	
	@Override
	public int calculateNOM(String filepath) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
	    Matcher methodSignatures = pattern.matcher(sourceCode);
	    int methodCounter = 0;
	    while (methodSignatures.find()) {
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
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
	    Matcher classSignatures = pattern.matcher(sourceCode);
	    int classCounter = 0;
	    while (classSignatures.find()) {
	       	classCounter++;
	    }
		return classCounter;
	}

}
