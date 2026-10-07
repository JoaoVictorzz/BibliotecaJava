package Service;

import Exception.LimiteEmprestimoException;
import Exception.LivroNaoEncontradoException;
import Exception.UsuarioNaoEncontradoException;
import Model.Livro;
import Model.Usuario;

import java.util.HashSet;
import java.util.Set;

public class Biblioteca {
    final private Set<Usuario> usuariosLista = new HashSet<>();
    final private Set<Livro> listaLivros = new HashSet<>();



    @Override
    public String toString() {
        return "Biblioteca{" +
                "usuariosLista=" + usuariosLista +
                ", listaLivros=" + listaLivros +
                '}';
    }



    public void cadastrarLivro(Livro livro) {
        if(!listaLivros.contains(livro)) {
            listaLivros.add(livro);
            System.out.println("Livro adicionado na biblioteca.");
        }
        else {
            System.out.println("Livro já cadastrado.");
        }
    }



    public void removerLivro(Livro livro) {
        if(listaLivros.contains(livro)) {
            listaLivros.remove(livro);
            System.out.println("Livro removido da biblioteca.");
        }
        else {
            System.out.println("Livro não está na biblioteca.");
        }
    }



    public void cadastrarUsuario(Usuario usuario) {
        if(!usuariosLista.contains(usuario)) {
            usuariosLista.add(usuario);
            System.out.println("Usuário cadastrado na biblioteca.");
        }
        else {
            System.out.println("Usuário já está cadastrado.");
        }
    }



    public void removerUsuario(Usuario usuario) {
        if(usuariosLista.contains(usuario)) {
            if(usuario.getLivrosEmprestados().isEmpty()) {
                usuariosLista.remove(usuario);
                System.out.println("Usuário removido da biblioteca.");
            }
            else {
                System.out.println("Não é possível remover: usuário possui livros emprestados.");
            }
        }
        else {
            System.out.println("Usuário não está na biblioteca.");
        }
    }



    public Livro buscaISBN(Livro livro) {
        for(Livro livroDaBiblioteca: listaLivros) {
            if(livro.equals(livroDaBiblioteca)) {
                System.out.println("Livro encontrado.");
                return livroDaBiblioteca;
            }
        }
        throw new LivroNaoEncontradoException("Livro não encontrado.");
    }



    public Usuario buscaUsuario(Usuario usuario) {
        for(Usuario usuarioDaBiblioteca: usuariosLista) {
            if(usuario.equals(usuarioDaBiblioteca)) {
                System.out.println("Usuário encontrado.");
                return usuario;
            }
        }
       throw new UsuarioNaoEncontradoException("Usuário não encontrado");
    }



    public void listarLivros() {
        System.out.println("Lista de livros da biblioteca: ");
        for(Livro livro: listaLivros) {
            System.out.println(livro);
        }
    }



    public void listarLivrosDisponiveis() {
        System.out.println("Lista de livros disponíveis da biblioteca: ");
        for(Livro livro: listaLivros) {
            if(livro.isDisponibilidade()) {
                System.out.println(livro);
            }
        }
    }



    public void listarUsuarios() {
        System.out.println("Usuários da biblioteca: ");
        for(Usuario usuario: usuariosLista) {
            System.out.println(usuario);
        }
    }



    public void emprestarLivro(Livro livro, Usuario usuario) {
        if(listaLivros.contains(livro)) {
            if(usuariosLista.contains(usuario)) {
                if(livro.isDisponibilidade()) {
                    if(usuario.getLivrosEmprestados().size() < 3) {
                        System.out.println("O Livro " + livro + " foi emprestado para " + usuario);
                        usuario.getLivrosEmprestados().add(livro);
                        livro.setDisponibilidade(false);
                    }
                    else {
                        throw new LimiteEmprestimoException("O usuário já possui 3 livros.");
                    }
                }
                else {
                    System.out.println("O livro não está disponível.");
                }
            }
            else {
                System.out.println("O usuário não está na biblioteca.");
            }
        }
        else {
            System.out.println("O livro não está na biblioteca.");
        }

    }



    public void devolverLivro(Livro livro, Usuario usuario) {
        if(listaLivros.contains(livro)) {
            if(usuariosLista.contains(usuario)) {
                if(usuario.getLivrosEmprestados().contains(livro)) {
                    System.out.println("Livro devolvido.");
                    livro.setDisponibilidade(true);
                    usuario.getLivrosEmprestados().remove(livro);
                }
                else {
                    System.out.println("O usuário não possui o livro.");
                }
            }
            else {
                System.out.println("O usuário não está na biblioteca.");
            }
        }
        else {
            System.out.println("O livro não está na biblioteca");
        }
    }



    public Set<Usuario> getUsuariosLista() {
        return new HashSet<>(usuariosLista);
    }

    public Set<Livro> getListaLivros() {
        return new HashSet<>(listaLivros);
    }
}