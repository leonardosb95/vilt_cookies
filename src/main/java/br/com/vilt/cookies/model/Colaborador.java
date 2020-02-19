package br.com.vilt.cookies.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vilt.cookies.enumm.Cookie;

@Entity(name = "COLABORADOR")
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataCriacao = LocalDate.now();
	private LocalDate inicioCookie = LocalDate.now().plusDays(7);
	private int status = Cookie.PROXIMO.get();

	public Colaborador() {

	}
	

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}


	public LocalDate getInicioCookie() {
		return inicioCookie;
	}

	public void setInicioCookie(LocalDate inicioCookie) {
		this.inicioCookie = inicioCookie;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Colaborador(String nome) {
		this.nome = nome;

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
