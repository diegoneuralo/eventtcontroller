package model.service.interfaces;

public interface IContratoAnuncianteService {
	int totalContratoPorMes(int mes, int idFranquia);
	double totalRecebimentoPorMes(int mes, int idFranquia);
	double totalPagamentoPorMes(int mes, int idFranquia);
}
