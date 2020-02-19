package br.com.vilt.cookies.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vilt.cookies.model.Colaborador;

public class ColaboradorDto {

	private Long id;
	private String nome;
	private LocalDate dataCriacao;
	private LocalDate inicioCookie;
	private int status;

	public ColaboradorDto(Colaborador colaborador) {

		this.id = colaborador.getId();
		this.nome = colaborador.getNome();
		this.dataCriacao = colaborador.getDataCriacao();
		this.status = colaborador.getStatus();
		this.inicioCookie = colaborador.getInicioCookie();

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

	public static List<ColaboradorDto> converter(List<Colaborador> colaborador) {
		return colaborador.stream().map(ColaboradorDto::new).collect(Collectors.toList());
	}

}
