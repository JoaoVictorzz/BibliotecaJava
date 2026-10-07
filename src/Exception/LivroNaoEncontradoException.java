package Exception;

public class LivroNaoEncontradoException extends RuntimeException{
    public LivroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
