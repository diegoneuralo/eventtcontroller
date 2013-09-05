package model.service;

import java.io.Serializable;
import java.util.List;

import model.dao.interfaces.IGenericDao;
import model.entity.FormaPagamento;
import model.service.interfaces.IFormaPagamentoService;

public class FormaPagamentoService implements IFormaPagamentoService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IGenericDao<FormaPagamento> dao;

	@Override
	public void add(FormaPagamento formaPagamento) {
		try{
			dao.add(formaPagamento);
		}catch(Exception ex){
			// TODO: LOG ERROR
		}		
	}

	@Override
	public FormaPagamento showDetail(int idFormaPagamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormaPagamento> showAll(int idFranquia) {
		// TODO Auto-generated method stub
		return null;
	}

}
