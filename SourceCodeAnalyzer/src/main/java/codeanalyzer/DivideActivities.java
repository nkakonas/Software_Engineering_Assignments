package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.analyzer.SourceCodeAnalyzer;
import codeanalyzer.analyzer.SourceCodeAnalyzerManager;
import codeanalyzer.exporter.MetricsExporter;
import codeanalyzer.exporter.MetricsExporterManager;

/**
 * This class is used for dividing the activities
 * to other classes.
 * @author nkakonas
 *
 */
public class DivideActivities {
    /**
     * Performs the operations of the system,
     * in the context of code analysis.
     * @param sourceCodeAnalyzerType the type of the source code analyzer
     * @param sourceFileLocation     the location of the source code file
     * @param filepath               the path of the file
     * @param outputFileType         the type of the output file
     * @param outputFilePath         the path of the output file
     * @throws IOException
     */
    public void codeAnalyzer(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation,
            String outputFilePath, String outputFileType) throws IOException {
        SourceCodeAnalyzerManager codeAnalyzerManager = new SourceCodeAnalyzerManager();
        SourceCodeAnalyzer codeAnalyzer = codeAnalyzerManager.createSourceCodeAnalyzer(sourceCodeAnalyzerType, sourceFileLocation);
        int loc = codeAnalyzer.calculateLOC(filepath);
        int nom = codeAnalyzer.calculateNOM(filepath);
        int noc = codeAnalyzer.calculateNOC(filepath);

        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc", loc);
        metrics.put("nom", nom);
        metrics.put("noc", noc);

        MetricsExporterManager exporterManager = new MetricsExporterManager();
        MetricsExporter exporter = exporterManager.createMetricsExporter(outputFileType);
        exporter.writeFile(metrics, outputFilePath);
    }

}
