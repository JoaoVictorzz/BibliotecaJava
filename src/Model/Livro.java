package Model;

import java.util.Objects;

public class Livro {
    private String titulo;
    final private String autor;
    final private String ISBN;
    private boolean disponibilidade = true;



    public Livro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }



    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;

        return Objects.equals(livro.getISBN(), ISBN);
    }



    @Override
    public String toString() {
        return "{ TÍTULO: " + titulo + "||" + "AUTOR: " + autor + "||" + "ISBN: " + ISBN + "||" + "DISPONÍVEL: " + disponibilidade + " }";
    }



    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }


    public String getISBN() {
        return ISBN;
    }


    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}