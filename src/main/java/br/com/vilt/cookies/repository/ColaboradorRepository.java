package br.com.vilt.cookies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vilt.cookies.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>  {

	@Query(value="SELECT * FROM COLABORADOR WHERE STATUS=1 ORDER BY 1 DESC",nativeQuery = true)
	List<Colaborador> findCookies();

}
