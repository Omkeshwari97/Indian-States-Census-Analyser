package IndianStatesCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder 
{
	@Override
	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws IOException, CSVBuilderException
	{
		return this.getCSVBean(reader, csvClass).iterator();
	}

	@Override
	public List getCSVFileList(Reader reader, Class csvClass) throws IOException, CSVBuilderException 
	{
		
		return this.getCSVBean(reader, csvClass).parse();
	}

	private CsvToBean<E> getCSVBean(Reader reader, Class csvClass) throws CSVBuilderException 
	{
		try 
		{
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
			csvToBeanBuilder.withType(csvClass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			return csvToBeanBuilder.build();
			
		} 
		catch(RuntimeException e)
		{
			throw new CSVBuilderException(e.getMessage(), 
					CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
			
		}
	}
}
