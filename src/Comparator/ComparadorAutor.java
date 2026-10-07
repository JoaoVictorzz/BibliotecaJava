package Comparator;

import Model.Livro;
import java.util.Comparator;

public class ComparadorAutor implements Comparator<Livro> {
    @Override
    public int compare(Livro l1, Livro l2) {
        return l1.getAutor().compareTo(l2.getAutor());
    }
}
