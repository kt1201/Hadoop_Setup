import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int day;
	private int depTime;
	
	public AirlineParser(Text value) {
		
		String []airData = value.toString().split(",");
		year = Integer.parseInt(airData[0]);
		month = Integer.parseInt(airData[1]);
		day = Integer.parseInt(airData[2]);
		
		if("NA".equals(airData[4])) {
			depTime = -1;
		} else {
			depTime = Integer.parseInt(airData[4]);
		}
	}

	public int getYear() {
		return this.year;
	}

	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getDepTime() {
		return this.depTime;
	}
	
}
