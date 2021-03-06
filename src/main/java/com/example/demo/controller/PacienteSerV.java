package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Paciente;
import com.example.demo.service.PacienteService;

@RestController
@RequestMapping("/api")
public class PacienteSerV {
	@Autowired
	private PacienteService pacienteservice;
	@PostMapping("/alumno")
	public ResponseEntity<Paciente> save(@RequestBody Paciente alum){
		try {
			Paciente al = pacienteservice.create(new Paciente(alum.getIdpaciente(),alum.getDni(),alum.getNombres(),alum.getApellidos(),alum.getTelefono()));
			
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//----------------------------------------------------------------------------------------
	@GetMapping("/alumnos")
	public ResponseEntity<List<Paciente>> getAlumnos(){
		try {
			List<Paciente> list = new ArrayList<>();
			list = pacienteservice.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//---------------------------------------------------------------------------------------------
	@PutMapping("/update/{id}")
	public ResponseEntity<Paciente> update(@RequestBody Paciente alum, @PathVariable("id") long id){
		try {
			Paciente ul = pacienteservice.read(id);
			if(ul.getIdpaciente()>0) {
				ul.setDni(alum.getDni());
				ul.setNombres(alum.getNombres());
				ul.setApellidos(alum.getApellidos());
				ul.setTelefono(alum.getTelefono());
				
				return new ResponseEntity<>(pacienteservice.create(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//---------------------------------------------------------------------------------
	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		try {
			pacienteservice.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
