package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequestDto {

	@Size(min = 4, max = 100, message = "Por favor, informe o nome com o mínimo de 4 e no máximo 30 caracteres.")
	@NotBlank(message = "Por favor, informe o nome do contato.")
	private String nome;

	@Size(min = 8, max = 30, message = "Por favor, informe o telefone com o mínimo de 8 e máximo de 20 números.")
	@NotNull(message = "Por favor, informe o telefone do contato.")
	private String telefone;
	
	@Size(min = 8, max = 30, message = "Por favor, informe o email com o mínimo de 8 e máximo de 20 caracteres.")
	@NotNull(message = "Por favor, informe o email do contato.")
	private String email;
	
}
