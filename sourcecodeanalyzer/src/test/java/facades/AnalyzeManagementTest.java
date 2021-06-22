package facades;

import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;

public class AnalyzeManagementTest {
	AnalyzeManagement analysis = new AnalyzeManagement();
	
	@Test
	public void testExecuteAnalysis() throws NoSuchFieldException, SecurityException, IOException {
		HashMap<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		InformationGenerator infGen = Mockito.mock(InformationGenerator.class);
		when(infGen.calculateMetrics("a file path", "a source code type", "a source file location")).thenReturn(metrics);
		FieldSetter.setField(analysis, analysis.getClass().getDeclaredField("infGenerator"), infGen);
		
		String outputFilePath = "src/test/resources/output_metrics";
		String outputType = "csv";
		analysis.executeAnalysis("a file path", "a source code type", "a source file location", outputFilePath, outputType);
		
		// evaluate that the file exists
		File outputFile = new File(outputFilePath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		//evaluate that the file's values are correct
		BufferedReader br = new BufferedReader(new FileReader(outputFile));
		//line 1
		String expLine1 = "loc,noc,nom,";
		String actLine1 = br.readLine();
		Assert.assertEquals(expLine1, actLine1);
		//line 2
		String expLine2 = "30,2,5,";
		String actLine2 = br.readLine();
		Assert.assertEquals(expLine2, actLine2);
		//line 3
		String actLine3 = br.readLine();
		Assert.assertEquals(null, actLine3);
		
		br.close();
		// delete the generated file
		outputFile.delete();
	}
}
