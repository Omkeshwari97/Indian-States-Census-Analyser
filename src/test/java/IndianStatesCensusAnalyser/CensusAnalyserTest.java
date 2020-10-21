package IndianStatesCensusAnalyser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class CensusAnalyserTest 
{
	private static final String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCensusData.csv";
	
	@Test
	public void givenIndianCensusCSVFile_ReturnsCorrectRecords() throws IOException
	{
		try
		{
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaStatusData(INDIAN_CENSUS_CSV_FILE_PATH);
			assertEquals(29, numOfRecords);
		}
		catch (CensusAnalyserException e) {	}
	}
}
