package naivil.abrigoapp.Usuarios;

import java.util.ArrayList;
import java.util.List;
import naivil.abrigoapp.Animais.Animais;
import naivil.abrigoapp.Exception.*;

public class Voluntarios extends Usuarios {
    private List<Animais> animaisSobResponsabilidade = new ArrayList<>();
    private List<String> minhasSolicitacoesAdocao = new ArrayList<>();
    private List<String> historicoParticipacoes = new ArrayList<>();
    private List<String> notificacoes = new ArrayList<>();

    public Voluntarios(String nome, int idade, String genero, String cpf, String email, String senha) throws NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, CpfInvalidoException, EmailInvalidoException, SenhaInvalidaException {
        super(nome, idade, genero, cpf, email, senha);
    }

    public void visualizarAnimaisDisponiveis(List<Animais> todosAnimais) {
        if (todosAnimais == null || todosAnimais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado no momento.\n");
            return;
        }

        boolean encontrou = false;
        for (Animais a : todosAnimais) {
            if (a.getStatusAdocao().equalsIgnoreCase("Disponível") && !a.getEstadoSaude().equalsIgnoreCase("Crítico")) {
                System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | Espécie: " + a.getEspecie() + " | Raça: " + a.getRaca() + " | Idade: " + a.getIdade());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum animal disponível no momento.\n");
        }
    }

    public void solicitarAdocao(Animais animal){
        if (animal == null) {
            throw new AnimalIndisponivelException("Animal não encontrado.");
        }
        if (!animal.getStatusAdocao().equalsIgnoreCase("Disponível") || animal.getEstadoSaude().equalsIgnoreCase("Crítico")) {
            throw new AnimalIndisponivelException("Este animal está indisponível para adoção.");
        }

        animal.setStatusAdocao("Em processo de adoção");
        String pedido = "Animal: " + animal.getNome() + " (ID: " + animal.getId() + ") | Status: Aguardando aprovação";
        minhasSolicitacoesAdocao.add(pedido);
        System.out.println("Solicitação de adoção enviada com sucesso!\n");
    }

    public void consultarMinhasSolicitacoes() {
        if (minhasSolicitacoesAdocao.isEmpty()) {
            System.out.println("Nenhuma solicitação de adoção realizada.\n");
            return;
        }
        for (String s : minhasSolicitacoesAdocao) {
            System.out.println(s);
        }
    }

    public void participarDeAtividade(String nomeAtividade, String data) {
        String registro = "Atividade: " + nomeAtividade + " | Data: " + data + " | Status: Inscrito";
        historicoParticipacoes.add(registro);
        System.out.println("Inscrição confirmada na atividade: " + nomeAtividade + "\n");
    }

    public void exibirHistoricoParticipacoes() {
        if (historicoParticipacoes.isEmpty()) {
            System.out.println("Nenhuma participação registrada.\n");
            return;
        }
        for (String h : historicoParticipacoes) {
            System.out.println(h);
        }
    }

    public void adicionarAnimalResponsabilidade(Animais animal) {
        if (animal != null && !animaisSobResponsabilidade.contains(animal)) {
            animaisSobResponsabilidade.add(animal);
            System.out.println("Animal adicionado à sua responsabilidade.\n");
        }
    }

    public void acompanharAnimaisSobResponsabilidade() {
        if (animaisSobResponsabilidade.isEmpty()) {
            System.out.println("Nenhum animal sob sua responsabilidade.\n");
            return;
        }
        for (Animais a : animaisSobResponsabilidade) {
            System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | Saúde: " + a.getEstadoSaude() + " | Status: " + a.getStatusAdocao());
        }
    }

    public void adicionarNotificacao(String mensagem) {
        notificacoes.add(mensagem);
    }

    public void exibirNotificacoes() {
        if (notificacoes.isEmpty()) {
            System.out.println("Nenhuma notificação nova.\n");
            return;
        }
        for (String n : notificacoes) {
            System.out.println(n);
        }
    }
}