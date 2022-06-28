package codeanalyzer.exporter;

import java.util.Map;

/**
 * Exports calculated metrics to a json file.
 * @author nkakonas
 *
 */
public class JsonExporter implements MetricsExporter {
    
	/**
	 * Writes exported metrics in a json file.
	 * @param metrics the calculated metrics 
	 * @param filepath the path of the file
	 * @throws IOException
	 */
    public void writeFile(Map<String, Integer> metrics, String filepath) {
		// Functionality not implemented yet
		// No need to implement it for the assignment
	}

}
