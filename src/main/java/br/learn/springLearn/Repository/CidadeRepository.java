package br.learn.springLearn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.learn.springLearn.Entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>  {

}
