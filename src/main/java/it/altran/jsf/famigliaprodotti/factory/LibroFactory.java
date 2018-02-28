package it.altran.jsf.famigliaprodotti.factory;



import it.altran.jsf.famigliaprodotti.prodotti.Libro;
import it.altran.jsf.famigliaprodotti.prodotti.Pubblicazione;
import it.altran.jsf.famigliaprodotti.utility.Log;

public class LibroFactory extends GenericFactory{

	@Override
	public Pubblicazione retrievePubblicazione(String searchParam)
			throws Exception {
		
		Log log = new Log();
		log.info("LibroFactory - retrievePubblicazione");
		
		//TODO: parte di persistenza: chiamata al DAO
		
		//TODO: only for test 
		Libro libro = new Libro();
		libro.setIsbn("100020003000");
		libro.setTitolo(searchParam);
		libro.setNote("Prima edizione del 1980 con dedica dell'autore");
		return libro;
	}

}
