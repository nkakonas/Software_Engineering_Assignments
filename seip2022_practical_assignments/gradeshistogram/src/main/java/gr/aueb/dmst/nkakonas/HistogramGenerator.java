package gr.aueb.dmst.nkakonas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {

    public int[] makeGradesTable(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanCount = new Scanner(file);
        int countGrades = 0;
        while (scanCount.hasNextLine()) {
            countGrades++;
            scanCount.nextLine();
        }
        scanCount.close();
        Scanner scan = new Scanner(file);
        int[] grades = new int[countGrades];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = Integer.parseInt(scan.nextLine());
        }
        scan.close();
        return grades;
    }

    public void printThePlot(int[] grades) {
        /*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("grades");
        /*
		 * freq is a table with all the frequencies of the grades of all the students.
		 * First we initialize freq table
		 */
        int[] freq = new int[11];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = 0;
        }

        // calculate the values of the freq table
        for (int i = 0; i < grades.length; i++) {
            freq[grades[i]]++;
        }

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < freq.length; i++) {
			data.add(i, freq[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Frequency of Grades", "Grades", "Frequency", dataset);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException {
        HistogramGenerator histGen = new HistogramGenerator();
        // take the table with all the grades
        int[] grades = histGen.makeGradesTable(args[0]);
        histGen.printThePlot(grades);
    }

}
