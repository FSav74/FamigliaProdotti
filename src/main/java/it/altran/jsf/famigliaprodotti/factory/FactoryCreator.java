package it.altran.jsf.famigliaprodotti.factory;

import it.altran.jsf.famigliaprodotti.config.ConfigurationSingleton;

import java.util.HashMap;
import java.util.Map;

public class FactoryCreator {
	
	private Map<String, String> mappingClass = new HashMap<>();
	
	public FactoryCreator(){
		//TODO: Only for test
		//Now the hashMap is in the Configuration Singleton
//		mappingClass.put("RIVISTA","it.altran.jsf.famigliaprodotti.factory.RivistaFactory");
//		mappingClass.put("LIBRO","it.altran.jsf.famigliaprodotti.factory.LibroFactory");
//		mappingClass.put("FUMETTO","it.altran.jsf.famigliaprodotti.factory.FumettoFactory");
	}


	/**
	 * createFactory
	 * 
	 * Method to create factory
	 * @param typeClass a string which individutes the complete name of java class (mypackage.myname)
	 * @return          the object created by Reflection
	 */
	public GenericFactory createfactory(String name) throws FactoryCreationException{
		
		//Retrieve java class 
		String completeJavaClass = ConfigurationSingleton.INSTANCE.getMappingClass().get(name);
		
		//if not exist
		if(  (completeJavaClass==null)||("".equals(completeJavaClass)) )
			throw new FactoryCreationException("There is not Class Name corresponding to string:"+name+". Check Properties.");
		
		//else use reflection
		Class c = null;
		try {
			c = Class.forName( completeJavaClass );
		} catch (ClassNotFoundException e) {
			throw new FactoryCreationException( e );
		}
		
		Object obj = null;
		try {
			obj = c.newInstance();
		} catch (InstantiationException e) {
			throw new FactoryCreationException( e );
		} catch (IllegalAccessException e) {
			throw new FactoryCreationException( e );
		}
		
		if ( !(obj instanceof GenericFactory) ) {
			
			throw new FactoryCreationException("The provided class "+completeJavaClass+" must descend form " +
													" " + GenericFactory.class + ".");
		}
		
		return (GenericFactory)obj;
		
	}
	
}
