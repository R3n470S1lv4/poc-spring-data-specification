CREATE TABLE endereco (
	endereco_id int NOT NULL,
	estado varchar(255) NOT NULL,
	cidade varchar(255) NOT NULL,
	logradouro varchar(255) NOT NULL,
	numero varchar(255) NOT NULL,
	bairro varchar(255) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT endereco_pkey PRIMARY KEY (endereco_id)
);