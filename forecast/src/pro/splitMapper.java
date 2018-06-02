package pro;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class splitMapper extends Mapper<LongWritable,Text,CStype,Text>
{
	
	private CStype keyout=new CStype();
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException 
	{

		String rec = value.toString(); 
		String  f[] = rec.split(",");
		String a[]  = { "CO", "Benzene", "Ozone", "PM2.5" };		
			for(int j=0;j<a.length;j++)
			{
				
					keyout.set(f[0],a[j]);
					Text valueout= new Text(f[j+1]);				
					context.write(keyout,valueout);
		
			}

	}
}
