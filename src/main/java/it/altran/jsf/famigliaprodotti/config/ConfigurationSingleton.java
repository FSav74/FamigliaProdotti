package it.altran.jsf.famigliaprodotti.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;



public enum ConfigurationSingleton {

	INSTANCE;

	private Properties prop;
	private String LOG4JXML = "LOG4JXML";
	private String CLASSFILE = "CLASSFILE";
	private HashMap<String, String> tabellaClassi = new HashMap<>();
	private HashMap<String, String> tabellaMappingClassi = new HashMap<>();
	private ConfigurationSingleton(){
		//Constructor
		
		String path = System.getProperty("famigliaprodotti.pathfile");
		if (path==null){
			System.out.println("Configurare la jvm variabile famigliaprodotti.pathfile con il file di properties!");
			System.out.println("     es:.  -Dfamigliaprodotti.pathfile=C:\\software\\CONFIGURAZIONI-PROGETTI\\famigliaprodotti\\famigliaprodotti.properties");
			System.exit(-1);
			//throw new RuntimeException("Configurare la jvm variabile famigliaprodotti.pathfile");
		}
		System.out.println("Caricamento file properties: "+path);
		InputStream input;
		try {
			input = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore caricamento file Properties.");
		}
		//------------------------------------------
		// load a properties file
		//------------------------------------------
		prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore caricamento delle Properties");
		}	
		//------------------------------------------
		// Configuration Log4j
		//------------------------------------------
		String log4jConfigFile = getProperty(LOG4JXML);
//        DOMConfigurator.configure(log4jConfigFile);


		caricaNomiClassi(getProperty(CLASSFILE));
	}
	public String getProperty(String property){
		
		if (  (property==null)||("".equals(property))  ) 
			System.out.println(">>>WARNING:richiesta una property null o vuota");
		
		String propertyValue = prop.getProperty(property);
		
		if (  (propertyValue==null)||("".equals(propertyValue))  ) 
			System.out.println(">>>WARNING:la property "+property+" non è presente nel file di properties");
		
		
		
		return propertyValue;	
	}

	
	
	
	private void caricaNomiClassi(String path){
		
		System.out.println("Caricamento file properties: "+path);
		InputStream input;
		try {
			input = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore caricamento file "+path);
		}
		//------------------------------------------
		// load a properties file
		//------------------------------------------
		prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore caricamento delle Properties");
		}	
		for(final String name : prop.stringPropertyNames()){
			tabellaClassi.put(name,name);
			tabellaMappingClassi.put(name,prop.getProperty(name));
		}
		
		
	}
	
	public HashMap<String, String> getLabel(){
		return tabellaClassi;
	}
	
	public HashMap<String, String> getMappingClass(){
		return tabellaMappingClassi;
	}
}

