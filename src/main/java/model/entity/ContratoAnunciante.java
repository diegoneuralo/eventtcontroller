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
public class ContratoAnunciante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column
	private int idAnunciante;
	@Column
	private int idPontoDeVeiculacao;
	@Column
	private Date dataInicioContrato;
	@Column
	private Date dataTerminoContrato;
	@Column
	private int diaVencimento;
	@Column
	private double valor;
	@Column
	private int idFranquia;
	
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
		result = prime * result + id;
		result = prime * result + idAnunciante;
		result = prime * result + idFranquia;
		result = prime * result + idPontoDeVeiculacao;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ContratoAnunciante other = (ContratoAnunciante) obj;
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
		if (id != other.id)
			return false;
		if (idAnunciante != other.idAnunciante)
			return false;
		if (idFranquia != other.idFranquia)
			return false;
		if (idPontoDeVeiculacao != other.idPontoDeVeiculacao)
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ContratoAnunciante [idAnunciante=" + idAnunciante
				+ ", idPontoDeVeiculacao=" + idPontoDeVeiculacao + ", valor="
				+ valor + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAnunciante() {
		return idAnunciante;
	}
	public void setIdAnunciante(int idAnunciante) {
		this.idAnunciante = idAnunciante;
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getIdFranquia() {
		return idFranquia;
	}
	public void setIdFranquia(int idFranquia) {
		this.idFranquia = idFranquia;
	}
}
