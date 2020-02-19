package br.com.vilt.cookies.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.vilt.cookies.model.Colaborador;
import br.com.vilt.cookies.repository.ColaboradorRepository;

public class ColaboradorForm {

	@NotNull
	@NotEmpty
	@Length(min = 3)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Colaborador converter(ColaboradorRepository repository) {
		return new Colaborador(nome);
	}

}
