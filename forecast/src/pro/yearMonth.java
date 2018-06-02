package pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class yearMonth {

	public static void main(String[] args) throws FileNotFoundException 
	{
		String date="";
		String[] month= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		for(int i=2013;i<=2018;i++)
		{
			for(int j=0;j<12;j++)
			{
			date+=i+"-"+month[j]+"\n";
			}
			//System.out.println("");
		} 
		try(PrintWriter pw=new PrintWriter(new File("date")))
        {
        
        pw.write(date);
        }

	}

}
