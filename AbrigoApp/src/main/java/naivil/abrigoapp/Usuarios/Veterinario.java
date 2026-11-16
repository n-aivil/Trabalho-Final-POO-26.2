package naivil.abrigoapp.Usuarios;
import naivil.abrigoapp.Exception.*;
public class Veterinario extends Usuarios{
	private String crmv;

	public Veterinario(String nome, int idade, String genero, String cpf, String email, String senha, String crmv){
		super(nome, idade, genero, cpf, email, senha);
		setCrmv(crmv);
	}

	public void setCrmv(String crmv) throws CrmvInvalidoException{
	    if(crmv == null || crmv.isEmpty()){
			throw new CrmvInvalidoException("O CRMV não pode ser vazio.");
			}
		String regex = "^\\d{1,5}-CE$";
		if(!Pattern.mathces(regex, crmv.toUpperCase())){
		    throw new CrmvInvalidoException("CRMV inválido. Deve seguir os padrões do Ceará (ex:1234-CE).");
		}
		this.crmv = crmv.toUpperCase();
	}
	public String getCrmv(){
		return this.crmv;
	}
}
