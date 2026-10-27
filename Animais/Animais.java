public class Animais{
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private String estadoSaude;
    private String dataResgate;
    private String statusAdocao;

    public Animais(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, Sring statusAdocao){
        if(nome == null || nome.isEmpty()){System.out.println("Erro");}else{setNome(nome);}
        if(especie == null || especie.isEmpty()){System.out.println("Erro");}else{setEspecie(especie);}
        if(raca == null || raca.isEmpty()){System.out.println("Erro");}else{setRaca(raca);}
        if(idade<0){System.out.println("Erro");}else{setIdade(idade);}
        if(porte == null|| porte.isEmpty()){System.out.println("Erro")}else{setPorte(porte);}
        if(estadoSaude == null || estadoSaude.isEmpty()){System.out.println("Erro")}else{setEstadoSaude(estadoSaude);}
        if(dataResgate == null || dataResgate.isEmpty()){System.out.println("Erro")}else{setDataResgate(dataResgate);}
        if(statusAdocao == null || statusAdocao.isEmpty()){System.out.println("Erro")}else{setStatusAdocao(statusAdocao);}
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public void setRaca(String raca){
        this.raca = raca;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setPorte(String porte){
        this.porte = porte;
    }

    public void setEstadoSaude(String estadoSaude){
        this.estadoSaude = estadoSaude;
    }

    public void setDataResgate(String dataResgate){
        this.dataResgate = dataResgate;
    }

    public void setStatusAdocao(String statusAdocao){
        this.statusAdocao = statusAdocao;
    }

    public String getNome(){
        return nome;
    }

    public String getEspecie(){
        return especie;
    }

    public String getRaca(){
        return raca;
    }

    public int getIdade(){
        return idade;
    }

    public String getPorte(){
        return porte;
    }

    public String getEstadoSaude(){
        return estadoSaude;
    }

    public String getDataResgate(){
        return dataResgate;
    }

    public String getStatusAdocao(){
        return statusAdocao;
    }
}
