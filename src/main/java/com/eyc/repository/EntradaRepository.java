package com.eyc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyc.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long>{
	boolean existsByNumeroEntrada(String numeroEntrada);
	Optional<Entrada> findByNumeroEntrada(String numeroEntrada);
	List<Entrada> findByCliente(String cliente);
	List<Entrada> findByEntregado(String entregado);
}
