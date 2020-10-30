package IndianStatesCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> 
{
	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws IOException, CSVBuilderException;	
	public List<E> getCSVFileList(Reader reader, Class csvClass) throws IOException, CSVBuilderException;	

}
