CREATE TABLE tb_morador(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	ativo BOOLEAN NOT NULL,
	dataCadastro DATE NOT NULL,
	bloco VARCHAR(255) NOT NULL,
	apartamento VARCHAR(255)  NULL
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_morador (id, nome, cpf, ativo,  dataCadastro, bloco, apartamento) 
values (1, 'laura','00000000000', '1','2023-08-18' , 'B02', '12');
INSERT INTO tb_morador (id, nome, cpf, ativo,  dataCadastro, bloco, apartamento) 
values (2, 'carlos','00000000000', '1','2023-08-18' , 'B01', '12');