# Itabar

script de criação do banco

create table Produto
(
	idProduto smallint generated always as identity primary key,
	nome varchar(250) not null,
	valor decimal(5,2) not null
)

select * from public.Produto

delete from public.Produto
where idProduto = 3

create table Venda
(
	idVenda smallint generated always as identity primary key,
	dataVenda date not null,
	idProdutos smallint references Produto(idProduto),
	qtd int,
	total decimal(5,2) not null
)

select * from public.Venda
