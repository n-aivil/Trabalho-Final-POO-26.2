package naivil.abrigoapp.Usuarios;

public class Administrador extends Usuarios{
    private List<Animais> animaisRemovidos = new ArrayList<>();
	// o administrador tem um email e senha padrões, mas precisa cadastrar as outras informações

	public Administrador(String nome, int idade, String genero, String cpf, String email, String senha) throws NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, CpfInvalidoException, EmailInvalidoException, SenhaInvalidaException{
		super(nome, idade, genero, cpf, email, senha);
	}

	public Animais cadastrarAnimaisRegastados(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao){
		Animais novoAnimal = new Animais(nome, especie, raca, idade, porte, estadoSaude, dataResgate, statusAdocao);
		todosAnimais.add(novoAnimal);
		System.out.println("Animal cadastrado com sucesso! Id gerado: " + novoAnimal.getId() + "\n");
		return novoAnimal;
	}

	public void editarAnimal(int id, String novoNome, String novaEspecie, String novaRaca, int novaIdade, String novoPorte, String novoEstadoSaude, String novaDataResgate, String novoStatusAdocao){
	    for(Animais a : todosAnimais){
			if(a.getId() == id){
				a.setNome(novoNome);
				a.setEspecie(novaEspecie);
				a.setRaca(novaRaca);
				a.setIdade(novaIdade);
				a.setPorte(novoPorte);
				a.setEstadoSaude(novoEstadoSaude);
				a.setDataResgate(novaDataResgate);
				a.setStatusAdocao(novoStatusAdocao);
			}
		}
		System.out.println("Animal com o ID " + id + " não foi encontrado.\n");
	}

	public void removerAnimal(int id){
	    for(Animais a : todosAnimais){
			if(a.getId() == id){
			    if(a.getStatusAdocao().equals("Adotado")){
					System.out.println("Esse animal já foi adotado, não é possível removê-lo.\n");
				}else{
				    animaisRemovidos.add(a);
					todosAnimais.remove(a);
					System.out.println("Animal removido com sucesso para o histórico.\n");
					return;
				}
			}
		}
		System.out.println("Animal com o ID " + id + " não foi encontrado.\n");
	}

	public void exibirAnimaisRemovidos(){
		System.out.println(animaisRemovidos);
	}

	public void exibirTodosAnimais(){
        System.out.println(todosAnimais);
	}

}
