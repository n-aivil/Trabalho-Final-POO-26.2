package naivil.abrigoapp.Usuarios;
import java.util.List;
import naivil.abrigoapp.Animais.Animais;
import naivil.abrigoapp.Exception.*;

public class Voluntarios extends Usuarios{
    
    private List<Animais> animaisSobResponsabilidade = new ArrayList<>();
    private List<String> minhasSolicitacoesAdocao = new ArrayList<>();
    private List<String> historicoParticipacoes = new ArrayList<>();
    private List<String> notificacoes = new ArrayList<>();
    private String tipo;
        
	public Voluntarios(String nome, int idade, String genero, String cpf, String email, String senha) throws NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, CpfInvalidoException, EmailInvalidoException, SenhaInvalidaException{
		super(nome, idade, genero, cpf, email, senha);
                this.tipo = "Voluntário";
	}
        
        public void visualizarAnimaisDisponiveis(List<Animais> todosAnimais){
            if(todosAnimais == null || todosAnimais.isEmpty()){
                return;
            }
            
            boolean encontrou = false;
            for(Animais a : todosAnimais){
                if (a.getStatusAdocao().equalsIgnoreCase("Disponível") && !a.getEstadoSaude().equalsIgnoreCase("Crítico")) {
                     encontrou = true;
               }
            }
            if (!encontrou) {
                System.out.println("Nenhum animal disponível no momento.\n");
            }
        }
        
        public void
}
