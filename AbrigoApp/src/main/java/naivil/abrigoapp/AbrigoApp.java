/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package naivil.abrigoapp;

import naivil.abrigoapp.pagsInicial.PagInicial;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author n-aivil
 */
public class AbrigoApp {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Failed to initialize LaF" );
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
