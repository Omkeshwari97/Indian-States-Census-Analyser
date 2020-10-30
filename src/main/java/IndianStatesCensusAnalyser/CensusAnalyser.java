package IndianStatesCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import com.google.gson.Gson;

import IndianStatesCensusAnalyser.CensusAnalyserException.ExceptionType;

public class CensusAnalyser 
{
	List<IndiaCensusCSV> censusCSVList = null;
	
	public int loadIndiaStateCensus(String csvFilePath) throws IOException, CSVBuilderException
	{
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) 
		{
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			censusCSVList = csvBuilder.getCSVFileList(reader, IndiaCensusCSV.class);
			
			return censusCSVList.size();
		} 
		catch (NoSuchFileException e) 
		{
			throw new CSVBuilderException(e.getMessage(),
					CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
		} 
		catch (CSVBuilderException e) 
		{
			throw new CSVBuilderException(e.getMessage(),
					CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	
	public int loadIndiaStatesCodeData(String csvFilePath) throws IOException, CSVBuilderException
	{
		
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) 
		{
				
			Iterator<IndianStateCodeCsv> censusCSVIterator = new OpenCSVBuilder().getCSVFileIterator(reader, IndianStateCodeCsv.class);
				
			return this.getCount(censusCSVIterator);
		} 
		catch (NoSuchFileException e) 
		{
			throw new CSVBuilderException(e.getMessage(),
					CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
		} 
		catch (CSVBuilderException e) 
		{
			throw new CSVBuilderException(e.getMessage(),
					CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
		catch (RuntimeException e)
		{
			throw new CSVBuilderException(e.getMessage(),
					CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	
	public <E> int getCount(Iterator<E> iterator)
	{
		Iterable<E> csvIterable = () -> iterator;
		int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false)
							.count();
		return numOfEntries;
	}

	public String getStateWiseSortedCensusData(String indianCensusCsvFilePath) throws CensusAnalyserException 
	{
		if(censusCSVList == null || censusCSVList.size() == 0)
		{
			throw new CensusAnalyserException("No census data", ExceptionType.NO_CENSUS_DATA);
		}
		
		Comparator<IndiaCensusCSV> censusComparator = Comparator.comparing(census -> census.state);
		this.sort(censusComparator);
		String sortedStateCensusJson = new Gson().toJson(censusCSVList);
		return sortedStateCensusJson;
	}

	private void sort(Comparator<IndiaCensusCSV> censusComparator) 
	{
		for (int i = 0; i < censusCSVList.size()-1; i++) 
		{	
            for (int j = 0; j < censusCSVList.size()-i-1; j++) 
            {
            	IndiaCensusCSV census1 = censusCSVList.get(j);
            	IndiaCensusCSV census2 = censusCSVList.get(j+1);
            	
                if (censusComparator.compare(census1, census2) > 0) 
                { 
                	censusCSVList.set(j, census2);
                	censusCSVList.set(j+1, census1);
                } 
            }
		}
	}
}
