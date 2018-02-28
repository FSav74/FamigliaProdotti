package it.altran.jsf.famigliaprodotti.factory;

import it.altran.jsf.famigliaprodotti.prodotti.Pubblicazione;

public abstract class GenericFactory {
	
	abstract public Pubblicazione retrievePubblicazione(String searchParam) throws Exception;
	
}
