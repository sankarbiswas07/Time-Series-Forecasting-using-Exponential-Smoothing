/* Using SIMPLE EXPONENTIAL SMOOTHING */
package pro;

import java.io.*;
import java.util.ArrayList;

public class ForeCast2 
{
	public static void main(String[] args) throws IOException
	{
		for(int k=1;k<=1;k++)  																	//month details you want to forecast
		{
			ArrayList<Double> FBen = new ArrayList<Double>();
			ArrayList<Double> FCo = new ArrayList<Double>();
			ArrayList<Double> FOzone = new ArrayList<Double>();
			ArrayList<Double> FPm = new ArrayList<Double>();
		
		 	final double A=0.1;  																//default alpha value
		 	double temp=0.0;															
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
			/*_______________________________________________________________*/
			
				double initBen =Ben.get(0);																						        	       	
				for (int i = 0; i < Ben.size(); i++)
				{
					if (FBen.isEmpty())
					{
						temp = initBen + A * (Ben.get(i)- initBen);
						FBen.add(temp);
					}
					else
					{
						temp = FBen.get(i-1) + A * (Ben.get(i)- FBen.get(i-1));
						FBen.add(temp);
					}
				} 
				/*for(double a:FBen) 
				{
					System.out.println(a);
				}*/
				try(FileWriter fw = new FileWriter("BenzeneFile", true);
        	    	    BufferedWriter bw = new BufferedWriter(fw);
        	    	    PrintWriter out = new PrintWriter(bw))
        	    	{
        	    	    out.println(temp);
        	    	    
        	    	    
        	    	} 
				catch (IOException e) {}
				System.out.println("BenzeneFile has been updated." +k +"times");
        	    br.close();
        	    /*_______________________________________________________________*/
        	    /*_______________________________________________________________*/
    			
				double initCo =Co.get(0);																						        	       	
				for (int i = 0; i < Co.size(); i++)
				{
					if (FCo.isEmpty())
					{
						temp = initCo + A * (Co.get(i)- initCo);
						FCo.add(temp);
					}
					else
					{
						temp = FCo.get(i-1) + A * (Co.get(i)- FCo.get(i-1));
						FCo.add(temp);
					}
				} 
				/*for(double a:FCo) 
				{
					System.out.println(a);
				}*/
				try(FileWriter fw = new FileWriter("COFile", true);
        	    	    BufferedWriter bw = new BufferedWriter(fw);
        	    	    PrintWriter out = new PrintWriter(bw))
        	    	{
        	    	    out.println(temp);
        	    	    
        	    	    
        	    	} 
				catch (IOException e) {}
				System.out.println("COFile has been updated." +k +"times");
        	    co.close();
        	 /*_______________________________________________________________*/
        	 /*_______________________________________________________________*/
    			
				double initOz =Ozone.get(0);																						        	       	
				for (int i = 0; i < Ozone.size(); i++)
				{
					if (FOzone.isEmpty())
					{
						temp = initOz + A * (Ozone.get(i)- initOz);
						FOzone.add(temp);
					}
					else
					{
						temp = FOzone.get(i-1) + A * (Ozone.get(i)- FOzone.get(i-1));
						FOzone.add(temp);
					}
				} 
				/*for(double a:FOzone) 
				{
					System.out.println(a);
				}*/
				try(FileWriter fw = new FileWriter("OzoneFile", true);
        	    	    BufferedWriter bw = new BufferedWriter(fw);
        	    	    PrintWriter out = new PrintWriter(bw))
        	    	{
        	    	    out.println(temp);
        	    	    
        	    	    
        	    	} 
				catch (IOException e) {}
				System.out.println("OzoneFile has been updated." +k +"times");
        	    oz.close();
        	 /*_______________________________________________________________*/
        	 /*_______________________________________________________________*/
    			
				double initPm =Pm.get(0);																						        	       	
				for (int i = 0; i < Pm.size(); i++)
				{
					if (FPm.isEmpty())
					{
						temp = initPm + A * (Pm.get(i)- initPm);
						FPm.add(temp);
					}
					else
					{
						temp = FPm.get(i-1) + A * (Pm.get(i)- FPm.get(i-1));
						FPm.add(temp);
					}
				} 
				/*for(double a:FPm) 
				{
					System.out.println(a);
				}*/
				try(FileWriter fw = new FileWriter("PM2.5File", true);
        	    	    BufferedWriter bw = new BufferedWriter(fw);
        	    	    PrintWriter out = new PrintWriter(bw))
        	    	{
        	    	    out.println(temp);
        	    	    
        	    	    
        	    	} 
				catch (IOException e) {}
				System.out.println("PM2.5File has been updated." +k +"times");
        	    Pmm.close();
        	 /*_______________________________________________________________*/
		}
	      
	}
	
}
