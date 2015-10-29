package scheduling.entropyBased.entropy2;

import configuration.SimulatorProperties;
import scheduling.GeneralProperties;

import java.io.File;


//Represents properties mostly for DVMS instances (except for the logging property which is shared by DVMS instances and the simulator)
public class EntropyProperties extends GeneralProperties {
	/**
	 * 
	 */
	
	public double getPropertyAsDouble(String key, double defaultValue) {
		double result = 0;
		
		try {
			result = Double.parseDouble(INSTANCE.getProperty(key, defaultValue+""));
		}
		catch(Exception e) {
			
		}
		
		
		return result;
	}
	
	private static final long serialVersionUID = 7229931356566105645L;
	
	//Default location of the properties file
	public static final String DEFAULT_PROP_FILE = "config" + File.separator + "entropy.properties";
	
	//Singleton
	public final static EntropyProperties INSTANCE = new EntropyProperties();
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Property keys
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public final static String ENTROPY_TIME_OUT = "controlLoop.custom.planTimeout";
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Property default values
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public final static int DEFAULT_ENTROPY_TIME_OUT = 300;
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Properties currently not stored in the properties file
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Constructors
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public EntropyProperties(String file) {
		super(file);
	}
	
	public EntropyProperties() {
		this(DEFAULT_PROP_FILE);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Class methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	public static int getEntropyPlanTimeout(){
		return Math.max(1, SimulatorProperties.getNbOfHostingNodes()/4);
		//return INSTANCE.getPropertyAsInt(ENTROPY_TIME_OUT, DEFAULT_ENTROPY_TIME_OUT);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Methods for properties currently not stored in the properties file
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Other methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args){
		System.out.println(EntropyProperties.INSTANCE);
	}
}