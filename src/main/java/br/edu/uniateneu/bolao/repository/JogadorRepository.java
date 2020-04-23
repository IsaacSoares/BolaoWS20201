package br.edu.uniateneu.bolao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uniateneu.bolao.model.JogadorEntity;
@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {

}
