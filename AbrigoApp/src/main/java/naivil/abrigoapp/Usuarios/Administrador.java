package naivil.abrigoapp.Usuarios;

import java.util.ArrayList;
import java.util.List;
import naivil.abrigoapp.Animais.Animais;

public class Administrador extends Usuarios {
    private List<Animais> animaisRemovidos = new ArrayList<>();
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
}