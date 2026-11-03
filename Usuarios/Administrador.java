public class Administrador extends Usuarios{
	// o administrador tem um email e senha padrões, mas precisa cadastrar as outras informações

	public Administrador(String nome, int idade, String genero, String cpf, String email, String senha){
		super(nome, idade, genero, cpf, email, senha);
	}

	public Animais cadastrarAnimaisRegastados(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao){
		Animais novoAnimal = new Animais(nome, especie, raca, idade, porte, estadoSaude, dataResgate, statusAdocao);
		return novoAnimal;
	}
}
