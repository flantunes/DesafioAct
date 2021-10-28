package br.com.desafioact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioact.model.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	public List<Endereco> findByCep(String Cep);

}