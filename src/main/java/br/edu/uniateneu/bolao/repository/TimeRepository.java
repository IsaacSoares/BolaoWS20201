package br.edu.uniateneu.bolao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uniateneu.bolao.model.TimeEntity;
@Repository
public interface TimeRepository extends JpaRepository<TimeEntity, Long> {

}
