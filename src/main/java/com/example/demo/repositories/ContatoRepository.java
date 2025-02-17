package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.entities.Contato;
import com.example.demo.factories.ConnectionFactory;

public class ContatoRepository {

	private ConnectionFactory connectionFactory = new ConnectionFactory();

	public List<Contato> findAll() {
		try {

			var connection = connectionFactory.getConnection();

			var statement = connection.prepareStatement("SELECT * FROM contatos ORDER BY nome;");
			var result = statement.executeQuery();

			var lista = new ArrayList<Contato>();

			while (result.next()) {

				var contato = new Contato();

				contato.setId(UUID.fromString(result.getString("id")));
				contato.setNome(result.getString("nome"));
				contato.setTelefone(result.getString("telefone"));
				contato.setEmail(result.getString("email"));

				lista.add(contato);

			}
			connection.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
