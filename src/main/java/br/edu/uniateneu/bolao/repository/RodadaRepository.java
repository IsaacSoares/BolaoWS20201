package br.edu.uniateneu.bolao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.uniateneu.bolao.model.RodadaEntity;
@Repository
public interface RodadaRepository extends JpaRepository<RodadaEntity, Long> {
	@Query(value = "select r.cd_rodada, r.nm_rodada " +
			" from tb_rodada r "
					+ " where r.nm_rodada = (:nmRodada)", nativeQuery = true)
	public RodadaEntity findRodadaByNmRodada(@Param("nmRodada") int i);

}
