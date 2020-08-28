import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int week;
	
	public AirlineParser(Text value) {
		// TODO Auto-generated constructor stub
		String []airData = value.toString().split(",");
		year = Integer.parseInt(airData[0]);
		month = Integer.parseInt(airData[1]);
		week = Integer.parseInt(airData[3]);
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getWeek() {
		return this.week;
	}
}
