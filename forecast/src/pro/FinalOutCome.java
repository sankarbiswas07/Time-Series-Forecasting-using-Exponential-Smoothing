package pro;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FinalOutCome {

	public static void main(String[] args) throws IOException 
	{
        String output="";
        try(
        		Scanner sc1=new Scanner((new File("BenzeneFile")));
        		Scanner sc2=new Scanner((new File("COFile")));
        		Scanner sc3=new Scanner((new File("OzoneFile")));
        		Scanner sc4=new Scanner((new File("PM2.5File")));
        		Scanner sc5=new Scanner((new File("date2")))
        		//Scanner sc5=new Scanner((new File("date")))
        		)
        {
	        while( sc1.hasNext() || sc2.hasNext() || sc3.hasNext() || sc4.hasNext() || sc5.hasNext())
	        {
	            output+=sc5.next() +"\t\t\t\t\t\t"+sc1.next() +"\t\t\t"+ sc2.next()+"\t\t\t"+ sc3.next()+"\t\t\t"+ sc4.next();
	            output+="\n";
	        }
        
        
	        try(PrintWriter pw=new PrintWriter(new File("FinalForeCaste")))
	        {
	        pw.write("\t\t\t\t\t\t\t\t\t"+"Benzene"+"\t\t\t"+"CO"+"\t\t\t"+"Ozone"+"\t\t\t"+"PM2.5"+"\n");
	        pw.write(output);
	        }        

        }
        System.out.println("Forcaste data upto 2018 has been saved in FinalForeCaste");
	}

}