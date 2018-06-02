package pro;

import java.io.*;
import java.util.ArrayList;

public class ForeCast 
{
	public static void main(String[] args) throws IOException
	{
		for(int k=1;k<=44;k++)  //month details you want to forecast
		{
		 	final double A=0.1; 															//default alpha value
			String Bline,Cline,Oline,Pline;
			BufferedReader br=new BufferedReader(new FileReader("BenzeneFile"));
			BufferedReader co=new BufferedReader(new FileReader("COFile"));
			BufferedReader oz=new BufferedReader(new FileReader("OzoneFile"));
			BufferedReader Pmm=new BufferedReader(new FileReader("PM2.5File"));
			ArrayList<Double> Ben 	= new ArrayList<Double>();									//ArrayList declaration :Ben [Actual Benzene Value List ]
			ArrayList<Double> Co 	= new ArrayList<Double>();									//ArrayList declaration :Co [Actual Benzene Value List ]
			ArrayList<Double> Ozone = new ArrayList<Double>();									//ArrayList declaration :Ozone [Actual Benzene Value List ]
			ArrayList<Double> Pm 	= new ArrayList<Double>();									//ArrayList declaration :Pm [Actual Benzene Value List ]
			while((Bline = br.readLine()) != null)
			{	
				double Bvalue = Double.parseDouble(Bline);
				Ben.add(Bvalue);

			}
			while((Cline = co.readLine()) != null)
			{
				double Cvalue = Double.parseDouble(Cline);
				Co.add(Cvalue);
			}
			while((Oline = oz.readLine()) != null)
			{
				double Ovalue = Double.parseDouble(Oline);
				Ozone.add(Ovalue);
			}
			while((Pline = Pmm.readLine()) != null)
			{
				double Pvalue = Double.parseDouble(Pline);
				Pm.add(Pvalue);
			}
			
			/*________________________________________________________________________________________________*/
	        	double hold=0.0;
	        	double last = A * (Ben.get(Ben.size()-1));
	        	for (int i =1 ; i <= Ben.size(); i++)
	        	{
	        		double temp = A * Math.pow((1-A), i) * (Ben.get(Ben.size()-i))  ;
	        		hold = hold + temp;
	        		
	        		
	        	}
	        		hold = hold +last;
	        	    
	        	    try(FileWriter fw = new FileWriter("BenzeneFile", true);
	        	    	    BufferedWriter bw = new BufferedWriter(fw);
	        	    	    PrintWriter out = new PrintWriter(bw))
	        	    	{
	        	    	    out.println(hold);
	        	    	    
	        	    	    
	        	    	} catch (IOException e) {
	        	    	    															//exception handling left as an exercise for the reader
	        	    	}
	        	    System.out.println("BenzeneFile has been updated." +k +"times");
	        	    br.close();
	        /*________________________________________________________________________________________________*/
	        	    
		    /*________________________________________________________________________________________________*/
	    	double hold1=0.0;
	    	double last1 = A * (Co.get(Co.size()-1));
	    	for (int i =1 ; i <= Co.size(); i++)
	    	{
	    		double temp1 = A * Math.pow((1-A), i) * (Co.get(Co.size()-i))  ;
	    		hold1 = hold1 + temp1;
	    		
	    		
	    	}
	    		hold1 = hold1 +last1;
	    	    
	    	    try(FileWriter fw = new FileWriter("COFile", true);
	    	    	    BufferedWriter bw = new BufferedWriter(fw);
	    	    	    PrintWriter out = new PrintWriter(bw))
	    	    	{
	    	    	    out.println(hold1);
	    	    	    
	    	    	    
	    	    	} catch (IOException e) {
	    	    	    															//exception handling left as an exercise for the reader
	    	    	}
	    	    System.out.println("COFile has been updated." +k +"times");
	    	    co.close();
	    	    /*________________________________________________________________________________________________*/
	    	    /*________________________________________________________________________________________________*/
		    	double hold2=0.0;
		    	double last2 = A * (Ozone.get(Ozone.size()-1));
		    	for (int i =1 ; i <= Ozone.size(); i++)
		    	{
		    		double temp2 = A * Math.pow((1-A), i) * (Ozone.get(Ozone.size()-i))  ;
		    		hold2 = hold2 + temp2;
		    		
		    		
		    	}
		    		hold2 = hold2 +last2;
		    	    
		    	    try(FileWriter fw = new FileWriter("OzoneFile", true);
		    	    	    BufferedWriter bw = new BufferedWriter(fw);
		    	    	    PrintWriter out = new PrintWriter(bw))
		    	    	{
		    	    	    out.println(hold2);
		    	    	    
		    	    	    
		    	    	} catch (IOException e) {
		    	    	    															//exception handling left as an exercise for the reader
		    	    	}
		    	    System.out.println("OzoneFile has been updated." +k +"times");
		    	    oz.close();
		     /*________________________________________________________________________________________________*/
		    /*________________________________________________________________________________________________*/
	    	double hold3=0.0;
	    	double last3 = A * (Pm.get(Pm.size()-1));
	    	for (int i =1 ; i <= Pm.size(); i++)
	    	{
	    		double temp3 = A * Math.pow((1-A), i) * (Pm.get(Pm.size()-i))  ;
	    		hold3 = hold3 + temp3;
	    		
	    		
	    	}
	    		hold3 = hold3 +last3;
	    	    
	    	    try(FileWriter fw = new FileWriter("PM2.5File", true);
	    	    	    BufferedWriter bw = new BufferedWriter(fw);
	    	    	    PrintWriter out = new PrintWriter(bw))
	    	    	{
	    	    	    out.println(hold3);
	    	    	    
	    	    	    
	    	    	} catch (IOException e) {
	    	    	    															//exception handling left as an exercise for the reader
	    	    	}
	    	    System.out.println("PM2.5File has been updated." +k +"times");
	    	    Pmm.close();
	    	    /*________________________________________________________________________________________________*/
		}
	      
	}
	
}
