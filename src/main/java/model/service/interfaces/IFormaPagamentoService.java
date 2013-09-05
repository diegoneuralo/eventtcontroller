package model.service.interfaces;

import java.util.List;

import model.entity.FormaPagamento;

public interface IFormaPagamentoService {
	void add(FormaPagamento formaPagamento);
	FormaPagamento showDetail(int idFormaPagamento);
	List<FormaPagamento> showAll(int idFranquia);
}
