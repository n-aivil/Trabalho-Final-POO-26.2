import java.time.LocalTime;

public class Notificacao{
    private final String titulo;
    private final String mensagem;
    private final LocalTime hora;

    public Notificacao(String titulo, String mensagem){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.hora = LocalTime.now();
    }

    public String getTitulo() { return titulo; }
    public String getMensagem() { return mensagem; }
    public LocalTime getHora() { return hora; }
}
