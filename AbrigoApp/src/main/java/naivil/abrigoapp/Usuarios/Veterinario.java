package naivil.abrigoapp.Usuarios;

import naivil.abrigoapp.Exception.*;
import java.util.regex.Pattern;

public class Veterinario extends Usuarios {
    
    private String crmv;
    protected String tipo;
    private String especialidade;
    private String telefone;

    public Veterinario(String nome, int idade, String genero, String cpf, String email, String senha, String crmv) {
        super(nome, idade, genero, cpf, email, senha);
        setCrmv(crmv);
        setEspecialidade(especialidade);
        setTelefone(telefone);
        this.tipo = "Veterinario";
    }

    public void setCrmv(String crmv) {
        if (crmv == null || crmv.isEmpty()) {
            throw new CrmvInvalidoException("O CRMV não pode ser vazio.");
        }
        String regex = "^\\d{1,5}-CE$";
        if (!Pattern.matches(regex, crmv.toUpperCase())) {
            throw new CrmvInvalidoException("CRMV inválido. Deve seguir os padrões do Ceará (ex:1234-CE).");
        }
        this.crmv = crmv.toUpperCase();
    }

    public String getCrmv() {
        return this.crmv;
    }
    
    public void setEspecialidade(String especialidade){
        if(especialidade == null || especialidade.isEmpty()){
            throw new EspecialidadeInvalidaException("Especialidade não pode ser vazia. ");
        }else{
            this.especialidade = especialidade;
        }
    }
    
    public void setTelefone(String telefone){
        if(telefone == null || telefone.isEmpty()){
            throw new TelefoneInvalidoException("Telefone não pode ser vazio. ");
        }else{
            this.telefone = telefone;
        }
    }
}