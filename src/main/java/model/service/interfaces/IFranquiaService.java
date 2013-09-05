package model.service.interfaces;

import java.util.List;

import model.entity.Franquia;

public interface IFranquiaService {
	void add(Franquia franquia);
	Franquia showDetail(int idFranquia);
	List<Franquia> showAll(int idAnunciante);
}
