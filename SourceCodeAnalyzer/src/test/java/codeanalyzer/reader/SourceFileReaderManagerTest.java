package codeanalyzer.reader;

import org.junit.Assert;
import org.junit.Test;

public class SourceFileReaderManagerTest {
	
	SourceFileReaderManager manager = new SourceFileReaderManager();
	
	@Test
	public void createSourceFileReader_testWeb() {
		Assert.assertTrue(manager.createSourceFileReader("web") instanceof WebFileReader);
	}
	
	@Test
	public void createSourceFileReader_testLocal() {
		Assert.assertTrue(manager.createSourceFileReader("local") instanceof LocalFileReader);
	}
	
	@Test
	public void createSourceFileReader_testNull() {
		Assert.assertTrue(manager.createSourceFileReader("invalid") instanceof NullFileReader);
	}

}
