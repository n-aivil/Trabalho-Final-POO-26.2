package naivil.abrigoapp.Animais;

import java.util.ArrayList;
import java.util.List;
import naivil.abrigoapp.Exception.*;

public class Animais{

    protected static ArrayList<Animais> todosAnimais = new ArrayList<>();
    private static int contadorId = 1;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private String estadoSaude;
    private String dataResgate;
    private String statusAdocao;
    private final int id;
    private static List<Animais> animaisRemovidos = new ArrayList<>();

    public Animais(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao) {
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
    }
        public static List<Animais> getTodosAnimais() {
            return todosAnimais;
        }
        
        public List<Animais> getAnimaisRemovidos() {
            return animaisRemovidos;
        }
        
    public void setNome(String nome){
        if(nome == null || nome.isEmpty()){
            throw new NomeInvalidoException("Erro: Campo vazio.");
        }else{
            this.nome = nome;
        }
    }

    public void setEspecie (String especie){
        if(especie == null || especie.isEmpty()){
            throw new EspecieInvalidaException("Erro: Campo vazio.");
        }else{
         this.especie = especie;
        }
    }

    public void setRaca(String raca){
        if(raca == null || raca.isEmpty()){
            throw new RacaInvalidaException("Erro: Campo Vazio.");
        }else{
            this.raca = raca;
        }
    }

    public void setIdade(int idade){
        if(idade<0){
            throw new IdadeInvalidaException("Idade invalida.");
        }else{
            this.idade = idade;
        }
    }

    public void setPorte(String porte){
        if(porte == null|| porte.isEmpty()){
            throw new PorteInvalidoException("Erro: Campo vazio.");
        }else{
            this.porte = porte;
        }
    }

    public void setEstadoSaude(String estadoSaude){
        if(estadoSaude == null || estadoSaude.isEmpty()){
            throw new EstadoSaudeInvalidoException("Erro: Campo vazio.");
        }else{
            this.estadoSaude = estadoSaude;
        }
    }

    public void setDataResgate(String dataResgate){
        if(dataResgate == null || dataResgate.isEmpty()){
            throw new DataResgateInvalidaException("Erro: Campo vazio.");
        }else{
            this.dataResgate = dataResgate;
        }
    }

    public void setStatusAdocao(String statusAdocao){
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

