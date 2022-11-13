#  Yu-Gi-Oh Deck Builder
## _Build your own deck from Yu-Gi-Oh_

## Requisitos

- Uma IDE para rodar o código (Recomendável o [IntelliJ](https://www.jetbrains.com/pt-br/idea/download/#section=windows)).
- [JDK Oracle 19](https://www.oracle.com/java/technologies/downloads/#jdk19-windows) instalado.
- [Postman](https://www.postman.com/) para testes.

## Utilização

Após clonar o projeto, abra em uma IDE compativel com java (IntelliJ, Eclipse ou outra de sua preferência), procure a classe application que estara dentro da src/main/java/com/yugioh/YugiohDeckBuilder e execute a aplicação, aguarde a inicialização completa.

## ENDPOINTS

## POST - /deck/create

Payload exemplo:
```sh
{
    "name":"nome do deck",
    "cards":[
        {
            "name":"nome da carta"
        }
    ]
}
```
Cria um objeto na memória do computador do tipo Deck, que possui um nome do deck e um array de cartas com o nome das cartas que vão estar no deck, não é preciso escrever o nome completo da carta no JSON, porém é importante que a parte do nome escrita esteja correta para que a carta seja encontrada e o deck possa ser salvo na memória cache, ao final da requisição, o usuário receberá uma mensagem de confirmação da criação do deck junto do ID do deck, que será importante para a utilização dos proxímos endpoints, por isso anote. Caso a criação tenha falhado será retornado uma mensagem informando o erro.

## GET - /deck/{id}

Deve-se fazer a requisição informando o ID do deck desejado. Essa requisição consulta conforme o ID informado e traz como resposta o ID, nome e as cartas, as cartas serão acompanhadas das informações de ataque, defesa e level que foram fornecidas pela Yu-Gi-Oh! API by YGOPRODeck e também armazenada na memória cache. Caso haja alguma falha será retornado uma mensagem informando o erro.

## PUT - /deck/update/{id}

Deve-se fazer a requisição informando o ID do deck desejado. Também será necessário um JSON com as alterações que deseja seguindo a mesma estrutura do utilizado no create.
```sh
{
    "name":"nome do deck",
    "cards":[
        {
            "name":"nome da carta"
        }
    ]
}
```
No JSON é preciso conter as cartas que você deseja manter no deck e as cartas que deseja adicionar, caso contrário cartas serão removidas e só ficaram no deck cartas que estão no JSON, ao final o usuário receberá uma mensagem confirmando a atualização dos dados do deck. Caso haja alguma falha será retornado uma mensagem informando o erro.

## DELETE - /deck/remove/{id}

Deve-se fazer a requisição informando o ID do deck desejado. Essa requisição remove compeltamente da  memória cache do seu computador, retornando uma mensagem confirmando que o deck foi removido com sucesso. Caso haja alguma falha será retornado uma mensagem informando o erro.
