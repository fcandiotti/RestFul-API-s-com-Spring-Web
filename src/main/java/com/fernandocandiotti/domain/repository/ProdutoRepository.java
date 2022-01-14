package com.fernandocandiotti.domain.repository;

import com.fernandocandiotti.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {

}
