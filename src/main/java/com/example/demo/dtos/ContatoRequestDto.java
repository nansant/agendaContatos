package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequestDto {

	@Size(min = 4, max = 30, message = "Por favor, informe o nome com o mínimo de 4 e no máximo 30 caracteres.")
	@NotBlank(message = "Por favor, informe o nome do contato.")
	private String nome;

	@Size(min = 0, max = 20, message = "Por favor, informe o telefone com o máximo de 20 números.")
	@NotBlank(message = "Por favor, informe o telefone do contato.")
	private String telefone;
	
	@Size(min = 0, max = 20, message = "Por favor, informe o email com o máximo de 20 caracteres.")
	@NotBlank(message = "Por favor, informe o email do contato.")
	private String email;
	
}
