import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements
	Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	public void map(LongWritable key, Text value, 
	OutputCollector<Text, IntWritable> output, Reporter reporter)
	throws IOException {
		// TODO Auto-generated method stub
		AirlineParser ap = new AirlineParser(value);
		
		if (ap.getDepTime() !=  -1) {
//			String day = String.format("%02d¿œ", ap.getDay());
			
			/*
			 * 1-1 ~ 10-1 / 10 = 0
			 * 11 ~ 20 / 10 = 1
			 * 21 ~ 30 / 10 = 2
			 * 30 ~ 31 / 10 = 3
			 */
			int day = (ap.getDay()-1) / 10;
			if(day == 3) {
				day = 2;
			}
			output.collect(new Text(String.valueOf(day)), new IntWritable(1));
		}
	}
}








