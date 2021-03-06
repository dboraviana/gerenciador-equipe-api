package com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.domain.Integrante;

@Repository
public interface IntegranteRepository extends JpaRepository<Integrante, Integer> {

}
