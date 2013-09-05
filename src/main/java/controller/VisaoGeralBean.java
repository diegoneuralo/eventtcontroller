package controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import model.entity.Franquia;
import model.entity.PontoDeVeiculacao;
import model.service.interfaces.IContratoAnuncianteService;
import model.service.interfaces.IPontoDeVeiculacaoService;

/***
 * Classe que exibe os dados da página visaoGeral
 * @author igorventurelli
 */
@Named
@ViewScoped
public class VisaoGeralBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos utilizados na view
	private List<PontoDeVeiculacao> pontosDeVeiculacao;
	private int qtdContrato;
	private double recebimento;
	private double pagamento;
	private String nomeMesAtual;
	private int qtdEspacoVazioMesAtual;
	private CartesianChartModel grafico;
	//Atributos utilizados na view
	
	//Atrbutos utilizados internamente
	private int idFranquia;
	private final int qtdEspacoVazio = 25;
	@Inject
	private IPontoDeVeiculacaoService pontoDeVeiculacaoService;
	@Inject
	private IContratoAnuncianteService contratoAnuncianteService;
	private Calendar calendario;
	private int mes;
	private int ano;
	private FacesContext contexto;
	//Atrbutos utilizados internamente
	
	/***
	 * Construtor da Classe. Inicializa os atributos
	 */
	public VisaoGeralBean(){
		this.calendario = Calendar.getInstance();
		
		//Recebe a data atual
		calendario.setTime(new Date());
		this.mes = (calendario.get(Calendar.MONTH) + 1); //janeiro = 0 então add mais um
		this.ano = calendario.get(Calendar.YEAR);
		
		this.grafico = new CartesianChartModel();
		
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
		
		
		//qtdContrato
		this.qtdContrato = contratoAnuncianteService.totalContratoPorMes(mes, idFranquia);
		//qtdContrato
		
		
		//recebimento
		this.recebimento = contratoAnuncianteService.totalRecebimentoPorMes(mes, idFranquia);
		//recebimento
		
		
		//pagamento
		this.pagamento = contratoAnuncianteService.totalPagamentoPorMes(mes, idFranquia);
		//pagamento
		
		
		//nomeMesAtual
		switch(mes){
			
			case 1:
				this.nomeMesAtual = "Janeiro";
				break;
				
			case 2:
				this.nomeMesAtual = "Fevereiro";
				break;
				
			case 3:
				this.nomeMesAtual = "Março";
				break;
				
			case 4:
				this.nomeMesAtual = "Abril";
				break;
				
			case 5:
				this.nomeMesAtual = "Maio";
				break;
				
			case 6:
				this.nomeMesAtual = "Junho";
				break;
				
			case 7:
				this.nomeMesAtual = "Julho";
				break;
				
			case 8:
				this.nomeMesAtual = "Agosto";
				break;
				
			case 9:
				this.nomeMesAtual = "Setembro";
				break;
				
			case 10:
				this.nomeMesAtual = "Outubro";
				break;
				
			case 11:
				this.nomeMesAtual = "Novembro";
				break;
				
			case 12:
				this.nomeMesAtual = "Dezembro";
				break;
		}
		//nomeMesAtual
		
		
		//qtdEspacoVazioMesAtual
		this.qtdEspacoVazioMesAtual = (qtdContrato * qtdEspacoVazio);
		//qtdEspacoVazioMesAtual
		
		
		//grafico
		//Cria a linha de recebimentos no gráfico
		ChartSeries recebimentos = new ChartSeries();
		recebimentos.setLabel("Recebimentos");
		
		//Projeção para os próximos seis meses
		for (int i = 0; i < 6; i++) {
			
			//Faz a verificação para não ter mês 13, por exemplo e ano + 1
			int mes = this.mes + i;
			int ano = this.ano;
			if(mes > 12){
				
				mes = mes - 12;
				ano = ano + 1;
			}
			
			//Adiciona um ponto na linha do gráfico
			recebimentos.set(nomeMesAtual + "/" + ano, contratoAnuncianteService.totalRecebimentoPorMes((mes + i), idFranquia));
		}
		
		//Cria a linha de pagamentos no gráfico
		ChartSeries pagamentos = new ChartSeries();
		pagamentos.setLabel("Pagamentos");
		
		//Projeção para os próximos seis meses
		for (int i = 0; i < 6; i++) {
			
			//Faz a verificação para não ter mês 13, por exemplo e ano + 1
			int mes = this.mes + i;
			int ano = this.ano;
			if(mes > 12){
				
				mes = mes - 12;
				ano = ano + 1;
			}
			
			//Adiciona um ponto na linha do gráfico
			pagamentos.set(nomeMesAtual + "/" + ano, contratoAnuncianteService.totalPagamentoPorMes((mes + i), idFranquia));
		}
		
		grafico.addSeries(recebimentos);
		grafico.addSeries(pagamentos);
		//grafico
	}

	public List<PontoDeVeiculacao> getPontosDeVeiculacao() {
		return pontosDeVeiculacao;
	}

	public void setPontosDeVeiculacao(List<PontoDeVeiculacao> pontosDeVeiculacao) {
		this.pontosDeVeiculacao = pontosDeVeiculacao;
	}

	public int getQtdContrato() {
		return qtdContrato;
	}

	public void setQtdContrato(int qtdContrato) {
		this.qtdContrato = qtdContrato;
	}

	public double getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(double recebimento) {
		this.recebimento = recebimento;
	}

	public double getPagamento() {
		return pagamento;
	}

	public void setPagamento(double pagamento) {
		this.pagamento = pagamento;
	}

	public String getNomeMesAtual() {
		return nomeMesAtual;
	}

	public void setNomeMesAtual(String nomeMesAtual) {
		this.nomeMesAtual = nomeMesAtual;
	}

	public int getQtdEspacoVazioMesAtual() {
		return qtdEspacoVazioMesAtual;
	}

	public void setQtdEspacoVazioMesAtual(int qtdEspacoVazioMesAtual) {
		this.qtdEspacoVazioMesAtual = qtdEspacoVazioMesAtual;
	}

	public CartesianChartModel getGrafico() {
		return grafico;
	}

	public void setGrafico(CartesianChartModel grafico) {
		this.grafico = grafico;
	}
}
