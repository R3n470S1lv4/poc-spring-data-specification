CREATE TABLE pessoa (
	pessoa_id int NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	nome varchar(255) NOT NULL,
	sobre_nome varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	data_nascimento date NOT NULL,
	CONSTRAINT pessoa_pkey PRIMARY KEY (pessoa_id)
);