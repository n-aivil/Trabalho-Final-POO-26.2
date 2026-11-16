package naivil.abrigoapp.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import naivil.abrigoapp.Animais.Animais;

public class AnimalDAO {

    public void inserir(Animais animal) {
        String sql = "INSERT INTO animais (nome, especie, raca, idade, porte, estado_saude, data_resgate, status_adocao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setString(5, animal.getPorte());
            stmt.setString(6, animal.getEstadoSaude());
            stmt.setString(7, animal.getDataResgate());
            stmt.setString(8, animal.getStatusAdocao());
            stmt.executeUpdate();
            System.out.println("Animal salvo no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar animal: " + e.getMessage());
        }
    }

    public List<Animais> listarTodos() {
        List<Animais> lista = new ArrayList<>();
        String sql = "SELECT * FROM animais";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Animais a = new Animais(
                    rs.getString("nome"),
                    rs.getString("especie"),
                    rs.getString("raca"),
                    rs.getInt("idade"),
                    rs.getString("porte"),
                    rs.getString("estado_saude"),
                    rs.getString("data_resgate"),
                    rs.getString("status_adocao")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar animais: " + e.getMessage());
        }
        return lista;
    }
}