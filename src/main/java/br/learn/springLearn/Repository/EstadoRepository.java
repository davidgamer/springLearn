package br.learn.springLearn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.learn.springLearn.Entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
