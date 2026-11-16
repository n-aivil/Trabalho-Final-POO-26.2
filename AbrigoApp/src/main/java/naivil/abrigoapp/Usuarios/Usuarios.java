package naivil.abrigoapp.Usuarios;

import java.util.regex.Pattern;
import java.util.ArrayList;
import naivil.abrigoapp.Exception.*;

public abstract class Usuarios{
    private static ArrayList<Usuarios> todosUsuarios = new ArrayList<>();
	private String nome;
	private int idade;
	private String genero;
	private String cpf;
	private String email;
	private String senha;

	public Usuarios(String nome, int idade, String genero, String cpf, String email, String senha){
		// as mensagens tão só como erro pra gente saber que faz alguma coisa depois. coloca como exceção?? sim, lançar as exceções.
		setNome(nome);
		setIdade(idade);
		setGenero(genero);
		setCpf(cpf);
		setEmail(email);
		setSenha(senha);
		todosUsuarios.add(this);
	}

	public void setNome(String nome) throws NomeInvalidoException{
	    if(nome == null || nome.isEmpty()){throw new NomeInvalidoException("Nome inválido.");}else {this.nome = nome;}
	}
	public String getNome(){
		return this.nome;
	}

	public void setIdade(int idade) throws IdadeInvalidaException{
	    if(idade < 18 || idade >= 100){throw new IdadeInvalidaException("Idade inválida");}else{this.idade = idade;}
	}
	public int getIdade(){
		return this.idade;
	}

	public void setGenero(String genero) throws GeneroInvalidoException{
	    if(genero == null || genero.isEmpty()){throw new GeneroInvalidoException("Erro: Campo vazio.");}else{this.genero = genero;}
	}
	public String getGenero(){
		return this.genero;
	}

	public void setCpf(String cpf) throws CpfInvalidoException{
	    if(cpf == null || cpf.isEmpty()){
			throw new CpfInvalidoException("Erro: Campo vazio");
			}
		else if(cpf.length() != 11){
		    throw new CpfInvalidoException("Seu CPF precisa ter 11 digitos.");
		}else{
		this.cpf = cpf;
		}
	}
	public String getCpf(){
		return this.cpf;
	}

	public void setEmail(String email) throws EmailInvalidoException{
	    String regex = "^[\\w._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
		Boolean isValid = Pattern.matches(regex, email);
		if(email == null || email.isEmpty()){
		    throw new EmailInvalidoException("Erro: Campo vazio.");
		}
		else if(!isValid){
		throw new EmailInvalidoException("Email invalido.");
		}else{
		this.email = email;
		}
	}
	public String getEmail(){
		return this.email;
	}

	public void setSenha(String senha) throws SenhaInvalidaException{
	    if(senha == null){
			throw new SenhaInvalidaException("Erro: Campo vazio.");
			}
		else if(senha.length() < 6 || senha.length() > 6){
		    throw new SenhaInvalidaException("A senha deve conter 6 caracteres.");
		}else{
		this.senha = senha;
		}
	}
	public String getSenha(){
		return this.senha;
	}

	public static Voluntarios cadastrarVoluntario(String nome, int idade, String genero, String cpf, String email, String senha){
		Voluntarios novoVoluntario = new Voluntarios(nome, idade, genero, cpf, email, senha);
		return novoVoluntario;
	}

	public static Veterinario cadastrarVeterinario(String nome, int idade, String genero, String cpf, String email, String senha, String crmv){
		Veterinario novoVeterinario = new Veterinario(nome, idade, genero, cpf, email, senha, crmv);
		return novoVeterinario;
	}

	public static Adotantes cadastrarAdotantes(String nome, int idade, String genero, String cpf, String email, String senha){
		Adotantes novoAdotante = new Adotantes(nome, idade, genero, cpf, email, senha);
		return novoAdotante;
	}

	public static Usuarios autenticar(String emailDigitado, String senhaDigitada){
	    for(Usuarios u : todosUsuarios){
			if(u.getEmail().equals(emailDigitado) && u.getSenha().equals(senhaDigitada)){
			    return u;
			}
		}
		return null;
	}
}
