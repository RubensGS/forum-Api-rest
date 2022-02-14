CREATE TABLE IF NOT EXISTS curso (
   id BIGINT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(50) NOT NULL,
   categoria VARCHAR(50) NOT NULL,
   PRIMARY KEY (id)
);

insert into curso values(1, 'Kotlin', 'Programacao');