import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCount extends Configured implements Tool{
	
	@Override
	public int run(String[] args) throws Exception {

		JobConf conf = new JobConf(WordCount.class);
		conf.setJobName("wordcount");
		
		// Reducer 실행 후 결과 타입
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
		// Mapper와 Reducer 지정
		conf.setMapperClass(Map.class);
		conf.setReducerClass(Reduce.class);
		
		// 입출력 클래스 지정
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		
		// 입출력 파일 경로 지정
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		
		JobClient.runJob(conf); // 실행
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception{
		
		int exitcode = ToolRunner.run(new WordCount(), args);
		System.exit(exitcode);
	}

}
