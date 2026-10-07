package Model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario {
    private String nome;
    final private int ID;
    private Set<Livro> livrosEmprestados = new HashSet<>();



    public Usuario(String nome, int ID) {
        this.nome = nome;
        this.ID = ID;
    }



    public void pegarLivro(Livro livro) {
        if(livrosEmprestados.size() >= 3) {
            System.out.println("O usuário já possui 3 livros emprestados.");
            return;
        }

        if(livrosEmprestados.add(livro)) {
            System.out.println("Livro emprestado.");
        }
        else {
            System.out.println("O usuário já possui o livro.");
        }

    }



    @Override
    public String toString() {
        return "{ NOME: " + nome + "||" + "ID: " + ID + "||" + "\n" +
                livrosEmprestados + " }";
    }



    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return ID == usuario.ID;
    }



    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getID() {
        return ID;
    }


    public Set<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }
}
