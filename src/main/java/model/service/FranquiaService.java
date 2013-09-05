package model.service;

import java.io.Serializable;
import java.util.List;

import model.dao.interfaces.IGenericDao;
import model.entity.Franquia;
import model.service.interfaces.IFranquiaService;

public class FranquiaService implements IFranquiaService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IGenericDao<Franquia> dao;

	@Override
	public void add(Franquia franquia) {
		try{
			dao.add(franquia);
		}catch(Exception ex){
			// TODO: LOG ERROR
		}		
	}

	@Override
	public Franquia showDetail(int idFranquia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Franquia> showAll(int idAnunciante) {
		// TODO Auto-generated method stub
		return null;
	}

}
