package it.altran.jsf.famigliaprodotti.prodotti;

import it.altran.jsf.famigliaprodotti.factory.Visitor;

import java.io.Serializable;

public class Libro extends Pubblicazione implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8226198014004417293L;
	
	private String isbn;
	
	public String accept(Visitor visitor){
		return visitor.visit(this);
	}
	
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	

}
