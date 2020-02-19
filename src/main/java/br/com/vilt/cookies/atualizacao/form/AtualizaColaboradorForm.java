package br.com.vilt.cookies.atualizacao.form;

import br.com.vilt.cookies.model.Colaborador;
import br.com.vilt.cookies.repository.ColaboradorRepository;

public class AtualizaColaboradorForm {

	
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Colaborador atualizar(Long id, ColaboradorRepository repo) {

		Colaborador colaborador = repo.getOne(id);
		colaborador.setStatus(this.status);

		return colaborador;
	}

}
