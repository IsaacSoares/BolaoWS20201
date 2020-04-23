package br.edu.uniateneu.bolao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.uniateneu.bolao.model.TimeEntity;

public interface TimeRepository extends JpaRepository<TimeEntity, Long> {

}
