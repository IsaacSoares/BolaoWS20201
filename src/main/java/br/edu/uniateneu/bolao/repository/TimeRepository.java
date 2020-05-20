package br.edu.uniateneu.bolao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.uniateneu.bolao.model.TimeEntity;
@Repository
public interface TimeRepository extends JpaRepository<TimeEntity, Long> {

	@Query(value = "select t.cd_time, t.nm_escudo, t.nm_estado, t.cd_globo, t.nm_time, t.nm_sigla, t.cd_estadio " +
	" from tb_time t "
			+ " where t.cd_globo = (:idglobo)", nativeQuery = true)
	TimeEntity findTimeByCdGlobo(@Param("idglobo") Long idglobo);

	@Query(value = "select t.cd_time, t.nm_escudo, t.nm_estado, t.cd_globo, t.nm_time, t.nm_sigla, t.cd_estadio " +
	" from tb_time t "
			+ " where t.nm_sigla = (:nmSigla)", nativeQuery = true)
	TimeEntity findTimeBySigla(@Param("nmSigla") String nmSigla);
	
}
