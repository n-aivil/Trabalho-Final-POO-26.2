/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naivil.abrigoapp.Funcoes;

import java.time.LocalDate;

/**
 *
 * @author n-aivil
 */
public class Atividade {
    private final String titulo;
    private final String descricao;
    private final LocalDate prazo;
    private boolean concluida;
    
    public Atividade(String titulo, String descricao, LocalDate prazo){
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = false;
    }
    
    public String getTitulo()    { return titulo; }
    public String getDescricao() { return descricao; }
    public LocalDate getPrazo()  { return prazo; }
    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }
}
