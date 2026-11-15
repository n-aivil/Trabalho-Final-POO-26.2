package naivil.abrigoapp.Usuarios;

public class Adotantes extends Usuarios{
	public Adotantes(String nome, int idade, String genero, String cpf, String email, String senha) throws NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, CpfInvalidoException, EmailInvalidoException, SenhaInvalidaException{
		super(nome, idade, genero, cpf, email, senha);
	}

	public void visualizarAnimaisDisponiveis(){
	}

	public void solicitarAdocao(int id) throws AnimalIndisponivelException{
	    boolean encontrado = false;

	    for(Animais a : todosAnimais){
			if(a.getId() == id){
			encontrado = true;

    			if(a.getStatusAdocao().equals("Adotado")){
    			    throw new AnimalIndisponivelException("Erro: Animal já adotado.\n");
    			}else{
    			    //logica de solicitação
    				System.out.println("Solicitação de adoção registrada para o animal: " + a.getNome());
    				return;
    			}
			}
		}
		if(!encontrado){
		    throw new AnimalIndisponivelException("Erro: Animal não existente.\n");
		}
	}

	public void consultarStatusAdocao(){

	}
}
