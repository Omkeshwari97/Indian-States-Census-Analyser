package IndianStatesCensusAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV 
{
	@CsvBindByName 
	public String state;
	
	@CsvBindByName
	public long population;
	
	@CsvBindByName
	public long area;
	
	@CsvBindByName
	public int density;
	
}
