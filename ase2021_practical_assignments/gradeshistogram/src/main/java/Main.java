/**
 * The class the contains the main method of the project.
 * 
 * @author Giorgos Sideris
 *
 */
public class Main {
	
	/**
	 * The main method of the project.
	 * 
	 * @param args: args[0] should contain the name of the file
	 */
	public static void main(String[] args) {
		int[] grades = null;
		try {
			grades = HistogramGenerator.readGradesFile(args[0]); // read the file with the grades
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		HistogramGenerator.generateChart(grades); // generate the chart with the grades
	}

}
