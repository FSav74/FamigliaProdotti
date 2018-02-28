package it.altran.jsf.famigliaprodotti.utility;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Log {
	
	
	public void debug(Object obj) {
		System.out.println(obj);
	}
	
	public void debug(Object obj, Throwable t) {
		System.out.println(obj+":"+t.getMessage());
		
	}
		
	public void info(Object obj) {
		System.out.println(obj);
		
	}
	
	public void info(Object obj, Throwable t) {
		System.out.println(obj+":"+t.getMessage());
		
	}
	public void error(Object obj) {
		System.out.println(obj);
		
	}
	
	public void error(Object obj, Throwable t) {
		System.out.println(obj+":"+t.toString());
		
	}
	public void printStack(Throwable e){
	      StringWriter stringW = new StringWriter();
	      PrintWriter printW = new PrintWriter(stringW);
	      e.printStackTrace(printW);    
	      String stackTrace = stringW.toString();
	      
	      System.out.println(stackTrace );
	  }

}
