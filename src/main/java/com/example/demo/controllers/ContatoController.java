package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Contato;
import com.example.demo.repositories.ContatoRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/contatos")
public class ContatoController {

	@Operation(summary = "Serviço para consultar todas os contatos.")
	@GetMapping("consultar")
	public List<Contato> consultar() {

		try {
			
			var contatoRepository = new ContatoRepository();
			
			return contatoRepository.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
