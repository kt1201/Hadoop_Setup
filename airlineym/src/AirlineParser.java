import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	
	public AirlineParser(Text value) {
		
		String []airData = value.toString().split(",");
		year = Integer.parseInt(airData[0]);
		month = Integer.parseInt(airData[1]);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}
	
}
