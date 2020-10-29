package IndianStatesCensusAnalyser;

public class CSVBuilderException extends Exception
{
	enum ExceptionType
	{
		CENSUS_FILE_PROBLEM
	}
	
	ExceptionType type;
	
	public CSVBuilderException(String message, ExceptionType type)
	{
		super(message);
		this.type = type;
	}
}
