package model.service.interfaces;

import java.util.List;

import model.entity.Anunciante;

public interface IAnucianteService {
	void add(Anunciante anunciante);
	Anunciante showDetail(int idAnunciante);
	List<Anunciante> showAll(int idFranquia);
}
