package pro;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class CStype implements WritableComparable<CStype>
{
	private Text month=new Text();
	private Text gas=new Text();

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		month.readFields(in);
		gas.readFields(in);

	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		month.write(out);
		gas.write(out);
	}

	public int compareTo(CStype o) {
		// TODO Auto-generated method stub
		int c=month.compareTo(o.month);
		if(c==0)
		{
			c=gas.compareTo(o.gas);
		}
		
		return c;
	}
	
	@Override
	public int hashCode()
	{
		int a=month.hashCode();
		int c=gas.hashCode();
		int hc=a*31+c; //a+c , a*c
		return hc;
	}

	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append(month.toString()+","+gas.toString());
		
		String r=sb.toString();
		return r;
	}


	public void set(String month1, String gas1) 
	{
		month.set(month1);
		gas.set(gas1);
		
	}
	
	public void set(Text month1, Text gas1) 
	{
		month.set(month1);
		gas.set(gas1);
		
	}
	
}