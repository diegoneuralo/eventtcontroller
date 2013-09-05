package model.service;

import java.io.Serializable;
import java.util.List;

import model.dao.interfaces.IGenericDao;
import model.entity.PontoDeVeiculacao;
import model.service.interfaces.IPontoDeVeiculacaoService;

public class PontoDeVeiculacaoService implements IPontoDeVeiculacaoService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IGenericDao<PontoDeVeiculacao> dao;

	@Override
	public void add(PontoDeVeiculacao object) {
		try{
			dao.add(object);
		}catch(Exception ex){
			// TODO: LOG ERROR
		}		
	}

	@Override
	public PontoDeVeiculacao showDetail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PontoDeVeiculacao> showAll(int idFranquia) {
		// TODO Auto-generated method stub
		return null;
	}

}
