package model.service;

import java.io.Serializable;
import java.util.List;

import model.dao.interfaces.IGenericDao;
import model.entity.Anunciante;
import model.service.interfaces.IAnucianteService;

public class AnucianteService implements IAnucianteService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IGenericDao<Anunciante> dao;

	@Override
	public void add(Anunciante object) {
		try{
			dao.add(object);
		}catch(Exception ex){
			// TODO: LOG ERROR
		}		
	}

	@Override
	public Anunciante showDetail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anunciante> showAll(int idAnunciante) {
		// TODO Auto-generated method stub
		return null;
	}

}
