package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;
@Repository
public class PacienteService implements SPaciente{

	@Autowired
	private PacienteRepository pacientereposity;
	@Override
	public Paciente create(Paciente al) {
		// TODO Auto-generated method stub
		return pacientereposity.save(al);
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return pacientereposity.findAll();
	}

	@Override
	public Paciente read(Long id) {
		// TODO Auto-generated method stub
		return pacientereposity.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pacientereposity.deleteById(id);
	}

	@Override
	public Paciente update(Paciente al) {
		// TODO Auto-generated method stub
		return pacientereposity.save(al);
	}

}
