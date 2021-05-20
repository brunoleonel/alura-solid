package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal aumento) {

        var dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        var dataAtual = LocalDate.now();
        var mesesUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (mesesUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser de no minimo 6 meses");
        }
    }
}
