package codeanalyzer.analyzer;

import codeanalyzer.reader.*;

/**
 * A class that manages the SourceCodeAnalyzer interface
 * and its classes.
 * @author nkakonas
 *
 */
public class SourceCodeAnalyzerManager {

    /**
	 * According to the path location this method, creates a SourceCodeAnalyzer.
	 * The file reader type is passed as an argument in the corresponding constructor,
	 * except from the null case, where the file reader type is redundant.
	 * @param analyzerType the type of the source code analyzer
	 * @param fileReaderType the path of the file
	 * @throws IllegalArgumentException
	 */
    public SourceCodeAnalyzer createSourceCodeAnalyzer(String analyzerType, String fileReaderType) {
	    SourceFileReaderManager fileReaderManager = new SourceFileReaderManager();
		SourceFileReader fileReader = fileReaderManager.createSourceFileReader(fileReaderType);
		SourceCodeAnalyzer codeAnalyzer;
		if (analyzerType.equals("regex")) {
			codeAnalyzer = new RegexAnalyzer(fileReader);
		} else if (analyzerType.equals("strcomp")) {
			codeAnalyzer = new StrcompAnalyzer(fileReader);
		} else {
			codeAnalyzer = new NullAnalyzer();
		}
		return codeAnalyzer;
    }

}
