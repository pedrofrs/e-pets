package com.softwaredev.epets_h2.ropository;

import com.softwaredev.epets_h2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, UUID> {
}
