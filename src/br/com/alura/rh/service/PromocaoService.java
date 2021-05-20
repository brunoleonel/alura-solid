package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, Boolean metaBatida) {

        var cargoAtual = funcionario.getDadosPessoais().getCargo();

        if (Cargo.GERENTE.equals(cargoAtual)) {
            throw new ValidacaoException("Gerentes não podem ser promovidos");
        }

        if (!metaBatida) {
            throw new ValidacaoException("Funcionario não bateu a meta");
        }

        var novoCargo = cargoAtual.getProximoCargo();
        funcionario.promover(novoCargo);
    }
}
