package model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "eventt_controller")
public class PontoDeVeiculacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String nome;
	@Column
	private String endereco;
	@Column
	private String telefone;
	@Column
	private String contato;
	@Column
	private String cpf;
	@Column
	private String rg;
	@Column
	private String cnpj;
	@Column
	private String razaoSocial;
	@Column
	private Integer quantidadeAnuncioInicial;
	@Column
	private int quantidadeAnuncioOcupado;
	@Column
	private TipoPessoa pessoa;
	@OneToOne
	private TipoPontoDeVeiculacao tipoPontoDeVeiculacao;
	@Column
	private int idFranquia;
	@OneToOne
	private ContratoPontoDeVeiculacao contrato;
	@Column
	private List<Anunciante> anunciantes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Integer getQuantidadeAnuncioInicial() {
		return quantidadeAnuncioInicial;
	}
	public void setQuantidadeAnuncioInicial(Integer quantidadeAnuncioInicial) {
		this.quantidadeAnuncioInicial = quantidadeAnuncioInicial;
	}
	public int getQuantidadeAnuncioOcupado() {
		return quantidadeAnuncioOcupado;
	}
	public void setQuantidadeAnuncioOcupado(int quantidadeAnuncioOcupado) {
		this.quantidadeAnuncioOcupado = quantidadeAnuncioOcupado;
	}
	public TipoPessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(TipoPessoa pessoa) {
		this.pessoa = pessoa;
	}
	public TipoPontoDeVeiculacao getTipoPontoDeVeiculacao() {
		return tipoPontoDeVeiculacao;
	}
	public void setTipoPontoDeVeiculacao(TipoPontoDeVeiculacao tipoPontoDeVeiculacao) {
		this.tipoPontoDeVeiculacao = tipoPontoDeVeiculacao;
	}
	public int getIdFranquia() {
		return idFranquia;
	}
	public void setIdFranquia(int idFranquia) {
		this.idFranquia = idFranquia;
	}
	public ContratoPontoDeVeiculacao getContrato() {
		return contrato;
	}
	public void setContrato(ContratoPontoDeVeiculacao contrato) {
		this.contrato = contrato;
	}
	public List<Anunciante> getAnunciantes() {
		return anunciantes;
	}
	public void setAnunciantes(List<Anunciante> anunciantes) {
		this.anunciantes = anunciantes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((anunciantes == null) ? 0 : anunciantes.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result
				+ ((contrato == null) ? 0 : contrato.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + id;
		result = prime * result + idFranquia;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime
				* result
				+ ((quantidadeAnuncioInicial == null) ? 0
						: quantidadeAnuncioInicial.hashCode());
		result = prime * result + quantidadeAnuncioOcupado;
		result = prime * result
				+ ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime
				* result
				+ ((tipoPontoDeVeiculacao == null) ? 0 : tipoPontoDeVeiculacao
						.hashCode());
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
		PontoDeVeiculacao other = (PontoDeVeiculacao) obj;
		if (anunciantes == null) {
			if (other.anunciantes != null)
				return false;
		} else if (!anunciantes.equals(other.anunciantes))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (contrato == null) {
			if (other.contrato != null)
				return false;
		} else if (!contrato.equals(other.contrato))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id != other.id)
			return false;
		if (idFranquia != other.idFranquia)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (quantidadeAnuncioInicial == null) {
			if (other.quantidadeAnuncioInicial != null)
				return false;
		} else if (!quantidadeAnuncioInicial
				.equals(other.quantidadeAnuncioInicial))
			return false;
		if (quantidadeAnuncioOcupado != other.quantidadeAnuncioOcupado)
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipoPontoDeVeiculacao == null) {
			if (other.tipoPontoDeVeiculacao != null)
				return false;
		} else if (!tipoPontoDeVeiculacao.equals(other.tipoPontoDeVeiculacao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PontoDeVeiculacao [id=" + id + ", nome=" + nome + ", endereco="
				+ endereco + ", telefone=" + telefone + ", contato=" + contato
				+ ", cpf=" + cpf + ", rg=" + rg + ", cnpj=" + cnpj
				+ ", razaoSocial=" + razaoSocial
				+ ", quantidadeAnuncioInicial=" + quantidadeAnuncioInicial
				+ ", quantidadeAnuncioOcupado=" + quantidadeAnuncioOcupado
				+ ", pessoa=" + pessoa + ", tipoPontoDeVeiculacao="
				+ tipoPontoDeVeiculacao + ", idFranquia=" + idFranquia
				+ ", contrato=" + contrato + ", anunciantes=" + anunciantes
				+ "]";
	}
	
	
	
}
