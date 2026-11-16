package naivil.abrigoapp.Usuarios;

import java.util.List;
import naivil.abrigoapp.Animais.Animais;

public class Administrador extends Usuarios{

    private boolean todosAnimais;
    private boolean animaisRemovidos;

	public Administrador(String nome, String genero, String cpf, String email, String senha, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao) {
		super(nome, idade, genero, cpf, email, senha);
	}

	public Animais cadastrarAnimaisRegastados(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao){
		Animais novoAnimal = new Animais(nome, especie, raca, idade, porte, estadoSaude, dataResgate, statusAdocao);
		System.out.println("Animal cadastrado com sucesso! Id gerado: " + novoAnimal.getId() + "\n");
		return novoAnimal;
	}

            public void editarAnimal(int id, String novoNome, String novaEspecie, String novaRaca, int novaIdade, String novoPorte, String novoEstadoSaude, String novaDataResgate, String novoStatusAdocao, Iterable<Animais> todosAnimais){
            for(Animais a : todosAnimais){
                if (a.getId() == id) {{
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
  }
            
   public void removerAnimal(int id) {
    List<Animais> lista = getTodosAnimais();
    
    if (lista == null) {
        System.out.println("Lista vazia.\n");
        return;
    }

    for (int i = 0; i < lista.size(); i++) {
        Animais a = lista.get(i);
        if (a.getId() == id) {
            if (a.getStatusAdocao().equals("Adotado")) {
                System.out.println("Esse animal já foi adotado, não é possível removê-lo.\n");
                return;
            } else {
                getAnimaisRemovidos().add(a);
                lista.remove(i);
                System.out.println("Animal removido com sucesso para o histórico.\n");
                return;
            }
        }
    }
    System.out.println("Animal com o ID " + id + " não foi encontrado.\n");
}
            
	public void exibirAnimaisRemovidos(){
            System.out.println(animaisRemovidos);
	}

	public void exibirTodosAnimais(){
            System.out.println(todosAnimais);
	}

    private Object getAnimaisRemovidos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<Animais> getTodosAnimais() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
