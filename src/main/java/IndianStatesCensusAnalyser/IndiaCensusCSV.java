package IndianStatesCensusAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV 
{
	@CsvBindByName
	private String state;
	
	@CsvBindByName
	private long population;
	
	@CsvBindByName
	private long area;
	
	@CsvBindByName
	private int density;
	
}
