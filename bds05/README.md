# Desafio
TAREFA: MovieFlix domínio e autorização

Implemente as funcionalidades necessárias para que os testes do projeto abaixo passem:
https://github.com/devsuperior/bds05

## Visão geral do sistema MovieFlix

### Protótipos de tela

- https://www.figma.com/file/qmduL2GXrMrqRLyFjFCk56/MovieFlix-web

O sistema MovieFlix consiste em um banco de filmes, os quais podem ser listados e avaliados pelos usuários.   
Usuários podem ser visitantes (VISITOR) e membros (MEMBER).   
Apenas usuários membros podem inserir avaliações no sistema.  
Ao acessar o sistema, o usuário deve fazer seu login.   
Apenas usuários logados podem navegar nos filmes.   
Logo após fazer o login, o usuário vai para a listagem de filmes, que mostra os filmes de forma paginada, ordenados alfabeticamente por título.   
O usuário pode filtrar os filmes por gênero.  
Ao selecionar um filme da listagem, é mostrada uma página de detalhes, onde é possível ver todas informações do filme, e também suas avaliações.   
Se o usuário for MEMBER, ele pode ainda registrar uma avaliação nessa tela.  
Um usuário possui nome, email e senha, sendo que o email é seu nome de usuário.   
Cada filme possui um título, subtítulo, uma imagem, ano de lançamento, sinopse, e um gênero.   
Os usuários membros podem registrar avaliações para os filmes. Um mesmo usuário membro pode deixar mais de uma avaliação para o mesmo filme.  


### O que devo fazer para resolver o desafio?
Basicamente você deverá cumprir três etapas:
- Implementar o modelo conceitual proposto, com seed do banco de dados.
- Incluir a infraestrutura de exceções, validação e segurança ao projeto.
- Implementar o endpoint mostrado abaixo.

### Requisitos do seed para os testes passarem:
Seu seed deve conter dois usuários:  
1) Usuário somente com perfil VISITOR:  
      email: bob@gmail.com  
      senha: 123456
2) Usuário com perfil MEMBER:  
      email: ana@gmail.com  
      senha: 123456  

  
### Endpoint que deverá ser feito:
1) Obter o perfil do usuário logado
   GET /users/profile

### Modelo Conceitual
![Modelo Conceitual](./src/main/resources/files/modelo-conceitual.png)

