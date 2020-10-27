package IndianStatesCensusAnalyser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class CensusAnalyserTest 
{
	private static final String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCensusData.csv";
	private static final String INDIAN_CENSUS_WRONG_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCensusDat.csv";
	private static final String INDIAN_CENSUS_WRONG_CSV_FILE_EXTENSION = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCensusData.txt";
	private static final String US_CENSUS_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\USCensusData.csv";
	private static final String INDIAN_STATE_CODE_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCode.csv";
	private static final String INDIAN_STATE_CODE_WRONG_CSV_FILE_EXTENSION = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCode.txt";

	
	//uc1
	@Test
	public void givenIndianCensusCSVFile_ReturnsCorrectRecords() throws IOException
	{
		try
		{
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_CSV_FILE_PATH);
			assertEquals(29, numOfRecords);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_IfIncorrect_ShoudThrowException() throws IOException
	{
		try
		{
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_WRONG_CSV_FILE_PATH);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_IfIncorrectExtension_ShoudThrowException() throws IOException
	{
		try
		{
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_WRONG_CSV_FILE_EXTENSION);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_IfIncorrectDelimiter_ShoudThrowException() throws IOException
	{
		try
		{
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(US_CENSUS_CSV_FILE_PATH);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_IfIncorrectHeader_ShoudThrowException() throws IOException
	{
		try
		{
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(US_CENSUS_CSV_FILE_PATH);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	
	//uc2
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
	
	@Test
	public void givenIndianStateCodeCSVFile_IfIncorrect_ShoudThrowException() throws IOException
	{
		try
		{
			CSVStates csvStates = new CSVStates();
			int numOfRecords = csvStates.loadIndiaStatesCodeData(INDIAN_CENSUS_WRONG_CSV_FILE_PATH);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_IfIncorrectExtension_ShoudThrowException() throws IOException
	{
		try
		{
			CSVStates csvStates = new CSVStates();
			int numOfRecords = csvStates.loadIndiaStatesCodeData(INDIAN_STATE_CODE_WRONG_CSV_FILE_EXTENSION);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_IfIncorrectDelimiter_ShoudThrowException() throws IOException
	{
		try
		{
			CSVStates csvStates = new CSVStates();
			int numOfRecords = csvStates.loadIndiaStatesCodeData(US_CENSUS_CSV_FILE_PATH);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_IfIncorrectHeader_ShoudThrowException() throws IOException
	{
		try
		{
			CSVStates csvStates = new CSVStates();
			int numOfRecords = csvStates.loadIndiaStatesCodeData(US_CENSUS_CSV_FILE_PATH);
		}
		catch (CensusAnalyserException e) 
		{	
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

}
