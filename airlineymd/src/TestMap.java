import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class TestMap extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		// TODO Auto-generated method stub
		AirlineParser ap = new AirlineParser(value);

		if (ap.getDepTime() > -1) {
//			String day =String.format("%02d", ap.getDay());
			
			int day = (ap.getDay()-1) / 10;
			if(day == 3) {
				day = 2;
			}

			output.collect(new Text(day + "¿œ"), new IntWritable(1));
		}
	}
}
