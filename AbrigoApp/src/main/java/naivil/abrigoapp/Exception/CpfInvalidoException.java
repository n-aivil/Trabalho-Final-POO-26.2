package naivil.abrigoapp.Exception;

public class CpfInvalidoException extends RuntimeException{
    public CpfInvalidoException(String mensagem){
        super(mensagem);
    }
}
