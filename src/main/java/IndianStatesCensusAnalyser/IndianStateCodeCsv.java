package IndianStatesCensusAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCodeCsv 
{
	@CsvBindByName(column = "State Name", required = true)
	private String state;
	
	@CsvBindByName(column = "StateCode", required = true)
	private String stateCode;
	
	@Override
	public String toString()
	{
		return "StateCodeCSV [state=" + state + ", stateCode=" + stateCode + "]";
	}
}
