package naivil.abrigoapp.Usuarios;

public class Adotantes extends Usuarios{
	public Adotantes(String nome, int idade, String genero, String cpf, String email, String senha) throws NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, CpfInvalidoException, EmailInvalidoException, SenhaInvalidaException{
		super(nome, idade, genero, cpf, email, senha);
	}
}
