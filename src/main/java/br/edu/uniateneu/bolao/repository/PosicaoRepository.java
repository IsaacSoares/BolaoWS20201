package br.edu.uniateneu.bolao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.edu.uniateneu.bolao.model.PosicaoEntity;
import br.edu.uniateneu.bolao.model.TimeEntity;

@Repository
public interface PosicaoRepository extends JpaRepository<PosicaoEntity, Long> {
	@Query(value = "select p.cd_posicao, p.nm_posicao, p.nm_abreviacao, p.cd_globo " +
	" from tb_posicao p "
			+ " where p.cd_globo = (:idglobo)", nativeQuery = true)
	PosicaoEntity findPosicaoByCdGlobo(@Param("idglobo") Long idglobo);
}
