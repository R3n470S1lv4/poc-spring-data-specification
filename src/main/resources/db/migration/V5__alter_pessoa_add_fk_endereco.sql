alter table pessoa
add constraint fk_pessoa_endereco
foreign key (endereco_id) references endereco (endereco_id);