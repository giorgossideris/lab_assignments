import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
* HistogramGenerator class contains the methods that
* read a file with grades and create a Histogram.
* 
* @author  Giorgos Sideris
*/

public class HistogramGenerator {

	/**
	 * This method is used to read a file with grades.
	 * 
	 * @param gradesFilePath: The path of a file that contains the grades, as integers, written in different lines.
	 * @return int[] An array with the grades
	 * @exception FileNotFoundException
	 * @exception IOException
	 * @see FileNotFoundException
	 * @see IOException
	 */
	 public static int[] readGradesFile(String gradesFilePath) throws FileNotFoundException, IOException{
		 int linesOfFile = 150; // count the numbers of lines in the file with grades
		 ClassLoader classLoader = HistogramGenerator.class.getClassLoader();
		 File gradesFile = new File(classLoader.getResource(gradesFilePath).getFile()); // the file with the grades
		 int[] grades = new int[linesOfFile]; // array of grades
		 Scanner gradesReader = new Scanner(gradesFile); // the reader of the file with the grades
		 int lineCounter = 0; // counts the lines that have been read
		 
	     while (gradesReader.hasNextLine()) {
	        String grade = gradesReader.nextLine();
	        grades[lineCounter] = Integer.parseInt(grade);
	        lineCounter++;
	     }
	     
	     gradesReader.close();
		 return grades;
		
	}
	 
	 /***
		 * Receives a single dimension Integer array. From this array the dataset
		 * that will be used for the visualization is generated. Finally, The chart
		 * is generated with the use of the aforementioned dataset and then
		 * presented in the screen.
		 * Code from: BuildAutomationToolsDemoProject/histogramgenerator/src/main/java/histogramgenerator/JFreeChartXYLineChartDemo.java
		 * (from Github).
		 * 
		 * @param dataValues Single dimension integer array
		 */
		public static void generateChart(int[] dataValues) {
			/*
			 * The XYSeriesCollection object is a set XYSeries series (dataset) that
			 * can be visualized in the same chart
			 */
			XYSeriesCollection dataset = new XYSeriesCollection();
			/*
			 * The XYSeries that are loaded in the dataset. There might be many
			 * series in one dataset.
			 */
			XYSeries data = new XYSeries("random values");

			/*
			 * Populating the XYSeries data object from the input Integer array
			 * values.
			 */
			for (int i = 0; i < dataValues.length; i++) {
				data.add(i, dataValues[i]);
			}

			// add the series to the dataset
			dataset.addSeries(data);

			boolean legend = false; // do not visualize a legend
			boolean tooltips = false; // do not visualize tooltips
			boolean urls = false; // do not visualize urls
			boolean x_axis_title = false; // do not visualize x_axis_title;

			// Declare and initialize a createXYLineChart JFreeChart
			JFreeChart chart = ChartFactory.createXYLineChart("Grades chart", "id", "grade", dataset,
					PlotOrientation.VERTICAL, legend, tooltips, urls);

			/*
			 * Initialize a frame for visualizing the chart and attach the
			 * previously created chart.
			 */
			ChartFrame frame = new ChartFrame("grades_chart", chart);
			frame.pack();
			// makes the previously created frame visible
			frame.setVisible(true);
		}

	 
	 /**
		 * This method is used to count the number of lines in a file.
		 * The code is from: https://stackoverflow.com/questions/1277880/how-can-i-get-the-count-of-line-in-a-file-in-an-efficient-way/1277904
		 * and the first answer from "Mnementh".
		 * @param filePath: The path of a file.
		 * @return int The number of lines that the requested file contains.
		 * @exception FileNotFoundException
		 * @exception IOException
		 * @see FileNotFoundException
		 * @see IOException
		 */
	 public static int countLinesOfFile(String filePath) throws FileNotFoundException, IOException {
		 ClassLoader classLoader = HistogramGenerator.class.getClassLoader();
		 BufferedReader reader = new BufferedReader(new FileReader(classLoader.getResource(filePath).getFile()));
		 int lines = 0;
		 while (reader.readLine() != null) lines++;
		 reader.close();
		 return lines;
	 }
}
