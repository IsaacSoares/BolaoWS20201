package br.edu.uniateneu.bolao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uniateneu.bolao.model.CartaoEntity;
@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> { 

}
