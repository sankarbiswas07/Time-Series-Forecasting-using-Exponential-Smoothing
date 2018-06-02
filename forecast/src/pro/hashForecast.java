package pro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
//import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class hashForecast
{
	public static void main(String[] args) throws IOException
	{
		HashMap<String,Double> be = new HashMap<String,Double>();
			String line;
			BufferedReader br=new BufferedReader(new FileReader("part-r-00000"));
			while ((line = br.readLine()) != null) 
			{
				
				String val[]=line.split("\t");
				String rec[]=val[0].split(",");
							
					if(rec[1].equals("Benzene"))
						be.put(rec[0], new Double(val[1]));
			}
			PrintWriter Benzene=new PrintWriter(new FileWriter("BenzeneFile"));
														/* for(Map.Entry<String, Double> b:be.entrySet()) 
														 {
															 Benzene.println(b.getKey()+"		"+b.getValue());
															   //System.out.println(b.getKey()+" 	"+b.getValue()); 
														 } 
														Benzene.close();	*/
			
			
							// Now let's sort HashMap by keys first 
					        // all you need to do is create a TreeMap with mappings of HashMap
					        // TreeMap keeps all entries in sorted order
			
	        TreeMap<String, Double> sorted = new TreeMap<>(be);
	        Set<Entry<String, Double>> mappings = sorted.entrySet();
	        
	        for(Entry<String, Double> mapping : mappings)
	        {
	            Benzene.println(mapping.getKey() + " ==> " + mapping.getValue());
	        }

	        Benzene.close();		
			br.close();
			
	}
}


	