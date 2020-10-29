package IndianStatesCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser 
{
	public int loadIndiaStateCensus(String csvFilePath) throws IOException, CSVBuilderException
	{
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) 
		{
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvBuilder.getCSVFileIterator(reader, IndiaCensusCSV.class);
			
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
	}
	
	public <E> int getCount(Iterator<E> iterator)
	{
		Iterable<E> csvIterable = () -> iterator;
		int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false)
							.count();
		return numOfEntries;
	}
}
