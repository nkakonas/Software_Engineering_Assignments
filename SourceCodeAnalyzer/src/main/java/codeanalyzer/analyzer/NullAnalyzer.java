package codeanalyzer.analyzer;

import java.io.IOException;

/**
 * Manages the case that the source code is null.
 * @author nkakonas
 *
 */
public class NullAnalyzer implements SourceCodeAnalyzer {
    
	/**
	 * Calculates the LOC metric.
	 * @param filepath the path of the file
	 * @throws IOException
	 */	
	@Override
	public int calculateLOC(String filepath) throws IOException {
		return -1;
	}
	
	/**
	 * Calculates the NOM metric.
	 * @param filepath the path of the file
	 * @throws IOException
	 */	
	@Override
	public int calculateNOM(String filepath) throws IOException {
		return -1;
	}
	
	/**
	 * Calculates the NOC metric.
	 * @param filepath the path of the file
	 * @throws IOException
	 */	
	@Override
	public int calculateNOC(String filepath) throws IOException {
		return -1;
	}

}
