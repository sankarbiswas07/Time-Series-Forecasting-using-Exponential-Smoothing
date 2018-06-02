package pro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMasterFile
{
	public static void main(String[] args) throws IOException
	{
		String line;
		BufferedReader br=new BufferedReader(new FileReader("part-r-00000"));

			HashMap<String,Double> be = new HashMap<String,Double>();		// benzene hashMap
			HashMap<String,Double> co = new HashMap<String,Double>();		// co hashMap
			HashMap<String,Double> oz = new HashMap<String,Double>();		// ozone hashMap
			HashMap<String,Double> pm = new HashMap<String,Double>();		// pm2.5 hashMap
			
			 ArrayList<Double> Ben = new ArrayList<Double>();				//ArrayList declaration :Ben [Actual Benzene Value List ]
			 ArrayList<Double> Co = new ArrayList<Double>();
			 ArrayList<Double> Ozo = new ArrayList<Double>();
			 ArrayList<Double> Pm = new ArrayList<Double>();


			
			while ((line = br.readLine()) != null) 
			{
				
				String val[]=line.split("\t");
				String rec[]=val[0].split(",");
							
					if(rec[1].equals("Benzene"))
						be.put(rec[0], new Double(val[1]));
					else if(rec[1].equals("CO"))
						co.put(rec[0], new Double(val[1]));
					else if(rec[1].equals("Ozone"))
						oz.put(rec[0], new Double(val[1]));
					else if(rec[1].equals("PM2.5"))
						pm.put(rec[0], new Double(val[1]));
			}

	        TreeMap<String, Double> sortedBen = new TreeMap<>(be);
	        Set<Entry<String, Double>> benzene = sortedBen.entrySet();
	        
	        for(Entry<String, Double> mapping : benzene)
	        {					
	              Ben.add(mapping.getValue());	// add elements to the array list
	        }
	        
	        TreeMap<String, Double> sortedCo = new TreeMap<>(co);
	        Set<Entry<String, Double>> Coo = sortedCo.entrySet();
	        
	        for(Entry<String, Double> mapping : Coo)
	        {     																								
	              Co.add(mapping.getValue());	// add elements to the array list
	        }
	        
	        TreeMap<String, Double> sortedOz = new TreeMap<>(oz);
	        Set<Entry<String, Double>> Ozone = sortedOz.entrySet();
	        
	        for(Entry<String, Double> mapping : Ozone)
	        {																						
	              Ozo.add(mapping.getValue());	// add elements to the array list
	        }
	        
	        TreeMap<String, Double> sortedPm = new TreeMap<>(pm);
	        Set<Entry<String, Double>> Pmm = sortedPm.entrySet();
	        
	        for(Entry<String, Double> mapping : Pmm)
	        {																						
	              Pm.add(mapping.getValue());	// add elements to the array list
	        }

		      PrintWriter Benzene=new PrintWriter(new FileWriter("BenzeneFile"));  //Entry in Benzene File
		      for (Double file : Ben) {
		    	  Benzene.println(file);
		    	}	
		      System.out.println("Benzene		file successfully created");
		      Benzene.close();
		      
		      PrintWriter CO=new PrintWriter(new FileWriter("COFile"));	//Entry in CO File
		      for (Double file : Co) {
		    	  CO.println(file);
		    	}	
		      System.out.println("CO		file successfully created");
		      CO.close();
		      
		      PrintWriter Ozonee=new PrintWriter(new FileWriter("OzoneFile"));	//Entry in Ozone File
		      for (Double file : Ozo) {
		    	  Ozonee.println(file);
		    	}	
		      System.out.println("Ozone		file successfully created");
		      Ozonee.close();
		      
		      PrintWriter PMm=new PrintWriter(new FileWriter("PM2.5File"));	//Entry in PM2.5 File
		      for (Double file : Pm) {
		    	  PMm.println(file);
		    	}	
		      PMm.close();
		      System.out.println("PM2.5		file successfully created");
		      br.close();
	        
			
	}
}


	