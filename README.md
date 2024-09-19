

## Descrição

## Sistema de Controle de Despesas 
 O sistema de controle de despesas é em java que deixa o usuario fazer os gerenciamentos das despesas e dos pagamentos, ele tambem pode listar as mesmas. O sistema depois de fazer todos os cadastros e vc fechar o sistema ele salva todos os cadastros em arquivos txt.


## O sistema criado possui os seguintes aspectos:

=== Sistema de Controle de Despesas ===
1. Entrar Despesa
2. Anotar Pagamento
3. Listar Despesas em Aberto no período
4. Listar Despesas Pagas no período
5. Gerenciar Tipos de Despesa
6. Gerenciar Usuários
7. Sair

2. ## Entrar Despesa
   - Permite inserir uma nova despesa com detalhes como descrição, valor, data de vencimento e categoria.

3. ## Anotar Pagamento
   - Permite registrar um pagamento para uma despesa específica, incluindo a data e o valor do pagamento.

4. ## Listar Despesas
   - Exibe todas as despesas filtradas por status (pagas, pendentes) ou categoria. Inclui opções para editar e excluir despesas.

5. ## Gerenciar Tipos de Despesa
   - Cria, edita, lista e exclui tipos de despesa. Os tipos são armazenados em um arquivo de texto separado.

6. ## Gerenciar Usuários
   - Permite cadastrar, editar e listar usuários com login e senha. As senhas são criptografadas antes de serem armazenadas.

## Estrutura do Projeto

O projeto é organizado da seguinte forma:

## SistemaControleDespesas
│
├── src/
│   ├── Main.java
│   ├── MenuPrincipal.java
│   ├── Despesa.java
│   ├── Pagamento.java
│   ├── TipoDespesa.java
│   ├── Usuario.java
│   └── CriptografiaSenha.java
│
├── data/
│   ├── despesas.txt
│   ├── tipos_despesa.txt
│   └── usuarios.txtgit 
│
└── README.md
