package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ContatoRequestDto;
import com.example.demo.entities.Contato;
import com.example.demo.repositories.ContatoRepository;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/contatos")
public class ContatoController {

	
	@Operation(summary = "Serviço para cadastrar contato.")
	@PostMapping("cadastrar")
	public String cadastrar(@RequestBody @Valid ContatoRequestDto request) {

		var contato = new Contato();
		
		contato.setId(UUID.randomUUID());
		contato.setNome(request.getNome());
		contato.setTelefone(request.getTelefone());
		contato.setEmail(request.getEmail());
		
		var contatoRepository = new ContatoRepository();
		contatoRepository.create(contato);
		
		return "Contato cadastrado com sucesso.";
	}
		
	@Operation(summary = "Serviço para atualizar contato.")
	@PutMapping("atualizar/{id}")
	public String atualizar(@PathVariable UUID id, @RequestBody @Valid ContatoRequestDto request) {

		var contato = new Contato();
		
		contato.setId(id);
		contato.setNome(request.getNome());
		contato.setTelefone(request.getTelefone());
		contato.setEmail(request.getEmail());
		
		var contatoRepository = new ContatoRepository();
		contatoRepository.update(contato);
		
		return "Contato atualizado com sucesso.";
		
	}
	
	@Operation(summary = "Serviço para excluir contato.")
	@DeleteMapping("deletar/{id}")
	public String deletar(@PathVariable UUID id) {
		
		try {
			var contatoRepository = new ContatoRepository();
			contatoRepository.delete(id);
			
			return "Contato excluído com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Operation(summary = "Serviço para consultar contatos pelo nome.")
	@GetMapping("consultar/{nome}")
	public List<Contato> consultarNome(@PathVariable String nome) {
		
		try {
			
			var contatoRepository = new ContatoRepository();
			
			return contatoRepository.findName(nome);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
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
