package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.entity.Anunciante;
import model.entity.ContratoAnunciante;
import model.entity.Franquia;
import model.service.interfaces.IAnucianteService;

/**
 * Managed Bean que gerencia as páginas de Cadastrar e Visualizar Anunciantes
 * @author Igor Venturelli
 */
@Named
@ViewScoped
public class AnuncianteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos utilizados na view
	private List<Anunciante> anunciantes;
	private Anunciante anunciante;
	//Atributos utilizados na view
	
	//Atrbutos utilizados internamente
	private int idFranquia;
	@Inject
	private IAnucianteService anucianteService;
	private FacesContext contexto;
	private ExternalContext externo;
	//Atrbutos utilizados internamente
	
	/***
	 * Construtor da Classe. Inicializa os atributos
	 */
	public AnuncianteBean(){
		
		this.anunciante = new Anunciante();
		this.contexto = FacesContext.getCurrentInstance();
		this.externo = contexto.getExternalContext();
		
	}
	
	/***
	 * Método que será executado após construção da página.
	 * Carrega todas as informações que serão exibidas na página
	 */
	@PostConstruct
	public void init(){
		
		//idFranquia
		Franquia franquia = new Franquia();
		franquia = (Franquia) contexto.getExternalContext().getSessionMap().get("franquia");
		
		this.idFranquia = franquia.getId();
		//idFranquia
		
		
		//anunciantes
		this.anunciantes = anucianteService.showAll(idFranquia);
		//anunciantes
	}
	
	/**
	 * Método responsável por adicionar um novo Anunciante
	 * @param anunciante
	 */
	public void add(){
		
		//Verifica se a data está correta (dataFinal > dataInicial)
		if(!isValidDate(anunciante.getContrato())){
			
			//Mensagem de data errada
			contexto.addMessage(null, new FacesMessage("Data errada", 
					"A data de término do contrato não pode ser menor que a data de início deste."));
			
			return;
		}
		
		//Seta o id da franquia logada no anunciante
		anunciante.setIdFranquia(idFranquia);
		
		//Seta o id da franquia logada no contrato do anunciante
		ContratoAnunciante contrato = new ContratoAnunciante();
		contrato = anunciante.getContrato();
		contrato.setIdFranquia(idFranquia);
		anunciante.setContrato(contrato);
		
		//Tenta adicionar
		try{
		
			anucianteService.add(anunciante);
		
			//Mensagem de sucesso
			contexto.addMessage(null, new FacesMessage("Sucesso!", 
					"Anunciante cadastrado com sucesso."));
		
			//Redireciona para a página de visualizar Anunciantes
			externo.redirect("/.../.../jsf/anunciante/visualizarAnunciante.jsf");
		
		//Se der erro...
		} catch(Exception e){
		
			//Mensagem erro
			contexto.addMessage(null, new FacesMessage("Ops!", 
					"Erro ao cadastrar anunciante. Favor contatar o Help Desk através do e-mail helpdesk@funaction.com.br."));
			
			//Redireciona para a página index
			try {
				
				externo.redirect("/.../.../index.jsf");
				
			} catch (IOException ioE) { }
		}
	}
	
	/**
	 * Método responsável por exibir os detalhes um único Anunciante
	 * @param idPontoDeVeiculacao
	 */
	public void showDetail(int idAnunciante){
		
		//Busca as informações do anunciante através do id deste
		anunciante = anucianteService.showDetail(idAnunciante);
	}
	
	/**
	 * Método responsável por verificar se a data de término é maior que a data inicial do contrato
	 * @param contrato
	 */
	private Boolean isValidDate(ContratoAnunciante contrato){
		
		//Compara as datas. Se as datas estiverem erradas retorna falso, senão verdadeiro
		if(contrato.getDataTerminoContrato().before(contrato.getDataInicioContrato())){
			
			return false;
			
		} else {
			
			return true;
		}
	}

	//Getters and Setters
	public List<Anunciante> getAnunciantes() {
		return anunciantes;
	}

	public void setAnunciantes(List<Anunciante> anunciantes) {
		this.anunciantes = anunciantes;
	}
	
	public Anunciante getAnunciante() {
		return anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}
}
