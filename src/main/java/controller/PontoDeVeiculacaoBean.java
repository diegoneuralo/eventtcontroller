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

import model.entity.ContratoPontoDeVeiculacao;
import model.entity.Franquia;
import model.entity.PontoDeVeiculacao;
import model.service.interfaces.IPontoDeVeiculacaoService;

/**
 * Managed Bean que gerencia as páginas de Cadastrar e Visualizar Pontos de Veiculação
 * @author Igor Venturelli
 */
@Named
@ViewScoped
public class PontoDeVeiculacaoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos utilizados na view
	private List<PontoDeVeiculacao> pontosDeVeiculacao; //método set modificado
	private PontoDeVeiculacao pontoDeVeiculacao;
	//Atributos utilizados na view
	
	//Atrbutos utilizados internamente
	private int idFranquia; //método set modificado
	@Inject
	private IPontoDeVeiculacaoService pontoDeVeiculacaoService;
	private FacesContext contexto;
	private ExternalContext externo;
	//Atrbutos utilizados internamente
	
	/***
	 * Construtor da Classe. Inicializa os atributos
	 */
	public PontoDeVeiculacaoBean(){
		
		this.pontoDeVeiculacao = new PontoDeVeiculacao();
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
		
		
		//pontosDeVeiculacao
		this.pontosDeVeiculacao = pontoDeVeiculacaoService.showAll(idFranquia);
		//pontosDeVeiculacao
	}
	
	/**
	 * Método responsável por adicionar um novo Ponto de Veiculação
	 * @param pdv
	 */
	public void add(){
		
		if(!isValidDate(pontoDeVeiculacao.getContrato())){
			
			//Mensagem de data errada
			contexto.addMessage(null, new FacesMessage("Data errada", 
					"A data de término do contrato não pode ser menor que a data de início deste."));
			
			return;
		}
		
		//Seta o id da franquia logada no ponto de veiculacao
		pontoDeVeiculacao.setIdFranquia(idFranquia);
		
		//Seta o id da franquia logada no contrato do ponto de veiculacao
		ContratoPontoDeVeiculacao contrato = new ContratoPontoDeVeiculacao();
		contrato = pontoDeVeiculacao.getContrato();
		contrato.setIdFranquia(idFranquia);
		pontoDeVeiculacao.setContrato(contrato);
		
		//Tenta adicionar
		try{
		
			pontoDeVeiculacaoService.add(pontoDeVeiculacao);
		
			//Mensagem sucesso
			contexto.addMessage(null, new FacesMessage("Sucesso!", 
					"Ponto de Veiculação cadastrado com sucesso."));
		
			//Redireciona para a página de visualizar Anunciantes
			externo.redirect("/.../.../jsf/pontoDeVeiculacao/visualizarPontoDeVeiculacao.jsf");
		
		//Se der erro...
		} catch(Exception e){
		
			//Mensagem erro
			contexto.addMessage(null, new FacesMessage("Ops!", 
					"Erro ao cadastrar ponto de veiculação. Favor contatar o Help Desk através do e-mail helpdesk@funaction.com.br."));
			
			//Redireciona para a página index
			try {
				
				externo.redirect("/.../.../index.jsf");
				
			} catch (IOException ioE) { }
		}
	}
	
	/**
	 * Método responsável por exibir os detalhes um único Ponto de Veiculação
	 * @param idPontoDeVeiculacao
	 * @return
	 */
	public void showDetail(int idPontoDeVeiculacao){
		
		//Busca as informações do ponto de veiculacao através do id deste
		pontoDeVeiculacao = pontoDeVeiculacaoService.showDetail(idPontoDeVeiculacao);
	}
	
	/**
	 * Método responsável por verificar se a data de término é maior que a data inicial do contrato
	 * @param contrato
	 * @return
	 */
	private Boolean isValidDate(ContratoPontoDeVeiculacao contrato){
		
		//Compara as datas. Se as datas estiverem erradas retorna falso, senão verdadeiro
		if(contrato.getDataTerminoContrato().before(contrato.getDataInicioContrato())){
			
			return false;
			
		} else {
			
			return true;
		}
	}

	//Getters and Setters
	public List<PontoDeVeiculacao> getPontosDeVeiculacao() {
		return pontosDeVeiculacao;
	}

	public void setPontosDeVeiculacao(List<PontoDeVeiculacao> pontosDeVeiculacao) {
		this.pontosDeVeiculacao = pontosDeVeiculacao;
	}
	
	public PontoDeVeiculacao getPontoDeVeiculacao() {
		return pontoDeVeiculacao;
	}

	public void setPontoDeVeiculacao(PontoDeVeiculacao pontoDeVeiculacao) {
		this.pontoDeVeiculacao = pontoDeVeiculacao;
	}
}
