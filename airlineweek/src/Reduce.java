import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce extends MapReduceBase implements
Reducer<IntWritable, IntWritable, Text, IntWritable>{

	private String getWeek(int idx) {
		switch(idx) {
		case 1:
			return "월 요 일";
		case 2:
			return "화 요 일";
		case 3:
			return "수 요 일";
		case 4:
			return "목 요 일";
		case 5:
			return "금 요 일";
		case 6:
			return "토 요 일";
		case 7:
			return "일 요 일";
		}
		return null;
	}
	@Override
	public void reduce(IntWritable key, Iterator<IntWritable> values, 
	OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		// TODO Auto-generated method stub
		int cnt = 0;
		while(values.hasNext()) {
			cnt += values.next().get();
		}
		output.collect(new Text(getWeek(key.get())), new IntWritable(cnt));
	}
}	








