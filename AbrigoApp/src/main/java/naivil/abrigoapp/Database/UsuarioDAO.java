package naivil.abrigoapp.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import naivil.abrigoapp.Usuarios.Usuarios;
import naivil.abrigoapp.Usuarios.Administrador;
import naivil.abrigoapp.Usuarios.Veterinario;

public class UsuarioDAO {

    // 1. Inserir um novo usuário no banco
    public void inserir(Usuarios usuario, String tipo) {
        String sql = "INSERT INTO usuarios (nome, idade, genero, cpf, email, senha, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdade());
            stmt.setString(3, usuario.getGenero());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, tipo);
            
            stmt.executeUpdate();
            System.out.println("Usuário salvo no banco com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    // 2. Validar o Login (verifica se o email e a senha batem no banco)
    public boolean validarLogin(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            // Se encontrar algum registro, o login é válido
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
        }
        return false;
    }

    // 3. Listar todos os usuários cadastrados
    public List<String> listarEmailsUsuarios() {
        List<String> emails = new ArrayList<>();
        String sql = "SELECT email FROM usuarios";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                emails.add(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return emails;
    }
}