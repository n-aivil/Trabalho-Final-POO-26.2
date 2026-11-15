package naivil.abrigoapp.Animais;

import java.util.ArrayList;

public class Animais{

    private static ArrayList<Animais> todosAnimais = new ArrayList<>();
    private static int contadorId = 1;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private String estadoSaude;
    private String dataResgate;
    private String statusAdocao;
    private int id;

    public Animais(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao){
        setNome(nome);
        setEspecie(especie);
        setRaca(raca);
        setIdade(idade);
        setPorte(porte);
        setEstadoSaude(estadoSaude);
        setDataResgate(dataResgate);
        setStatusAdocao(statusAdocao);
        this.id = contadorId++;
        todosAnimais.add(this);

    public void setNome(String nome) throws NomeInvalidoException{
        if(nome == null || nome.isEmpty()){
            throw new NomeInvalidoException("Erro: Campo vazio.");
        }else{
            this.nome = nome;
        }
    }

    public void setEspecie (String especie) throws EspecieInvalidaException{
        if(especie == null || especie.isEmpty()){
            throw new EspecieInvalidaException("Erro: Campo vazio.");
        }else{
         this.especie = especie;
        }
    }

    public void setRaca(String raca) throws RacaInvalidaException{
        if(raca == null || raca.isEmpty()){
            throw new RacaInvalidaException("Erro: Campo Vazio.");
        }else{
            this.raca = raca;
        }
    }

    public void setIdade(int idade) throws IdadeInvalidaException{
        if(idade<0){
            throw new IdadeInvalidaException("Idade invalida.");
        }else{
            this.idade = idade;
        }
    }

    public void setPorte(String porte) throws PorteInvalidoException{
        if(porte == null|| porte.isEmpty()){
            throw new PorteInvalidoException("Erro: Campo vazio.");
        }else{
            this.porte = porte;
        }
    }

    public void setEstadoSaude(String estadoSaude) throws EstadoSaudeInvalidoException{
        if(estadoSaude == null || estadoSaude.isEmpty()){
            throw new EstadoSaudeInvalidoException("Erro: Campo vazio.");
        }else{
            this.estadoSaude = estadoSaude;
        }
    }

    public void setDataResgate(String dataResgate) throws DataResgateInvalidaException{
        if(dataResgate == null || dataResgate.isEmpty()){
            throw new DataResgateInvalidaException("Erro: Campo vazio.");
        }else{
            this.dataResgate = dataResgate;
        }
    }

    public void setStatusAdocao(String statusAdocao) throws StatusAdocaoInvalidoException{
        if(statusAdocao == null || statusAdocao.isEmpty()){
            throw new StatusAdocaoInvalidoException("Erro: Campo vazio.");
        }else{
            this.statusAdocao = statusAdocao;
        }
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

    public int getId(){
        return id;
    }
}
