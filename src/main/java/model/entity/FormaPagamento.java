package model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "eventt_controller")
public class FormaPagamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String forma;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getForma() {
		return forma;
	}
	public void setForma(String forma) {
		this.forma = forma;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((forma == null) ? 0 : forma.hashCode());
		result = prime * result + id;
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
		FormaPagamento other = (FormaPagamento) obj;
		if (forma == null) {
			if (other.forma != null)
				return false;
		} else if (!forma.equals(other.forma))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FormaPagamento [id=" + id + ", forma=" + forma + "]";
	}		
}
