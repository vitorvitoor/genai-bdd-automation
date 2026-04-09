# language: pt
Funcionalidade: Login no Swag Labs
  Como um usuário do Swag Labs,
  Eu quero poder fazer login com diferentes tipos de contas,
  Para acessar o inventário ou ser devidamente informado sobre erros de acesso.

Contexto:
  Dado que estou na página de login do Swag Labs

Cenário: Login de Sucesso com credenciais válidas
  Quando preencho o campo "user-name" com "standard_user"
  E preencho o campo "password" com "secret_sauce"
  E clico no botão "login-button"
  Então devo ser direcionado para a página de inventário

Cenário: Login Bloqueado com usuário restrito
  Quando preencho o campo "user-name" com "locked_out_user"
  E preencho o campo "password" com "secret_sauce"
  E clico no botão "login-button"
  Então devo ver a mensagem de erro "Epic sadface: Sorry, this user has been locked out."

Cenário: Erro de Login com credenciais inválidas
  Quando preencho o campo "user-name" com "usuario_inexistente"
  E preencho o campo "password" com "senha_invalida"
  E clico no botão "login-button"
  Então devo ver a mensagem de erro "Epic sadface: Username and password do not match any user in this service"

Cenário: Borda - Erro de validação de campos vazios
  Quando deixo o campo "user-name" vazio
  E preencho o campo "password" com "secret_sauce"
  E clico no botão "login-button"
  Então devo ver a mensagem de erro "Epic sadface: Username is required"