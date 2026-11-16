package naivil.abrigoapp.Exception;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(String mensagem){
        super(mensagem);
    }
}
