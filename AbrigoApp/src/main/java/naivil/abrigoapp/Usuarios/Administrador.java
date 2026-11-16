package naivil.abrigoapp.Usuarios;

import java.util.ArrayList;
import java.util.List;
import naivil.abrigoapp.Animais.Animais;

public class Administrador extends Usuarios {
    private List<Animais> animaisRemovidos = new ArrayList<>();
    private List<String> historicoAdocoes = new ArrayList<>();
    private String tipo;
    
    public Administrador(String nome, int idade, String genero, String cpf, String email, String senha) throws Exception {
        super(nome, idade, genero, cpf, "adminabrigo@entrepatas.com", "costelinha161126");
        this.tipo = "Admnistrador";
    }

    public Animais cadastrarAnimaisRegastados(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao, List<Animais> todosAnimais) {
        Animais novoAnimal = new Animais(nome, especie, raca, idade, porte, estadoSaude, dataResgate, statusAdocao);
        if(todosAnimais != null){
          todosAnimais.add(novoAnimal);
        }
        System.out.println("Animal cadastrado com sucesso! Id gerado: " + novoAnimal.getId() + "\n");
        return novoAnimal;
    }

    public void editarAnimal(int id, String novoNome, String novaEspecie, String novaRaca, int novaIdade, String novoPorte, String novoEstadoSaude, String novaDataResgate, String novoStatusAdocao, List<Animais> todosAnimais) {
        for (Animais a : todosAnimais) {
            if (a.getId() == id) {
                a.setNome(novoNome);
                a.setEspecie(novaEspecie);
                a.setRaca(novaRaca);
                a.setIdade(novaIdade);
                a.setPorte(novoPorte);
                a.setEstadoSaude(novoEstadoSaude);
                a.setDataResgate(novaDataResgate);
                a.setStatusAdocao(novoStatusAdocao);
                System.out.println("Animal editado com sucesso!\n");
                return;
            }
        }
        System.out.println("Animal com o ID " + id + " não foi encontrado.\n");
    }

    public void removerAnimal(int id, List<Animais> todosAnimais) {
        if (todosAnimais == null || todosAnimais.isEmpty()) {
            System.out.println("Lista vazia.\n");
            return;
        }

        for (int i = 0; i < todosAnimais.size(); i++) {
            Animais a = todosAnimais.get(i);
            if (a.getId() == id) {
                if (a.getStatusAdocao().equals("Adotado")) {
                    System.out.println("Esse animal já foi adotado, não é possível removê-lo.\n");
                    return;
                } else {
                    animaisRemovidos.add(a);
                    todosAnimais.remove(i);
                    System.out.println("Animal removido com sucesso para o histórico.\n");
                    return;
                }
            }
        }
        System.out.println("Animal com o ID " + id + " não foi encontrado.\n");
    }

    public void exibirAnimaisRemovidos() {
        System.out.println(animaisRemovidos);
    }

    public void exibirTodosAnimais(List<Animais> todosAnimais) {
        System.out.println(todosAnimais);
    }
    
    public void aprovarAdocao(Animais animal, Usuarios solicitante){
        if(animal == null || solicitante == null){
            System.out.println("Erro: Animal ou solicitante inválido.\n");
            return;
        }
        
        if(animal.getStatusAdocao().equalsIgnoreCase("Adotado")){
            System.out.println("Esse animal já foi adotado!\n");
            return;
        }
        
        if(animal.getEstadoSaude().equalsIgnoreCase("Crítico")){
            System.out.println("Animais em tratamento crítico não podem ser adotados.\n");
            return;
        }
        
        animal.setStatusAdocao("Adotado");
        String registro = "Animal: " + animal.getNome() + " (ID: " + animal.getId() + ") | Adotante: " + solicitante.getNome() + " | Status: Aprovada";
        historicoAdocoes.add(registro);
        System.out.println("Adoção aprovada com sucesso! " + animal.getNome() + " agora pertence a " + solicitante.getNome() + ".\n");
    }
    
    public void rejeitarAdocao(Animais animal, Usuarios solicitante, String motivo){
        if(animal == null || solicitante == null){
            System.out.println("Erro: Animal ou solicitante inválido.\n");
            return;
        }
        
        if(!animal.getStatusAdocao().equalsIgnoreCase("Adotado")){
            animal.setStatusAdocao("Disponível");
        }
        
        String registro = "Animal: " + animal.getNome() + " (ID: " + animal.getId() + ") | Candidato: " + solicitante.getNome() + " | Status: Rejeitada (" + motivo + ")";
        historicoAdocoes.add(registro);
        System.out.println("Solicitação de adoção rejeitada. Motivo: " + motivo + "\n");
    }
    
    public void registrarDevolucao(Animais animal, Usuarios solicitante, String motivo){
        if(animal == null){
            System.out.println("Animal inválido.\n");
            return;
        }
        
        if(animal.getStatusAdocao().equalsIgnoreCase("Adotado")){
            animal.setStatusAdocao("Disponível");
            String registro = "DEVOLUÇÃO - Animal: " + animal.getNome() + " (ID: " + animal.getId() + ") | Ex-adotante: " + (solicitante != null ? solicitante.getNome() : "Não informado") + " | Motivo: " + motivo;
            historicoAdocoes.add(registro);
            
            System.out.println("Devolução registrada. O animal " + animal.getNome() + " está disponível novamente.\n");
        }else{
            System.out.println("Este animal não consta como adotado no sistema.\n");
        }
    }
    
    public void exibirHistoricoAdocoes(){
        if(historicoAdocoes.isEmpty()){
            System.out.println("Nenhuma movimentação de adoção registrada até o momento.\n");
            return;
        }
        
        for(String h : historicoAdocoes){
            System.out.println(h);
        }
    }
    
    public void removerUsuario(String cpf, List<Usuarios> todosUsuarios){
        if(todosUsuarios == null || todosUsuarios.isEmpty()){
            System.out.println("Lista de usuários vazia.\n");
            return;
        }
        
        for(int i = 0; i < todosUsuarios.size(); i++){
            Usuarios u = todosUsuarios.get(i);
            if(u.getCpf().equals(cpf)){
                if(u instanceof Administrador){
                    System.out.println("Não é permitido remover um Administrador do sistema\n");
                    return;
                }
                todosUsuarios.remove(i);
                System.out.println("Usuário removido com sucesso!\n");
                return;
            }
        }
        
        System.out.println("Usuário com CPF " + cpf + " não encontrado.\n");
    }
}