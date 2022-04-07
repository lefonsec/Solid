package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidade implements ValidacaoReajuste {

	public void validar(Funcionario funcionario, BigDecimal aumento) {
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate data = LocalDate.now();
		//CronoUnit pega a ultima data e a data atual e Vê quantos meses se passaram.
		long mesUltimoRejusto = ChronoUnit.MONTHS.between(dataUltimoReajuste, data);
		
		if(mesUltimoRejusto < 6) {
			throw new ValidacaoException("não pode ter reajuste deve ser de 6 em 6 meses");

		}
	}
}
