package model.service.interfaces;

import java.util.List;

import model.entity.TipoPontoDeVeiculacao;

public interface ITipoPontoDeVeiculacaoService {
	void add(TipoPontoDeVeiculacao tipoPontoDeVeiculacao);
	TipoPontoDeVeiculacao showDetail(int idTipoPontoDeVeiculacao);
	List<TipoPontoDeVeiculacao> showAll(int idFranquia);
}
