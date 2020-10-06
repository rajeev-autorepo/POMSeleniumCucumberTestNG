package util;

public class Singleton{
	private static Singleton singleton = new Singleton();
	private String customerID;
	private String firstValueInGrid;
	private String lastValueInGrid;
	
	private Singleton() {

	}
	
	/* Static 'instance' method */
	public static Singleton getInstance() {
		return singleton;

	}

    public void setCustomerID(String customerid)
	{
		this.customerID=customerid;
	}
	
	public String getCustomerID(){
		
		return customerID;
	}
	
	public void setFirstValueInGrid(String monthly)
	{
		this.firstValueInGrid=monthly;
	}
		
	public String getFirstValueInGrid(){
			
		return firstValueInGrid;
	}
	
	public void setLastValueInGrid(String lastvalue)
	{
		this.lastValueInGrid=lastvalue;
	}
		
	public String getLastValueInGrid(){
			
		return lastValueInGrid;
	}	
	
	
	
	
	
	
	

}
