package IndianStatesCensusAnalyser;

public class CensusAnalyserException extends Exception 
{
	enum ExceptionType
	{
		CENSUS_FILE_PROBLEM, NO_CENSUS_DATA
	}
	
	ExceptionType type;
	
	public CensusAnalyserException(String message, ExceptionType type)
	{
		super(message);
		this.type = type;
	}

}
