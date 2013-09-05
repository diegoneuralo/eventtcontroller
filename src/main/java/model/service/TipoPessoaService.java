package model.service;

import java.io.Serializable;
import java.util.List;

import model.dao.interfaces.IGenericDao;
import model.entity.TipoPessoa;
import model.service.interfaces.ITipoPessoaService;

public class TipoPessoaService implements ITipoPessoaService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IGenericDao<TipoPessoa> dao;

	@Override
	public void add(TipoPessoa tipoPessoa) {
		try{
			dao.add(tipoPessoa);
		}catch(Exception ex){
			// TODO: LOG ERROR
		}		
	}

	@Override
	public TipoPessoa showDetail(int idTipoPessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPessoa> showAll(int idFranquia) {
		// TODO Auto-generated method stub
		return null;
	}

}
