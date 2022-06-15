package codeanalyzer.analyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import codeanalyzer.reader.LocalFileReader;
import codeanalyzer.reader.SourceFileReader;
import codeanalyzer.reader.WebFileReader;

public class StrcompAnalyzerTest {
	
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	
	SourceFileReader localReader = new LocalFileReader();
	SourceFileReader webReader = new WebFileReader();
	
	private SourceCodeAnalyzer localAnalyzer = new StrcompAnalyzer(localReader);
	
	@Test
	public void testCalculateStrCompLOC_localAnalyzer() throws IOException {
		assertEquals(7, localAnalyzer.calculateLOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompNOM_localAnalyzer() throws IOException {
		assertEquals(3, localAnalyzer.calculateNOM(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompNOC_localAnalyzer() throws IOException {
		assertEquals(3, localAnalyzer.calculateNOC(TEST_CLASS));
	}

}
