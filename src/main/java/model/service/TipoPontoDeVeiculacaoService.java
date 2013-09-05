package model.service;

import java.io.Serializable;
import java.util.List;

import model.dao.interfaces.IGenericDao;
import model.entity.TipoPontoDeVeiculacao;
import model.service.interfaces.ITipoPontoDeVeiculacaoService;

public class TipoPontoDeVeiculacaoService implements ITipoPontoDeVeiculacaoService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IGenericDao<TipoPontoDeVeiculacao> dao;

	@Override
	public void add(TipoPontoDeVeiculacao tipoPontoDeVeiculacao) {
		try{
			dao.add(tipoPontoDeVeiculacao);
		}catch(Exception ex){
			// TODO: LOG ERROR
		}		
	}

	@Override
	public TipoPontoDeVeiculacao showDetail(int idTipoPontoDeVeiculacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPontoDeVeiculacao> showAll(int idFranquia) {
		// TODO Auto-generated method stub
		return null;
	}

}
