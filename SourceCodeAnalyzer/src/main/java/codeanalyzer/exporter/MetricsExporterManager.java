package codeanalyzer.exporter;

/**
 * A factory for the MetricsExporter interface that 
 * was created to implement the Strategy pattern.
 * @author nkakonas
 *
 */
public class MetricsExporterManager {
    
	/**
	 * Creates a MetricsExporter, according to the type of the output file. 
	 * @param filepath the path of the file
	 * @throws IllegalArgumentException
	 */
    public MetricsExporter createMetricsExporter(String fileType) {
		MetricsExporter exporter;
		if (fileType.equals("csv")) {
			exporter = new CsvExporter();
		} else if (fileType.equals("json")) {
			exporter = new JsonExporter();
		} else {
			exporter = new NullExporter();
		}
		return exporter;
	}

}
