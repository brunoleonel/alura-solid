package br.com.alura.rh.model;

import br.com.alura.rh.ValidacaoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ReajusteService {

    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
        var salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
        var salarioReajustado = salarioAtual.add(aumento);
        funcionario.reajustarSalario(salarioReajustado);
    }
}
