CREATE TABLE contatos (
	id			UUID			PRIMARY KEY,
	nome		varchar(30)		not null,
	telefone	varchar(20)		not null, 
	email		varchar(20)		not null
);

INSERT INTO contatos(id, nome, telefone, email) VALUES (gen_random_uuid(), 'Renan',	'21999999999', 'renan@gmail.com');

SELECT * FROM contatos ORDER BY nome;