Sistema de gerenciamento de uma biblioteca desenvolvido em Java, com foco na aplicação de conceitos de Programação Orientada a Objetos e Collections.

Funcionalidades:

Cadastro de livros
Cadastro de usuários
Empréstimo e devolução de livros
Busca de livros e usuários
Listagem de livros e usuários
Ordenação de livros por diferentes critérios
Controle de livros emprestados
Limite de empréstimos por usuário
Tratamento de exceções específicas

Estrutura do projeto:
```text
src/
├── Comparator/
│   ├── ComparadorAutor.java
│   ├── ComparadorNomeUsuario.java
│   └── ComparadorTitulo.java
├── Exception/
│   ├── LimiteEmprestimoException.java
│   ├── LivroNaoEncontradoException.java
│   └── UsuarioNaoEncontradoException.java
├── Main/
│   └── BibliotecaApp.java
├── Model/
│   ├── Livro.java
│   └── Usuario.java
└── Service/
    └── Biblioteca.java

Conceitos utilizados:

Programação Orientada a Objetos
Encapsulamento
Classes e objetos
Set e ArrayList
HashSet
equals() e hashCode()
Comparator
Exceções personalizadas
try/catch
Modificadores de acesso
final
Separação de responsabilidades

Tecnologias:

Java
IntelliJ IDEA
Git/GitHub

Objetivo:

Projeto desenvolvido para praticar conceitos fundamentais de Java e Programação Orientada a Objetos, aplicando-os na construção de um sistema de gerenciamento de biblioteca.
