public class Veterinario extends Usuarios{
	private String crmv;

	public Veterinario(String nome, int idade, String genero, String cpf, String email, String senha, String crmv){
		super(nome, idade, genero, cpf, email, senha);
		setCrmv(crmv);
	}

	public void setCrmv(String crmv){
		this.crmv = crmv;
	}
	public String getCrmv(){
		return this.crmv;
	}
}
