package Comparator;

import Model.Livro;
import java.util.Comparator;


public class ComparadorTitulo implements Comparator<Livro> {
    @Override
    public int compare(Livro l1, Livro l2) {
        return l1.getTitulo().compareTo(l2.getTitulo());
    }
}
