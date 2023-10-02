CREATE TABLE tb_visitas(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	dataEntrada DATE NOT NULL,
	dataSaida DATE NOT NULL,
	bloco VARCHAR(255) NOT NULL,
	apartamento VARCHAR(255) NOT NULL,
	funcionario_id BIGINT NULL,
    morador_id BIGINT NULL, 
FOREIGN KEY (funcionario_id) REFERENCES tb_funcionario(id),
FOREIGN KEY (morador_id) REFERENCES tb_morador(id)
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_visitas (id, nome, cpf, dataEntrada, dataSaida, bloco, apartamento,funcionario_id, morador_id) 
values (1, 'Ana','00000000000','2023-08-18' ,'2023-08-19','B02', '12', 1, 1);