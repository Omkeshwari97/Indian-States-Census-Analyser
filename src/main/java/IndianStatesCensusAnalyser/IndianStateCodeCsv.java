package IndianStatesCensusAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCodeCsv 
{
	@CsvBindByName
	private int srno;
	
	@CsvBindByName
	private String state;
	
	@CsvBindByName
	private int tin;
	
	@CsvBindByName
	private String stateCode;
}
