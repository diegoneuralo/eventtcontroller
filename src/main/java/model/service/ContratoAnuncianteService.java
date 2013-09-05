package model.service;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.interfaces.IGenericDao;
import model.entity.ContratoAnunciante;
import model.service.interfaces.IContratoAnuncianteService;

public class ContratoAnuncianteService implements IContratoAnuncianteService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private IGenericDao<ContratoAnunciante> dao;
	@PersistenceContext(name="ctm")
	private EntityManager manager;

	@Override
	public int totalContratoPorMes(int mes, int idFranquia) {
		Query query = manager.createQuery("select count(x) from ContratoAnunciante x where x.mes = :mes and x.idFranquia = :idFranquia");
		query.setParameter("mes", mes);
		query.setParameter("idFranquia", idFranquia);
		Integer results = query.getFirstResult();
		return results;
	}

	@Override
	public double totalRecebimentoPorMes(int mes, int idFranquia) {
		Query query = manager.createQuery("select count(x) from ContratoAnunciante x where x.mes = :mes and x.idFranquia = :idFranquia");
		query.setParameter("mes", mes);
		query.setParameter("idFranquia", idFranquia);
		Integer results = query.getFirstResult();
		return results;
	}

	@Override
	public double totalPagamentoPorMes(int mes, int idFranquia) {
		Query query = manager.createQuery("select count(x) from ContratoAnunciante x where x.mes = :mes and x.idFranquia = :idFranquia");
		query.setParameter("mes", mes);
		query.setParameter("idFranquia", idFranquia);
		Integer results = query.getFirstResult();
		return results;
	}

}
