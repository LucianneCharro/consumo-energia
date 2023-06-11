## Resumo do projeto
- Projeto em andamento, sendo realizado no curso POSTECH da FIAP, visando a entrega de um sistema Web, com interfaces e APIs, para cadastro de Pessoas, Casas e Eletrodomésticos. Este sistema tem por finalidade calcular o consumo mensal de energia.
Serão construidas APIs que um portal poderá consumir para apresentar aos usuários os dados de consumo de cada eletrodoméstico. Serão realizados calculos que vão gerar alertas aos usuários.
Isso permitirá a criação de um painel de controle, no qual será possível visualizar o consumo de energia de cada aparelho eletrônico e usuário.

## 🔨 Funcionalidades do projeto nessa primeira fase

- `Funcionalidade 1` `API de cadastro de endereço`: A API tem como objetivo permitir o gerenciamento de informações sobre os endereços cadastrados em nosso sistema. Para cadastrar um endereço, deve ser informada sua rua, número, bairro, cidade e estado válidos e não podem estar preenchidos com brancos ou nulos. Todos os campos são obrigatórios. O sistema também deve gravar os dados no sistema.
Receber informações através do Controller em formato HTTP POST.
#### 
- `Funcionalidade 2` `API de gestão de pessoas`: A API tem como objetivo permitir o gerenciamento de informações sobre as pessoas cadastradas em nosso sistema. Para cadastrar uma pessoa, deve ser informado seu nome, data de nascimento, sexo e grau de parêntesco válidos e não podem estar preenchidos com brancos ou nulos. Todos os campos são obrigatórios. O sistema também deve gravar os dados no sistema.
Receber informações através do Controller em formato HTTP POST.
#### 
- `Funcionalidade 3` `API de gestão de eletrodomésticos`: A API tem como objetivo permitir o gerenciamento de informações sobre os eletrodomésticos cadastrados em nosso sistema. Para cadastrar um eletrodoméstico, deve ser informado seu nome, modelo e potência válidos e não podem estar preenchidos com brancos ou nulos. Todos os campos são obrigatórios. O sistema também deve gravar os dados no sistema.
Receber informações através do Controller em formato HTTP POST.

## ✔️ Técnicas e tecnologias utilizadas

- ``Java 18``
- ``InteliJ IDEA``
- ``Testes via INSONMIA``
- ``Injeção de depêndencias, collections, exemplo mappers, utilização do Lombok, Bean Validation``
## 🛠️ Exemplo Json/Rotas de cada API

1. #### Request/Response:
- `API de cadastro de endereço`:
Request:
  {
  "rua": "Rua João Teixeira",
  "numero": "190",
  "bairro": "Campesina",
  "cidade": "Osasco",
  "estado": "São Paulo"
  }
Response:
  Status 200 OK "Endereço cadastrado com sucesso"
  Status 400 OK "Mensagem de campo obrigatório e não pode estar em branco"
#### 
- `API de gestão de pessoas`:
Request:
  {
  "nome": "Lucas Ballico",
  "data_nascimento": "25/04/1990",
  "sexo": "Feminino",
  "grau_parentesco": "Filho"
  }
Response:
  Status 200 OK "Pessoa cadastrada com sucesso"
  Status 400 OK "Mensagem de campo obrigatório e não pode estar em branco"
#### 
- `API de gestão de eletrodomésticos`:
Request:
  {
  "nome": "Geladeira",
  "modelo": "Eletrolux",
  "potencia": "110"
  }
Response:
  Status 200 OK "Eletrodomestico cadastrado com sucesso"
  Status 400 OK "Mensagem de campo obrigatório e não pode estar em branco"

2. #### Rotas de cada API:
- `API de cadastro de endereço`: http://localhost:8080/consumo-energia/endereco
- `API de gestão de pessoas`: http://localhost:8080/consumo-energia/pessoa
- `API de gestão de eletrodomésticos`: http://localhost:8080/consumo-energia/eletrodomestico

## 🎯 Desafios encontrados:
- Utilização do banco de dados Postgree, tentei implementar nesta fase, mas não consegui realizar a migração/criação do banco através da aplicação e por isso optei por implementar nas próximas fases já que não era uma exigência desta etapa da entrega.

## 📁 Acesso ao projeto
Você pode acessar os arquivos do projeto clicando [aqui](https://github.com/gui-lirasilva/Edige-POO/tree/master/src).
