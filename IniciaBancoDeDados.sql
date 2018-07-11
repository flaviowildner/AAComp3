CREATE TABLE associacao(
numero_oficio VARCHAR(255),
data_oficio VARCHAR(255),
nome VARCHAR(255),
sigla VARCHAR(255),
endereco VARCHAR(255),
telefone VARCHAR(255),
comprovante_pagamento VARCHAR(255),
matricula VARCHAR(255),
senha VARCHAR(255));

CREATE TABLE atleta(
matricula VARCHAR(255) primary key,
nome VARCHAR(255),
numero VARCHAR(255),
data_entrada VARCHAR(255),
data_oficio VARCHAR(255),
data_nascimento VARCHAR(255),
comprovante_pagamento VARCHAR(255),
matricula_associacao VARCHAR(255),
matricula VARCHAR(255),
foreign key (matricula_associacao) references associacao(matricula));