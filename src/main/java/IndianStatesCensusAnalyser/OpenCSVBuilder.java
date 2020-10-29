package IndianStatesCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder 
{
	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws IOException, CensusAnalyserException
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
