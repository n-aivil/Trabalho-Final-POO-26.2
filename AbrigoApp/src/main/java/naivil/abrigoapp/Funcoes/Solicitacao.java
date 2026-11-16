/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naivil.abrigoapp.Funcoes;

import java.time.LocalDate;
import java.util.ArrayList;
import naivil.abrigoapp.Animais.Animais;
import naivil.abrigoapp.Usuarios.Usuarios;

/**
 *
 * @author n-aivil
 */
public class Solicitacao {
    public static final String PENDENTE = "Pendente";
    public static final String APROVADA = "Aprovada";
    public static final String REJEITADA = "Rejeitada";
    
    private static final ArrayList<Solicitacao> todas = new ArrayList<>();
    
    private final Animais animal;
    private final Usuarios solicitante;
    private final LocalDate data;
    private String status;
    private String motivo;
    
    public Solicitacao(Animais animal, Usuarios solicitante) {
        if (animal == null || solicitante == null) {
            throw new IllegalArgumentException("Animal e solicitante são obrigatórios.");
        }
        this.animal = animal;
        this.solicitante = solicitante;
        this.data = LocalDate.now();
        this.status = PENDENTE;
        todas.add(this);
    }

    public Animais getAnimal()        { return animal; }
    public Usuarios getSolicitante()  { return solicitante; }
    public LocalDate getData()        { return data; }
    public String getStatus()         { return status; }
    public String getMotivo()         { return motivo; }

    public void aprovar() {
        this.status = APROVADA;
        this.motivo = null;
    }

    public void rejeitar(String motivo) {
        this.status = REJEITADA;
        this.motivo = motivo;
    }

    public static ArrayList<Solicitacao> getTodas() {
        return new ArrayList<>(todas);
    }

    public static ArrayList<Solicitacao> pendentesDoAnimal(Animais animal) {
        ArrayList<Solicitacao> lista = new ArrayList<>();
        for (Solicitacao s : todas) {
            if (s.animal == animal && PENDENTE.equals(s.status)) lista.add(s);
        }
        return lista;
    }
}
