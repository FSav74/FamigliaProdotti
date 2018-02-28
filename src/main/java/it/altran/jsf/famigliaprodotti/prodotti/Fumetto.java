package it.altran.jsf.famigliaprodotti.prodotti;

import it.altran.jsf.famigliaprodotti.factory.Visitor;

import java.io.Serializable;

public class Fumetto extends Pubblicazione implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 327190678371101328L;
	
	private String tipoPeriodicita;
	
	public String accept(Visitor visitor){
		return visitor.visit(this);
	}

	public String getTipoPeriodicita() {
		return tipoPeriodicita;
	}

	public void setTipoPeriodicita(String tipoPeriodicita) {
		this.tipoPeriodicita = tipoPeriodicita;
	}
	
	
}
