package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.converter.Convertidor;
import com.example.demo.entity.Nota;
import com.example.demo.model.MNota;
import com.example.demo.repository.NotaRepositorio;

@Service("servicio")
public class NotaService {

	@Autowired
	@Qualifier("repositorio")
	private NotaRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	private static final Logger log = LoggerFactory.getLogger(NotaService.class);
	
	public boolean crear(Nota nota) {
		log.info("CREANDO NOTA");
		try {
			repositorio.save(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean actualizar(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean borrar(String nombre, long id) {
		try {
			Nota  nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<MNota> obtener() {
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	public MNota obtenerPorNombreTitulo(String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota> obtenerTitulo(String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
}
