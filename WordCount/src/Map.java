import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException{
		
		StringTokenizer st = new StringTokenizer(value.toString().toLowerCase()); // 값으로 들어오는 문자들을 모두 소문자로 변환(Splitting)
		
		while(st.hasMoreTokens()) {  // 다음이 있는지
			output.collect(new Text(st.nextToken()), new IntWritable(1)); // st.nextToken으로 단어 별로 잘라 1과 함께 output(Mapping)
		}
	}
}