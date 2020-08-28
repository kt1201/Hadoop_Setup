import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce extends MapReduceBase implements
Reducer<Text, IntWritable, Text, IntWritable>{

	private Text getDays(String dayValue) {
		Text key = new Text();
		if("0".equals(dayValue)) {
			key.set("1 ~ 10");
		} else if("1".equals(dayValue)) {
			key.set("11 ~ 20");
		} else {
			key.set("21 ~ 31");
		}
		return key;
	}
	@Override
	public void reduce(Text key, Iterator<IntWritable> values, 
	OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		// TODO Auto-generated method stub

		int cnt = 0;
		while(values.hasNext()) {
			cnt += values.next().get();
		}
		output.collect(getDays(key.toString()), new IntWritable(cnt));
	}
}	








