package naivil.abrigoapp.Usuarios;
import naivil.abrigoapp.Exception.*;
public class Voluntarios extends Usuarios{
	public Voluntarios(String nome, int idade, String genero, String cpf, String email, String senha) throws NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, CpfInvalidoException, EmailInvalidoException, SenhaInvalidaException{
		super(nome, idade, genero, cpf, email, senha);
	}
}
