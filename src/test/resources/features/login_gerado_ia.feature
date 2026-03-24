gherkin
# language: pt

Funcionalidade: Autenticação de Usuário Registrado no Nexus
  Como um usuário registrado
  Desejo fazer login com meu e-mail e senha
  Para acessar o sistema Nexus com segurança.

  Cenário: [Caminho Feliz] Login com sucesso usando e-mail e senha válidos
    Dado que estou na página de login do Nexus
    Quando eu preencher o campo de e-mail (data-test="email-input") com "usuario.valido@dominio.com"
    E eu preencher o campo de senha (data-test="password-input") com "MinhaSenha123"
    E eu clicar no botão "Login" (btn-primary)
    Então devo ser autenticado com sucesso
    E devo ser redirecionado para a página inicial do sistema Nexus

  Cenário: [Fluxo de Exceção] Tentativa de login com e-mail inválido
    Dado que estou na página de login do Nexus
    Quando eu preencher o campo de e-mail (data-test="email-input") com "emailinvalido"
    E eu preencher o campo de senha (data-test="password-input") com "SenhaValida1"
    E eu clicar no botão "Login" (btn-primary)
    Então devo ver a mensagem de erro "Formato de e-mail inválido."
    E devo permanecer na página de login

  Cenário: [Fluxo de Exceção] Tentativa de login com senha fora do limite de caracteres
    Dado que estou na página de login do Nexus
    Quando eu preencher o campo de e-mail (data-test="email-input") com "usuario@dominio.com"
    E eu preencher o campo de senha (data-test="password-input") com "curta"
    E eu clicar no botão "Login" (btn-primary)
    Então devo ver a mensagem de erro "A senha deve ter entre 6 e 12 caracteres."
    E devo permanecer na página de login

  Cenário: [Cenário de Borda] Tentativa de login com campos vazios (e-mail e senha)
    Dado que estou na página de login do Nexus
    Quando eu deixar o campo de e-mail (data-test="email-input") vazio
    E eu deixar o campo de senha (data-test="password-input") vazio
    E eu clicar no botão "Login" (btn-primary)
    Então devo ver a mensagem de erro "O e-mail é obrigatório."
    E devo ver a mensagem de erro "A senha é obrigatória."
    E devo permanecer na página de login
    # Prioriza erro de obrigatoriedade sobre o de formato, conforme requisito.

  Cenário: [Cenário Crítico] Bloqueio permanente da conta após 3 tentativas falhas de login
    Dado que estou na página de login do Nexus
    E que existe um usuário "usuario.bloqueado@dominio.com" com uma senha válida registrada
    Quando eu tentar fazer login com e-mail "usuario.bloqueado@dominio.com" e senha "SenhaIncorreta1" (1ª tentativa)
    Então devo ver a mensagem de erro "Credenciais inválidas."
    E quando eu tentar fazer login com e-mail "usuario.bloqueado@dominio.com" e senha "SenhaIncorreta2" (2ª tentativa)
    Então devo ver a mensagem de erro "Credenciais inválidas."
    E quando eu tentar fazer login com e-mail "usuario.bloqueado@dominio.com" e senha "SenhaIncorreta3" (3ª tentativa)
    Então devo ver a mensagem de erro "Credenciais inválidas."
    E devo ver a mensagem "Sua conta foi permanentemente bloqueada devido a múltiplas tentativas de login falhas."
    E ao tentar fazer login novamente com e-mail "usuario.bloqueado@dominio.com" e a senha válida
    Então devo ver a mensagem "Sua conta está bloqueada. Entre em contato com o suporte."
    E não devo conseguir acessar o sistema.
