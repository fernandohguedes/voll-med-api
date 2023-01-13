-- Adicionar a nova coluna a tabela
alter table medicos add ativo tinyint;

-- Popular a nota coluna
update medicos set ativo = 1;
