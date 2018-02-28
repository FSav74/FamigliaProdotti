package it.altran.jsf.famigliaprodotti.factory;

import it.altran.jsf.famigliaprodotti.prodotti.Fumetto;
import it.altran.jsf.famigliaprodotti.prodotti.Libro;
import it.altran.jsf.famigliaprodotti.prodotti.Pubblicazione;

public interface Visitor {

	public String visit(Libro p);
	public String visit(Fumetto p);
	public String visit(Pubblicazione p);
}
