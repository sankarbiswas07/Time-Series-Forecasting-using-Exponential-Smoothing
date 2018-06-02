package pro;

public class ExampleForCal 
{
	public static void main(String[] args) 
	{
		final double A=0.9; 							//default alpha value
		double[] Fr = new double[10]; 					// storing the Forecast result value 
		double[] Ac = {0.53, 1.04, 1.35, 0.62, 0.55};		//demo actual data
		double init =0.53;
	
			for(int i=0;i<5;i++) 
		    {
				if (Fr[0]==0.0) 
				{
					double temp = init + A * (Ac[i]- init);
					Fr[i]= temp;
				}
				else
				{

					double temp = Fr[i-1] + A * (Ac[i]- Fr[i-1]);
					Fr[i]= temp;
				}
		    }

		   for(int i=0;i<5;i++) 
		    {
		    	System.out.println("Forecast :" +Fr[i]);
		    } 
		  
	
	    
	}
}
