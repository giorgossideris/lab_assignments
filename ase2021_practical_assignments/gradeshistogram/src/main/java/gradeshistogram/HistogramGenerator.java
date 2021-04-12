import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 * HistogramGenerator class contains the methods that read a file with grades
 * and create a Histogram and the main method of the project.
 * 
 * @author Giorgos Sideris
 */

public class HistogramGenerator {
	
	/**
	 * The main method of the project.
	 * 
	 * @param args: args[0] should contain the name of the file
	 */
	public static void main(String[] args) {
		int[] grades = null;
		try {
			grades = HistogramGenerator.readGradesFile(args[0]); // read the file with the grades
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		HistogramGenerator.generateHistogram(grades); // generate the histogram with the grades
	}

	/**
	 * This method is used to read a file with grades.
	 * 
	 * @param gradesFileName: The name of a file that contains the grades, as
	 *                        integers in range [0, 10], written in different lines.
	 * @return int[] An array with the grades frequencies, the cell i contains the frequency of the grade i.
	 * @exception FileNotFoundException
	 * @exception IOException
	 * @see FileNotFoundException
	 * @see IOException
	 */
	public static int[] readGradesFile(String gradesFileName) throws FileNotFoundException, IOException {

		InputStream in = HistogramGenerator.class.getResourceAsStream(gradesFileName); // input stream of the grades
		BufferedReader gradesReader = new BufferedReader((new InputStreamReader(in))); // reads the grades

		String gradeStr; // the grade read as a String

		int[] gradesFrequencies = new int[11]; // gradesFrequencies[i] contain the times that the grade i has appeared
											   // grades in range [0, 10]
		
		// calculate the frequencies of grades
		while ((gradeStr = gradesReader.readLine()) != null) {
			int nextGrade = Integer.parseInt(gradeStr);
			gradesFrequencies[nextGrade]++;
		}

		gradesReader.close();

		return gradesFrequencies;

	}

	/***
	 * Receives a single dimension Integer array. From this array the dataset that
	 * will be used for the visualization is generated. Finally, The histogram is
	 * generated with the use of the aforementioned dataset and then presented in
	 * the screen. Code based on:
	 * BuildAutomationToolsDemoProject/histogramgenerator/src/main/java/histogramgenerator/JFreeChartXYLineChartDemo.java
	 * (from Github).
	 * 
	 * @param dataValues Single dimension integer array
	 */
	public static void generateHistogram(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createHistogram JFreeChart
		JFreeChart chart = ChartFactory.createHistogram("Grades histogram", "Grade", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("grades_chart", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

}
