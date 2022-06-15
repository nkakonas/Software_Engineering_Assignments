package codeanalyzer;

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mock;

import codeanalyzer.analyzer.SourceCodeAnalyzerManager;
import codeanalyzer.exporter.MetricsExporterManager;

import org.mockito.*;
import org.junit.Before;

public class DivideActivitiesTest {

	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private String outputFilepath = "src/test/resources/output_metrics";
	
	DivideActivities divideActivities = new DivideActivities();
	
	@Before 
	public void initMocks() {
	       MockitoAnnotations.initMocks(this);
	   }
	
	@Mock
	SourceCodeAnalyzerManager analyzerManager;
	
	@Mock
	MetricsExporterManager exporterFactory;
	
	@Test
	public void testCodeAnalysis() throws IOException {
		divideActivities.codeAnalyzer("regex", "local", TEST_CLASS_LOCAL, "csv", outputFilepath);
		analyzerManager.createSourceCodeAnalyzer("regex", "local");
		Mockito.verify(analyzerManager).createSourceCodeAnalyzer("regex", "local");
		exporterFactory.createMetricsExporter("csv");
		Mockito.verify(exporterFactory).createMetricsExporter("csv");
	}
	
}
