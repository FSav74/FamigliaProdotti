package it.altran.jsf.famigliaprodotti.factory;


public class FactoryCreationException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7373744754135110586L;

	public FactoryCreationException() {
		
		super();
	}

	public FactoryCreationException(String message) {
		
		super(message);
	}
	


	public FactoryCreationException(Throwable cause) {
		
		super(cause);
	}
	
	public FactoryCreationException(String message, Throwable cause) {
		
		super(message, cause);
	}

}

