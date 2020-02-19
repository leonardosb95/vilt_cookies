package br.com.vilt.cookies.atualizacao.form;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import br.com.vilt.cookies.enumm.Cookie;
import br.com.vilt.cookies.model.Colaborador;
import br.com.vilt.cookies.repository.ColaboradorRepository;

public class AtualizaColaboradorCookieForm {

	@NotNull
	@Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message="Data invalida!!") 
	private String inicioCookie;


	public Colaborador atualizar(Long id, ColaboradorRepository repo) {

		System.out.println(this.inicioCookie);
		Colaborador colaborador = repo.getOne(id);
		String [] separador=this.inicioCookie.split("-");
		
		LocalDate data=LocalDate.of(
				Integer.parseInt(separador[0]),
				Integer.parseInt(separador[1]),
				Integer.parseInt(separador[2]));
		
		colaborador.setInicioCookie(data);
		colaborador.setStatus(Cookie.PROXIMO.get());

		return colaborador;
	}


	public String getInicioCookie() {
		return inicioCookie;
	}


	public void setInicioCookie(String inicioCookie) {
		this.inicioCookie = inicioCookie;
	}
	
	
	

}
