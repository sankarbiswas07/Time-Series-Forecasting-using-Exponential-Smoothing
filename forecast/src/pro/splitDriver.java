package pro;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class splitDriver 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	{
		
		Configuration conf = new Configuration();
		Job j = Job.getInstance(conf,"composite");
		
		j.setJarByClass(splitDriver.class);		
		j.setMapperClass(splitMapper.class);
				
		j.setOutputKeyClass(CStype.class);
		j.setOutputValueClass(Text.class);

		FileInputFormat.addInputPath(j, new Path("/user/hduser/Original_kolkata.csv"));
		FileOutputFormat.setOutputPath(j, new Path("SplitOne"));
		
		j.waitForCompletion(true);
	}
}
