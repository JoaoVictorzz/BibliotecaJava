package Main;

import Comparator.ComparadorAutor;
import Comparator.ComparadorNomeUsuario;
import Comparator.ComparadorTitulo;
import Exception.LimiteEmprestimoException;
import Exception.LivroNaoEncontradoException;
import Exception.UsuarioNaoEncontradoException;
import Model.Usuario;
import Service.Biblioteca;
import Model.Livro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = -1;

        while(opcao != 15) {
            System.out.println("============ BIBLIOTECA ============");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Remover livro");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Remover usuário");
            System.out.println("5 - Buscar livro pelo ISBN");
            System.out.println("6 - Buscar usuário");
            System.out.println("7 - Listar livros");
            System.out.println("8 - Listar livros disponíveis");
            System.out.println("9 - Listar usuários");
            System.out.println("10 - Emprestar livro");
            System.out.println("11 - Devolver livro");
            System.out.println("12 - Ordenar livros por título(ordem alfabética)");
            System.out.println("13 - Ordenar livros por autor(ordem alfabética)");
            System.out.println("14 - Ordenar usuários por nome(ordem alfabética)");
            System.out.println("15 - Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.println("Título: ");
                    String titulo = sc.nextLine();
                    System.out.println("Autor: ");
                    String autor = sc.nextLine();
                    System.out.println("ISBN: ");
                    String isbn = sc.nextLine();

                    Livro livro = new Livro(titulo, autor, isbn);
                    biblioteca.cadastrarLivro(livro);
                    break;
                }
                case 2: {
                    System.out.println("Digite o isbn: ");
                    String isbn = sc.nextLine();

                    Livro livro = new Livro("", "", isbn);
                    biblioteca.removerLivro(livro);
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Usuario usuario = new Usuario(nome, id);
                    biblioteca.cadastrarUsuario(usuario);
                    break;
                }
                case 4: {
                    System.out.println("Digite o ID do usuário: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Usuario usuario = new Usuario("", id);
                    biblioteca.removerUsuario(usuario);
                    break;
                }
                case 5: {
                    System.out.println("Digite o ISBN do livro: ");
                    String isbn = sc.nextLine();
                    Livro livro = new Livro("", "", isbn);

                    try {
                        System.out.println(biblioteca.buscaISBN(livro));
                    }
                    catch(LivroNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 6: {
                    System.out.println("Digite o ID do usuário: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Usuario usuario = new Usuario("", id);

                    try {
                        System.out.println(biblioteca.buscaUsuario(usuario));
                    } catch (UsuarioNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 7: {
                    System.out.println("LIVROS: ");
                    biblioteca.listarLivros();
                    break;
                }
                case 8: {
                    System.out.println("LIVROS DISPONÍVEIS: ");
                    biblioteca.listarLivrosDisponiveis();
                    break;
                }
                case 9: {
                    System.out.println("USUÁRIOS: ");
                    biblioteca.listarUsuarios();
                    break;
                }
                case 10: {
                    System.out.println("Digite o ISBN do livro: ");
                    String isbn = sc.nextLine();

                    System.out.println("Digite o ID do usuário: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Livro livroBusca = new Livro("", "", isbn);
                    Usuario usuarioBusca = new Usuario("", id);

                    try {
                        Livro livro = biblioteca.buscaISBN(livroBusca);
                        Usuario usuario = biblioteca.buscaUsuario(usuarioBusca);
                        biblioteca.emprestarLivro(livro, usuario);

                    } catch (LivroNaoEncontradoException |
                             UsuarioNaoEncontradoException |
                             LimiteEmprestimoException e) {

                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 11: {
                    System.out.println("Digite o ISBN do livro: ");
                    String isbn = sc.nextLine();

                    System.out.println("Digite o ID do usuário: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Livro livroBusca = new Livro("", "", isbn);
                    Usuario usuarioBusca = new Usuario("", id);

                    try {
                        Livro livro = biblioteca.buscaISBN(livroBusca);
                        Usuario usuario = biblioteca.buscaUsuario(usuarioBusca);
                        biblioteca.devolverLivro(livro, usuario);
                    }
                    catch(LivroNaoEncontradoException | UsuarioNaoEncontradoException | LimiteEmprestimoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 12: {
                    List<Livro> livrosListaEmList = new ArrayList<>(biblioteca.getListaLivros());
                    System.out.println("Livros ordenados pelo título: ");
                    Collections.sort(livrosListaEmList, new ComparadorTitulo());
                    for (Livro livro : livrosListaEmList) {
                        System.out.println(livro);
                    }
                    break;
                }
                case 13: {
                    List<Livro> livrosListaEmList = new ArrayList<>(biblioteca.getListaLivros());
                    System.out.println("Livros ordenados pelo autor: ");
                    Collections.sort(livrosListaEmList, new ComparadorAutor());
                    for (Livro livro : livrosListaEmList) {
                        System.out.println(livro);
                    }
                    break;
                }
                case 14: {
                    List<Usuario> usuariosListaEmList = new ArrayList<>(biblioteca.getUsuariosLista());

                    System.out.println("Usuários ordenados pelo nome:");

                    Collections.sort(usuariosListaEmList, new ComparadorNomeUsuario());

                    for (Usuario usuario : usuariosListaEmList) {
                        System.out.println(usuario);
                    }

                    break;

                }
                case 15: {
                    System.out.println("Fechando biblioteca...");
                    break;
                }
                default: {
                    System.out.println("Opção inválida.");
                }
            }
        }

    }
}