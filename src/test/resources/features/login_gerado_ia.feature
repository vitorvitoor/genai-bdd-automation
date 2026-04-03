# language: pt
Funcionalidade: Autenticação de Usuário no Nexus

  Como um usuário registrado
  Eu quero acessar o sistema com meu e-mail e senha
  Para que eu possa utilizar as funcionalidades do Nexus

  Contexto:
    Dado que o sistema Nexus está online
    E que existe um usuário registrado com e-mail "usuario@dominio.com" e senha "SenhaValida123"

  @caminho_feliz
  Cenário: Login com sucesso usando credenciais válidas
    Dado que estou na tela de login
    Quando insiro o e-mail "usuario@dominio.com" no campo "data-test=email-input"
    E insiro a senha "SenhaValida123" no campo "data-test=password-input"
    E clico no botão "btn-primary=login-button"
    Então sou autenticado com sucesso
    E sou redirecionado para a página inicial do sistema

  @fluxo_excecao @email_invalido
  Cenário: Tentativa de login com e-mail em formato inválido
    Dado que estou na tela de login
    Quando insiro o e-mail "emailinvalido" no campo "data-test=email-input"
    E insiro a senha "SenhaValida123" no campo "data-test=password-input"
    E clico no botão "btn-primary=login-button"
    Então uma mensagem de erro "Formato de e-mail inválido" é exibida
    E permaneço na tela de login

  @fluxo_excecao @senha_invalida
  Cenário: Tentativa de login com senha muito curta (menos de 6 caracteres)
    Dado que estou na tela de login
    Quando insiro o e-mail "usuario@dominio.com" no campo "data-test=email-input"
    E insiro a senha "123" no campo "data-test=password-input"
    E clico no botão "btn-primary=login-button"
    Então uma mensagem de erro "A senha deve ter entre 6 e 12 caracteres" é exibida
    E permaneço na tela de login

  @fluxo_excecao @senha_invalida
  Cenário: Tentativa de login com senha muito longa (mais de 12 caracteres)
    Dado que estou na tela de login
    Quando insiro o e-mail "usuario@dominio.com" no campo "data-test=email-input"
    E insiro a senha "1234567890123" no campo "data-test=password-input"
    E clico no botão "btn-primary=login-button"
    Então uma mensagem de erro "A senha deve ter entre 6 e 12 caracteres" é exibida
    E permaneço na tela de login

  @cenario_borda @campos_vazios
  Cenário: Tentativa de login com campo de e-mail vazio
    Dado que estou na tela de login
    Quando deixo o campo de e-mail "data-test=email-input" vazio
    E insiro a senha "SenhaValida123" no campo "data-test=password-input"
    E clico no botão "btn-primary=login-button"
    Então uma mensagem de erro "E-mail é obrigatório" é exibida
    E permaneço na tela de login

  @cenario_borda @campos_vazios
  Cenário: Tentativa de login com campo de senha vazio
    Dado que estou na tela de login
    Quando insiro o e-mail "usuario@dominio.com" no campo "data-test=email-input"
    E deixo o campo de senha "data-test=password-input" vazio
    E clico no botão "btn-primary=login-button"
    Então uma mensagem de erro "Senha é obrigatória" é exibida
    E permaneço na tela de login

  @cenario_borda @campos_vazios @prioridade_erro
  Cenário: Tentativa de login com ambos os campos vazios, priorizando erro de obrigatoriedade do e-mail
    Dado que estou na tela de login
    Quando deixo o campo de e-mail "data-test=email-input" vazio
    E deixo o campo de senha "data-test=password-input" vazio
    E clico no botão "btn-primary=login-button"
    Então uma mensagem de erro "E-mail é obrigatório" é exibida
    E permaneço na tela de login

  @cenario_critico @bloqueio_conta
  Cenário: Bloqueio permanente da conta após 3 tentativas de login falhas
    Dado que estou na tela de login
    E que a conta do usuário "usuario@dominio.com" não está bloqueada
    Quando tento fazer login com o e-mail "usuario@dominio.com" e uma senha inválida "SenhaErrada1"
    E recebo uma mensagem de erro "Credenciais inválidas"
    E tento fazer login novamente com o e-mail "usuario@dominio.com" e uma senha inválida "SenhaErrada2"
    E recebo uma mensagem de erro "Credenciais inválidas"
    E tento fazer login pela terceira vez com o e-mail "usuario@dominio.com" e uma senha inválida "SenhaErrada3"
    Então uma mensagem de erro "Sua conta foi bloqueada devido a múltiplas tentativas falhas" é exibida
    E a conta do usuário "usuario@dominio.com" está bloqueada permanentemente
    E permaneço na tela de login
