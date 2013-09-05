package model.service;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.interfaces.IGenericDao;
import model.entity.ContratoPontoDeVeiculacao;
import model.service.interfaces.IContratoPontoDeVeiculacaoService;

public class ContratoPontoDeVeiculacaoService implements IContratoPontoDeVeiculacaoService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private IGenericDao<ContratoPontoDeVeiculacao> dao;
	@PersistenceContext(name="ctm")
	private EntityManager manager;

	@Override
	public int totalContratoPorMes(int mes, int idFranquia) {
		Query query = manager.createQuery("select count(x) from ContratoPontoDeVeiculacao x where x.mes = :mes and x.idFranquia = :idFranquia");
		query.setParameter("mes", mes);
		query.setParameter("idFranquia", idFranquia);
		Integer results = query.getFirstResult();
		return results;
	}

	@Override
	public double totalRecebimentoPorMes(int mes, int idFranquia) {
		Query query = manager.createQuery("select count(x) from ContratoPontoDeVeiculacao x where x.mes = :mes and x.idFranquia = :idFranquia");
		query.setParameter("mes", mes);
		query.setParameter("idFranquia", idFranquia);
		Integer results = query.getFirstResult();
		return results;
	}

	@Override
	public double totalPagamentoPorMes(int mes, int idFranquia) {
		Query query = manager.createQuery("select count(x) from ContratoPontoDeVeiculacao x where x.mes = :mes and x.idFranquia = :idFranquia");
		query.setParameter("mes", mes);
		query.setParameter("idFranquia", idFranquia);
		Integer results = query.getFirstResult();
		return results;
	}

}
