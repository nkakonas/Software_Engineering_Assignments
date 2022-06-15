package codeanalyzer.exporter;

import org.junit.Assert;
import org.junit.Test;

public class MetricsExporterManagerTest {
	
	MetricsExporterManager manager = new MetricsExporterManager();
	
	@Test
	public void createMetricsExporter_testCsv() {
		Assert.assertTrue(manager.createMetricsExporter("csv") instanceof CsvExporter);
	}
	
	@Test
	public void createMetricsExporter_testJson() {
		Assert.assertTrue(manager.createMetricsExporter("json") instanceof JsonExporter);
	}
	
	@Test
	public void createMetricsExporter_testNull() {
		Assert.assertTrue(manager.createMetricsExporter("invalid") instanceof NullExporter);
	}

}
