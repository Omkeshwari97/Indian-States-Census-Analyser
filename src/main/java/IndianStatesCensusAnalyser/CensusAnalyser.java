package IndianStatesCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser 
{
	public int loadIndiaStateCensus(String csvFilePath) throws IOException, CensusAnalyserException
	{
		try 
		{
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			
			int numOfEntries = 0;
			
			while(censusCSVIterator.hasNext())
			{
				numOfEntries++;
				IndiaCensusCSV censusDate = censusCSVIterator.next();
			}
			
			return numOfEntries;
		} 
		catch (IOException e) 
		{
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
}
