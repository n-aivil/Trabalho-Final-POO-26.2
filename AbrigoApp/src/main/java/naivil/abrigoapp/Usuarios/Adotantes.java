package naivil.abrigoapp.Usuarios;
import naivil.abrigoapp.Animais.Animais;
import naivil.abrigoapp.Exception.*;

public class Adotantes extends Usuarios{

    private Iterable<Animais> todosAnimais;
    private final ArrayList animaisSolicitados = new ArrayList();
	public Adotantes(String nome, int idade, String genero, String cpf, String email, String senha) throws NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, CpfInvalidoException, EmailInvalidoException, SenhaInvalidaException{
		super(nome, idade, genero, cpf, email, senha);
	}

	public void visualizarAnimaisDisponiveis(){
	}

	public void solicitarAdocao(int id){
	    boolean encontrado = false;

	    for(Animais a : todosAnimais){
			if(a.getId() == id){
			encontrado = true;

    			if(a.getStatusAdocao().equals("Adotado")){
    			    throw new AnimalIndisponivelException("Erro: Animal já adotado.\n");
    			}else{
    			    //logica de solicitação
                                animaisSolicitados.add(a);
    				System.out.println("Solicitação de adoção registrada para o animal: " + a.getNome());
    				return;
    			}
			}
		}
		if(!encontrado){
		    throw new AnimalIndisponivelException("Erro: Animal não existente.\n");
		}
	}
        
        public ArrayList getAnimaisSolicitados() {
            return animaisSolicitados;
        }

}
