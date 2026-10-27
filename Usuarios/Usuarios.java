public abstract class Usuarios{
	private String nome;
	private int idade;
	private String genero;
	private String cpf;
	private String email;
	private String senha;

	public Usuarios(String nome, int idade, String genero, String cpf, String email, String senha){
		// as mensagens tão só como erro pra gente saber que faz alguma coisa depois. coloca como exceção??
		if(nome == null || nome.isEmpty()){System.out.println("Erro");}else {setNome(nome);}
		if(idade <= 18 || idade >= 100){System.out.println("Erro");}else{setIdade(idade);}
		if(genero == null || genero.isEmpty()){System.out.println("Erro");}else{setGenero(genero);}
		if(cpf == null || cpf.isEmpty() || cpf.length() != 11){System.out.println("Erro");}else{setCpf(cpf);}
		if(email == null || email.isEmpty()/*tem que verificar se é email msm tbm)*/){System.out.println("Erro");}else{setEmail(email);}
		if(senha == null || senha.isEmpty()/*tem que verificar se a senha tá dentro dos padroes tambem */){System.out.println("Erro");}else{setSenha(senha);}
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}

	public void setIdade(int idade){
		this.idade = idade;
	}
	public int getIdade(){
		return this.idade;
	}

	public void setGenero(String genero){
		this.genero = genero;
	}
	public String getGenero(){
		return this.genero;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	public String getCpf(){
		return this.cpf;
	}

	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}
	public String getSenha(){
		return this.senha;
	}
}
