package br.edu.uniateneu.bolao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.uniateneu.bolao.model.JogadorEntity;
@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {
 @Query(value = "select j.nm_jogador..."
 		+ " from tb_jogador j join tb_time t on t.cd_time = j.cd_time " +
		 " where t.nm_time like (:nmTime)", nativeQuery = true)
 public ArrayList<JogadorEntity> findJogadoresByNomeTime(@Param("nmTime") String nmTime ); 
}
