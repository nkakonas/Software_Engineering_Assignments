package codeanalyzer.analyzer;

import org.junit.Assert;
import org.junit.Test;

public class SourceCodeAnalyzerManagerTest {

	SourceCodeAnalyzerManager manager = new SourceCodeAnalyzerManager();
	
	@Test
	public void createSourceCodeAnalyzer_testRegexLocal() {
		Assert.assertTrue(manager.createSourceCodeAnalyzer("regex", "local") instanceof RegexAnalyzer);
	}
	
	@Test
	public void createSourceCodeAnalyzer_testStrcompLocal() {
		Assert.assertTrue(manager.createSourceCodeAnalyzer("strcomp", "local") instanceof StrcompAnalyzer);
	}
	
	@Test
	public void createSourceCodeAnalyzer_testNullLocal() {
		Assert.assertTrue(manager.createSourceCodeAnalyzer("invalid", "local") instanceof NullAnalyzer);
	}
	
}
