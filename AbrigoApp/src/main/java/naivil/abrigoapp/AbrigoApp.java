package naivil.abrigoapp;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import naivil.abrigoapp.Animais.Animais;
import naivil.abrigoapp.Database.AnimalDAO;
import naivil.abrigoapp.Database.Conexao;
import naivil.abrigoapp.pagsInicial.PagInicial;

public class AbrigoApp {

    public static void main(String[] args) {
        Conexao.criarTabelas();
        
        AnimalDAO dao = new AnimalDAO();
        List<Animais> listaDeAnimais = dao.listarTodos();
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        UIManager.put("Button.arc", 12);
        UIManager.put("Component.arc", 10);
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("Component.accentColor", Color.decode("#3b82f6"));
        
        java.awt.EventQueue.invokeLater(() -> {
            new PagInicial().setVisible(true);
        });
    }
}