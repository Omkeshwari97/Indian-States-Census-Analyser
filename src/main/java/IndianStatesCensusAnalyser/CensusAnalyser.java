package IndianStatesCensusAnalyser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser 
{
	public int loadIndiaStateCensus(String csvFilePath) throws IOException, CensusAnalyserException
	{
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			
			Iterator<IndiaCensusCSV> censusCSVIterator = this.getCSVFileIterator(reader, IndiaCensusCSV.class);
				
			int numOfEntries = 0;
				
			while(censusCSVIterator.hasNext())
			{
				numOfEntries++;
				IndiaCensusCSV censusDate = censusCSVIterator.next();
			}
				
			return numOfEntries;
		} 
		catch (NoSuchFileException e) 
		{
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} 
		catch (CensusAnalyserException e) 
		{
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	
	public int loadIndiaStatesCodeData(String csvFilePath) throws IOException, CensusAnalyserException
	{
		
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
				
			Iterator<IndianStateCodeCsv> censusCSVIterator = this.getCSVFileIterator(reader, IndianStateCodeCsv.class);
				
			int numOfEntries = 0;
				
			while(censusCSVIterator.hasNext())
			{
				numOfEntries++;
				IndianStateCodeCsv censusDate = censusCSVIterator.next();
			}
				
			return numOfEntries;
		} 
		catch (NoSuchFileException e) 
		{
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} 
		catch (CensusAnalyserException e) 
		{
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	
	public <E> Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws IOException, CensusAnalyserException
	{
		try 
		{
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
			csvToBeanBuilder.withType(csvClass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<E> csvToBean = csvToBeanBuilder.build();
			return csvToBean.iterator();
			
		} 
		catch(RuntimeException e)
		{
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
}
