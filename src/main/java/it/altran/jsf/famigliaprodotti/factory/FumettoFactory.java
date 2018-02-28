package it.altran.jsf.famigliaprodotti.factory;

import it.altran.jsf.famigliaprodotti.prodotti.Fumetto;
import it.altran.jsf.famigliaprodotti.prodotti.Pubblicazione;
import it.altran.jsf.famigliaprodotti.utility.Log;

public class FumettoFactory extends GenericFactory{

	@Override
	public Pubblicazione retrievePubblicazione(String searchParam)
			throws Exception {
		
		Log log = new Log();
		log.info(this.getClass()+" - retrievePubblicazione");
		
		//TODO: only for test
		Fumetto fumetto = new Fumetto();
		fumetto.setTitolo(searchParam);
		fumetto.setTipoPeriodicita("SETTIMANALE");
		fumetto.setNote("Primo numero con un nuovo copertinista.");
		
		
		
		return fumetto;
	}

}
