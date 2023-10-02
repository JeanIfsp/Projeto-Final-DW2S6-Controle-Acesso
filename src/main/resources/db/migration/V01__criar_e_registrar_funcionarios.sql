CREATE TABLE tb_funcionario(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	cargo VARCHAR(30) NOT NULL,
	ativo BOOLEAN NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(150) NOT NULL,
	dataContratacao DATE NOT NULL
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_funcionario (id, nome, cargo, ativo, cpf, email, password, dataContratacao) 
values (1, 'Isabela','RECEPCAO', '1','38629856874', 'isabelalima@ifsp.edu.br', '123' ,'2023-08-18');
INSERT INTO tb_funcionario (id, nome, cargo, ativo, cpf, email, password, dataContratacao) 
values (2, 'Jean','PORTARIA', '1', '00000000000','jeam@ifsp.edu.br', '123', '2023-08-18');
INSERT INTO tb_funcionario (id, nome, cargo, ativo,  cpf, email, password, dataContratacao) 
values (3, 'Renan','SUBSTITUTO', '1', '00000000000','renan@ifsp.edu.br', '123', '2023-08-18');
INSERT INTO tb_funcionario (id, nome, cargo, ativo, cpf, email, password, dataContratacao) 
values (4, 'Cristo','SINDICO', '1','00000000000', 'cristo@ifsp.edu.br', '123', '2023-08-18');