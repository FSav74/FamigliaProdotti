package it.altran.jsf.famigliaprodotti;

import java.util.HashMap;

import it.altran.jsf.famigliaprodotti.config.ConfigurationSingleton;
import it.altran.jsf.famigliaprodotti.factory.FactoryCreationException;
import it.altran.jsf.famigliaprodotti.factory.FactoryCreator;
import it.altran.jsf.famigliaprodotti.factory.GenericFactory;
import it.altran.jsf.famigliaprodotti.factory.Visitor;
import it.altran.jsf.famigliaprodotti.prodotti.Fumetto;
import it.altran.jsf.famigliaprodotti.prodotti.Libro;
import it.altran.jsf.famigliaprodotti.prodotti.Pubblicazione;
import it.altran.jsf.famigliaprodotti.utility.Log;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="productHandler")
@SessionScoped
public class ProductHandler implements Visitor{
	
	private String titolo;
	private String tipoPubblicazione;
	private Log log = new Log();
	
	
	private HashMap<String, String> labelsHashmap = null;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
	
	public String getTipoPubblicazione() {
		return tipoPubblicazione;
	}

	public void setTipoPubblicazione(String tipoPubblicazione) {
		this.tipoPubblicazione = tipoPubblicazione;
	}
	
	
	public void setLabelsHashmap(HashMap<String, String> labelsHashmap) {
		this.labelsHashmap = labelsHashmap;
	}

	public HashMap<String, String> getLabelsHashmap(){
//		HashMap<String, String> mylabelsHashmap = ConfigurationSingleton.INSTANCE.getLabel();
//		labelsHashmap = (HashMap<String, String>)mylabelsHashmap.clone();
//		return labelsHashmap;
		return ConfigurationSingleton.INSTANCE.getLabel();
	}

	public String search(){
		
		
		log.info("Start search...........");
		log.debug("titolo selezionato:"+titolo);
		log.debug("Tipo Pubblicazione selezionato:"+tipoPubblicazione);
		
		//-----------------------------
		//PATTERN:
		//-----------------------------
		//PROTOTYPE
		//ABSTRACT FACTORY
		//VISITOR
		//-----------------------------
		GenericFactory factory = null; 
		FactoryCreator creator = new FactoryCreator();
		try {
			factory = creator.createfactory(tipoPubblicazione);
		} catch (FactoryCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			request.setAttribute("errorPage", e.toString());
			return "pages/error";
		}
		
		Pubblicazione pubblicazione = null;
		try {
			pubblicazione = factory.retrievePubblicazione(titolo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			request.setAttribute("errorPage", e.toString());
			return "pages/error";
		}
		
		/*
		 * 
		 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("polizza",polizza);
	 	    return factory.getTipoPolizza()+".xhml";
		 */
		String url = pubblicazione.accept(this);
		return url;
		//return "pages/resultSearch";
		
	} 
	


	@Override
	public String visit(Libro p) {
		
		log.debug(">>>>>>Libro");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("libro",p);
		return "pages/resultSearchLibro";
	}

	@Override
	public String visit(Fumetto p) {
		log.debug(">>>>>>Fumetto");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("fumetto",p);
		return "pages/resultSearchFumetto";
	}

	@Override
	public String visit(Pubblicazione p) {
		log.debug(">>>>>>Pubblicazione generica");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("libro",p);
		return "pages/resultSearch";
	}

	
}
