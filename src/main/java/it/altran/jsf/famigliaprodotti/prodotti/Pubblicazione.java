package it.altran.jsf.famigliaprodotti.prodotti;

import it.altran.jsf.famigliaprodotti.factory.Visitor;

public abstract class Pubblicazione {
	
	private String titolo;
	private String note;
	
	public abstract String accept(Visitor visitor);

	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	
}
