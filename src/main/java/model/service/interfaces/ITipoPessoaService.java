package model.service.interfaces;

import java.util.List;

import model.entity.TipoPessoa;

public interface ITipoPessoaService {
	void add(TipoPessoa tipoPessoa);
	TipoPessoa showDetail(int idTipoPessoa);
	List<TipoPessoa> showAll(int idFranquia);
}
