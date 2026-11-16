package naivil.abrigoapp.Exception;

public class EmailInvalidoException extends RuntimeException{
    public EmailInvalidoException(String mensagem){
        super(mensagem);
    }
}
