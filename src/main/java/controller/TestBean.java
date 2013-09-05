package controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.service.interfaces.IAnucianteService;
import model.service.interfaces.IContratoAnuncianteService;
import model.service.interfaces.IPontoDeVeiculacaoService;

@Named
@ViewScoped
public class TestBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IAnucianteService anucianteService;
	@Inject
	private IPontoDeVeiculacaoService pontoDeVeiculacaoService;
	@Inject
	private IContratoAnuncianteService contratoAnuncianteService;

}
