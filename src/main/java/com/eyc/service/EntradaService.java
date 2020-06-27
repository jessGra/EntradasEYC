package com.eyc.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyc.model.Entrada;
import com.eyc.repository.EntradaRepository;

@Service
public class EntradaService {
	
	@Autowired
	EntradaRepository entradaRepo;
	
	public List<Entrada> optenerEntradaLista() {
		return entradaRepo.findAll();
	}
	
	public Optional<Entrada> optenerEntradaPorId(long id) {
		return entradaRepo.findById(id);
	}
	
	public Optional<Entrada> optenerEntradaPorNumeroEntrada(String numeroEntrada) {
		return entradaRepo.findByNumeroEntrada(numeroEntrada);
	}
	
	public List<Entrada> optenerEntradaPorCliente(String cliente) {
		return entradaRepo.findByCliente(cliente);
	}
	
	public List<Entrada> optenerEntradaPorEntregado(String entregado) {
		return entradaRepo.findByEntregado(entregado);
	}
	
	public void guardar(Entrada entrada) {
		entradaRepo.save(entrada);
	}
	
	public boolean existePorNumeroEntrada(String numeroEntrada) {
		return entradaRepo.existsByNumeroEntrada(numeroEntrada);
	}
	
	public boolean existePorIdEntrada(long id) {
		return entradaRepo.existsById(id);
	}
}
