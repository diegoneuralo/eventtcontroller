package model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "eventt_controller")
public class ContratoPontoDeVeiculacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column
	private int idPontoDeVeiculacao;
	@Column
	private Date dataInicioContrato;
	@Column
	private Date dataTerminoContrato;
	@Column
	private int diaVencimento;
	@Column
	private FormaPagamento formaPagamento;
	@Column
	private double valorPagamentoFixoEAcumulativo;
	@Column
	private int valorPagamentoPermuta;
	@Column
	private int idFranquia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPontoDeVeiculacao() {
		return idPontoDeVeiculacao;
	}
	public void setIdPontoDeVeiculacao(int idPontoDeVeiculacao) {
		this.idPontoDeVeiculacao = idPontoDeVeiculacao;
	}
	public Date getDataInicioContrato() {
		return dataInicioContrato;
	}
	public void setDataInicioContrato(Date dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}
	public Date getDataTerminoContrato() {
		return dataTerminoContrato;
	}
	public void setDataTerminoContrato(Date dataTerminoContrato) {
		this.dataTerminoContrato = dataTerminoContrato;
	}
	public int getDiaVencimento() {
		return diaVencimento;
	}
	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public double getValorPagamentoFixoEAcumulativo() {
		return valorPagamentoFixoEAcumulativo;
	}
	public void setValorPagamentoFixoEAcumulativo(
			double valorPagamentoFixoEAcumulativo) {
		this.valorPagamentoFixoEAcumulativo = valorPagamentoFixoEAcumulativo;
	}
	public int getValorPagamentoPermuta() {
		return valorPagamentoPermuta;
	}
	public void setValorPagamentoPermuta(int valorPagamentoPermuta) {
		this.valorPagamentoPermuta = valorPagamentoPermuta;
	}
	public int getIdFranquia() {
		return idFranquia;
	}
	public void setIdFranquia(int idFranquia) {
		this.idFranquia = idFranquia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataInicioContrato == null) ? 0 : dataInicioContrato
						.hashCode());
		result = prime
				* result
				+ ((dataTerminoContrato == null) ? 0 : dataTerminoContrato
						.hashCode());
		result = prime * result + diaVencimento;
		result = prime * result
				+ ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + id;
		result = prime * result + idFranquia;
		result = prime * result + idPontoDeVeiculacao;
		long temp;
		temp = Double.doubleToLongBits(valorPagamentoFixoEAcumulativo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + valorPagamentoPermuta;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratoPontoDeVeiculacao other = (ContratoPontoDeVeiculacao) obj;
		if (dataInicioContrato == null) {
			if (other.dataInicioContrato != null)
				return false;
		} else if (!dataInicioContrato.equals(other.dataInicioContrato))
			return false;
		if (dataTerminoContrato == null) {
			if (other.dataTerminoContrato != null)
				return false;
		} else if (!dataTerminoContrato.equals(other.dataTerminoContrato))
			return false;
		if (diaVencimento != other.diaVencimento)
			return false;
		if (formaPagamento == null) {
			if (other.formaPagamento != null)
				return false;
		} else if (!formaPagamento.equals(other.formaPagamento))
			return false;
		if (id != other.id)
			return false;
		if (idFranquia != other.idFranquia)
			return false;
		if (idPontoDeVeiculacao != other.idPontoDeVeiculacao)
			return false;
		if (Double.doubleToLongBits(valorPagamentoFixoEAcumulativo) != Double
				.doubleToLongBits(other.valorPagamentoFixoEAcumulativo))
			return false;
		if (valorPagamentoPermuta != other.valorPagamentoPermuta)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ContratoPontoDeVeiculacao [id=" + id + ", idPontoDeVeiculacao="
				+ idPontoDeVeiculacao + ", dataInicioContrato="
				+ dataInicioContrato + ", dataTerminoContrato="
				+ dataTerminoContrato + ", diaVencimento=" + diaVencimento
				+ ", formaPagamento=" + formaPagamento
				+ ", valorPagamentoFixoEAcumulativo="
				+ valorPagamentoFixoEAcumulativo + ", valorPagamentoPermuta="
				+ valorPagamentoPermuta + ", idFranquia=" + idFranquia + "]";
	}
	
	

}
