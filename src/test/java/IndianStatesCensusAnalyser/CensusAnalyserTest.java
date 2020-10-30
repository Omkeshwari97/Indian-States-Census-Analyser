package IndianStatesCensusAnalyser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CensusAnalyserTest 
{
	private static final String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCensusData.csv";
	private static final String INDIAN_CENSUS_WRONG_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCensusDat.csv";
	private static final String INDIAN_CENSUS_WRONG_CSV_FILE_EXTENSION = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCensusData.txt";
	private static final String US_CENSUS_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\USCensusData.csv";
	private static final String INDIAN_STATE_CODE_CSV_FILE_PATH = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCode.csv";
	private static final String INDIAN_STATE_CODE_WRONG_CSV_FILE_EXTENSION = "C:\\Users\\omkes\\eclipse-workspace\\IndianStatesCensusAnalyser\\IndiaStateCode.txt";

	CensusAnalyser censusAnalyser = null;
	
	@Before
	public void setUp()
	{
		censusAnalyser = new CensusAnalyser();
	}
	
	//uc1
	@Test
	public void givenIndianCensusCSVFile_ReturnsCorrectRecords() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_CSV_FILE_PATH);
			assertEquals(29, numOfRecords);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_IfIncorrect_ShoudThrowException() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_WRONG_CSV_FILE_PATH);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
			assertEquals(CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_IfIncorrectExtension_ShoudThrowException() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_WRONG_CSV_FILE_EXTENSION);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
			assertEquals(CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_IfIncorrectDelimiter_ShoudThrowException() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(US_CENSUS_CSV_FILE_PATH);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
			assertEquals(CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_IfIncorrectHeader_ShoudThrowException() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStateCensus(US_CENSUS_CSV_FILE_PATH);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
			assertEquals(CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	
	//uc2
	@Test
	public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStatesCodeData(INDIAN_STATE_CODE_CSV_FILE_PATH);
			assertEquals(37, numOfRecords);
		}
		catch (CSVBuilderException e) {	}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_IfIncorrect_ShoudThrowException() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStatesCodeData(INDIAN_CENSUS_WRONG_CSV_FILE_PATH);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
			assertEquals(CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_IfIncorrectExtension_ShoudThrowException() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStatesCodeData(INDIAN_STATE_CODE_WRONG_CSV_FILE_EXTENSION);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
			assertEquals(CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_IfIncorrectDelimiter_ShoudThrowException() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStatesCodeData(US_CENSUS_CSV_FILE_PATH);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
			assertEquals(CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_IfIncorrectHeader_ShoudThrowException() throws IOException
	{
		try
		{
			int numOfRecords = censusAnalyser.loadIndiaStatesCodeData(US_CENSUS_CSV_FILE_PATH);
		}
		catch (CSVBuilderException e) 
		{	
			e.printStackTrace();
			assertEquals(CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIndianCensusData_WhenSortedOnState_ShoudReturnSortedResult() throws CensusAnalyserException, IOException, CSVBuilderException
	{
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_CSV_FILE_PATH);
			String sortedCensusData = censusAnalyser.getStateWiseSortedCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
			IndiaCensusCSV[] censusCSV = new Gson().fromJson(sortedCensusData, IndiaCensusCSV[].class);
			assertEquals("Andhra Pradesh", censusCSV[0].state);
			assertEquals("West Bengal", censusCSV[28].state);
		}  
		catch (CensusAnalyserException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFile_WhenSortedOnStateCode_ShoudReturnSortedResult() throws CensusAnalyserException, IOException, CSVBuilderException
	{
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			censusAnalyser.loadIndiaStatesCodeData(INDIAN_STATE_CODE_CSV_FILE_PATH);
			String sortedCensusData = censusAnalyser.getStateCodeWiseSortedCensusData(INDIAN_STATE_CODE_CSV_FILE_PATH);
			IndianStateCodeCsv[] censusCSV = new Gson().fromJson(sortedCensusData, IndianStateCodeCsv[].class);
			System.out.println(censusCSV[0] +""+ censusCSV[36]);
			assertEquals("AD", censusCSV[0].stateCode);
			assertEquals("WB", censusCSV[36].stateCode);
		}  
		catch (CensusAnalyserException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenIndianCensusData_WhenSortedOnPopulation_ShoudReturnSortedResultinDescendingOrder() throws CensusAnalyserException, IOException, CSVBuilderException
	{
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			censusAnalyser.loadIndiaStateCensus(INDIAN_CENSUS_CSV_FILE_PATH);
			String sortedCensusData = censusAnalyser.getPopulationWiseSortedCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
			IndiaCensusCSV[] censusCSV = new Gson().fromJson(sortedCensusData, IndiaCensusCSV[].class);
			assertEquals("Uttar Pradesh", censusCSV[0].state);
			assertEquals("Sikkim", censusCSV[28].state);
		}  
		catch (CensusAnalyserException e) 
		{
			e.printStackTrace();
		}
	}

}
