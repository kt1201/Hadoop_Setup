import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int depTime;
	private int day;
	
	public AirlineParser(Text value) {
		// TODO Auto-generated constructor stub
		String []airData = value.toString().split(",");
		year = Integer.parseInt(airData[0]);
		month = Integer.parseInt(airData[1]);
		if("NA".equals(airData[4])) {
			depTime = -1;
		} else {
			depTime = Integer.parseInt(airData[4]);
		}
		day = Integer.parseInt(airData[2]);
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDepTime() {
		return this.depTime;
	}
	
	public int getDay() {
		return this.day;
	}
}
