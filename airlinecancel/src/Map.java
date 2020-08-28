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
		
		if (ap.getDepTime() == -1) {
			String month = String.format("%02d¿ù", ap.getMonth());
		
			output.collect(new Text(ap.getYear()+"³â"+month), new IntWritable(1));
		}
	}
}








