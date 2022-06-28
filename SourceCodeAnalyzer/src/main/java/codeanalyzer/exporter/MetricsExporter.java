package codeanalyzer.exporter;

import java.io.IOException;
import java.util.Map;

/**
 * Interface for a metrics exporter.
 * @author nkakonas
 *
 */
public interface MetricsExporter {
	
	/**
	 * Writes exported metrics in a file.
	 * @param metrics the calculated metrics 
	 * @param filepath the path of the file
	 * @throws IOException
	 */
	public void writeFile(Map<String, Integer> metrics, String filepath) throws IOException;

}
