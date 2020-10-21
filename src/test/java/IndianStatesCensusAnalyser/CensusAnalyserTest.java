package IndianStatesCensusAnalyser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class CensusAnalyserTest 
{
	private static final String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCensusData.csv";
	private static final String INDIAN_STATE_CODE_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCode.csv";
	
	@Test
	public void givenIndianCensusCSVFile_ReturnsCorrectRecords() throws IOException
	{
		try
		{
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_CSV_FILE_PATH);
			assertEquals(29, numOfRecords);
		}
		catch (CensusAnalyserException e) {	}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords() throws IOException
	{
		try
		{
			CSVStates csvStates = new CSVStates();
			int numOfRecords = csvStates.loadIndiaStatesCodeData(INDIAN_STATE_CODE_CSV_FILE_PATH);
			assertEquals(37, numOfRecords);
		}
		catch (CensusAnalyserException e) {	}
	}
}
