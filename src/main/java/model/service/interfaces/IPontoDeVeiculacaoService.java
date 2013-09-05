package model.service.interfaces;

import java.util.List;

import model.entity.PontoDeVeiculacao;

public interface IPontoDeVeiculacaoService {
	void add(PontoDeVeiculacao pontoDeVeiculacao);
	PontoDeVeiculacao showDetail(int idPontoDeVeiculacao);
	List<PontoDeVeiculacao> showAll(int idFranquia);
}
