package com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.domain.Sistema;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Integer> {

}
