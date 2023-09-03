## Resumo do projeto
- Projeto em andamento, sendo realizado no curso POSTECH da FIAP, visando a entrega de um sistema Web, com interfaces e APIs, para cadastro de Pessoas, Casas e Eletrodomésticos. Este sistema tem por finalidade calcular o consumo mensal de energia.
Serão construidas APIs que um portal poderá consumir para apresentar aos usuários os dados de consumo de cada eletrodoméstico. Serão realizados calculos que vão gerar alertas aos usuários.
Isso permitirá a criação de um painel de controle, no qual será possível visualizar o consumo de energia de cada aparelho eletrônico e usuário.

## 🔨 Funcionalidades do projeto nessa segunda fase
- `Funcionalidade 1` `4 API de cadastro de endereço`: A API tem como objetivo permitir o gerenciamento de informações sobre os endereços cadastrados em nosso sistema. Para cadastrar um endereço, deve ser informada sua rua, número, bairro, cidade e estado válidos e não podem estar preenchidos com brancos ou nulos. Todos os campos são obrigatórios. O sistema também deve gravar os dados no sistema.
Receber informações através do Controller em formato HTTP POST/GET/PUT/DELETE.
#### 
- `Funcionalidade 2` `4 API de gestão de pessoas`: A API tem como objetivo permitir o gerenciamento de informações sobre as pessoas cadastradas em nosso sistema. Para cadastrar uma pessoa, deve ser informado seu nome, data de nascimento, sexo e grau de parêntesco válidos e não podem estar preenchidos com brancos ou nulos. Todos os campos são obrigatórios. O sistema também deve gravar os dados no sistema.
Receber informações através do Controller em formato HTTP POST/GET/PUT/DELETE.
#### 
- `Funcionalidade 3` `4 API de gestão de eletrodomésticos`: A API tem como objetivo permitir o gerenciamento de informações sobre os eletrodomésticos cadastrados em nosso sistema. Para cadastrar um eletrodoméstico, deve ser informado seu nome, modelo e potência válidos e não podem estar preenchidos com brancos ou nulos. Todos os campos são obrigatórios. O sistema também deve gravar os dados no sistema.
Receber informações através do Controller em formato HTTP POST/GET/PUT/DELETE.

#### 
- `Funcionalidade 4` `4 API de gestão de usuários`: A API tem como objetivo permitir o gerenciamento de usuários cadastrados em nosso sistema. Para cadastrar um usuário, deve ser informado seu login, senha e flag que identifica se trata-se de usuário master ou não. Devem ser válidos e não podem estar preenchidos com brancos ou nulos. Todos os campos são obrigatórios. O sistema também deve gravar os dados no sistema.
  Receber informações através do Controller em formato HTTP POST/GET/PUT/DELETE.
## ✔️ Técnicas e tecnologias utilizadas

- ``Java 18``
- ``InteliJ IDEA``
- ``Testes via INSONMIA``
- ``Injeção de depêndencias, collections, exemplo mappers, utilização do Lombok, Bean Validation, Tratamento de exceção, Enum``
- ``Persistencia Banco de dados Postgree, utilizado o Console ElephanteSQL``
- ``Para modelagem de Dados utilizamos o DataModeler``

## 🛠️ Exemplo Json/Rotas de cada API

Em anexo estão as collections do Insomnia.

1. #### Request/Response:
- `API de cadastro de endereço`:
Request:
  {
  "rua": "Rua João Teixeira",
  "numero": "110",
  "bairro": "Bela Vista",
  "cidade": "Osasco",
  "estado": "São Paulo"
  }
Response:
  {
  Status 200 OK "Endereço cadastrado com sucesso"
  }

  {
  "timestamp": "2023-06-18T21:08:53.783766900Z",
  "code": 400,
  "httpStatus": "BAD_REQUEST",
  "mensagem": "Informar 'correlationID' no Header.",
  "path": "/consumo-energia/endereco"
  }
#### 
- `API de gestão de pessoas`:
Request:
  {
  "nome": "Lucas Ballico",
  "data_nascimento": "25/04/2000",
  "sexo": "Masculino",
  "grau_parentesco": "Filho"
  }
Response:
 {
  Status 200 OK "Pessoa cadastrada com sucesso"
 }

 {
  "timestamp": "2023-06-18T21:08:53.783766900Z",
  "code": 400,
  "httpStatus": "BAD_REQUEST",
  "mensagem": "Informar 'correlationID' no Header.",
  "path": "/consumo-energia/pessoa"
  }
#### 
- `API de gestão de eletrodomésticos`:
R}equest:
  {
  "nome": "Geladeira",
  "modelo": "Eletrolux",
  "potencia": "110"
  }
Response:
  {
  Status 200 OK "Eletrodomestico cadastrado com sucesso"
  }

  {
  "timestamp": "2023-06-18T21:08:53.783766900Z",
  "code": 400,
  "httpStatus": "BAD_REQUEST",
  "mensagem": "Informar 'correlationID' no Header.",
  "path": "/consumo-energia/eletrodomestico"
  }

#### 
- `API de gestão de usuários`:
  {
  "id": 1,
  "login": "Ballico",
  "senha": "3333",
  "flag": "S",
  "pessoa": [
  {
  "id": 1,
  "nome": "Lucianne",
  "data_nascimento": "07/12/1980",
  "cpf": "28681128888",
  "sexo": "Feminino",
  "grau_parentesco": "MAE",
  "endereco": [
  {
  "id": 1,
  "rua": "Joao de Deus",
  "numero": "111",
  "bairro": "Bela Vista",
  "cidade": "Osasco",
  "estado": "SP",
  "eletrodomestico": [
  {
  "id": 1,
  "nome": "Celular",
  "modelo": "IPHONE",
  "potencia": "1.0"
  }
  ]
  }
  ]
  }
  ]
  }
2. #### Rotas de cada API:
- `API de cadastro de endereço`: http://localhost:80/consumo-energia/endereco
- `API de gestão de pessoas`: http://localhost:80/consumo-energia/pessoa
- `API de gestão de eletrodomésticos`: http://localhost:80/consumo-energia/eletrodomestico
- `API de gestão de usuarios`: http://localhost:80/consumo-energia/usuarios

## 🎯 Desafios encontrados:
- Entendimento do pedido do usuário para realizar o relacionamento do banco de dados.
- 
## 📁 Acesso ao projeto
Você pode acessar os arquivos do projeto clicando [aqui](https://github.com/LucianneCharro/consumo-energia/tree/feature-segunda-fase/src).

