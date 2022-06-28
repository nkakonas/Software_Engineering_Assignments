package codeanalyzer.exporter;

import java.util.Map;

/**
 * Represents a null exporter.
 * @author nkakonas
 *
 */
public class NullExporter implements MetricsExporter {
    
	/**
	 * Displays an error message for wrong output file type.
	 * @param metrics the calculated metrics 
	 * @param filepath the path of the file
	 */
    public void writeFile(Map<String, Integer> metrics, String filepath) {
		System.err.println("Unknown output file type!");
	}

}
