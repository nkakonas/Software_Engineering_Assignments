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

    public int[] makeGradesTable(String path) throws FileNotFoundException {
        /*
         * use the file in order to count the number of grades, that it contains
         */

        // the parameter path has the path that the user has typed from command line
        File file = new File(path);
        // the object file passes to the Scanner so that we can read it
        Scanner scanCount = new Scanner(file);
        // initialize the count of Grades to zero (0)
        int countGrades = 0;
        // while there is an other line, which means that there is an other grade in the file, we add one (1) to the countGrades variable
        while (scanCount.hasNextLine()) {
            countGrades++;
            // go to the next line of the file
            scanCount.nextLine();
        }
        // close the scanner
        scanCount.close();

        /*
         * extract the data form the file and save them into the array grades[countGrades]
         */

        // read the file again, in order to start again from the first line
        Scanner scan = new Scanner(file);
        // initialize the array "grades" with grades.length = countGrades
        int[] grades = new int[countGrades];
        /*
         * Every line of the file has its own grade. So for every line of the grades.txt file we take 
         * the grade and insert it in the grades array
         */
        for (int i = 0; i < grades.length; i++) {
            grades[i] = Integer.parseInt(scan.nextLine());
        }
        // close the scanner
        scan.close();
        return grades;
    } // End of method makeGradesTable

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
    } // End of method printThePlot

    public static void main(String[] args) throws FileNotFoundException {
        // object used to call the methods
        HistogramGenerator histGen = new HistogramGenerator();

        // take the table with all the grades from txt file
        int[] grades = histGen.makeGradesTable(args[0]);

        // print the Histogram
        histGen.printThePlot(grades);
    } // End of main

} // End of class HistogramGenerator
