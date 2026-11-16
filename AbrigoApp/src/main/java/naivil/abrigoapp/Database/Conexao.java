package naivil.abrigoapp.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private static final String URL = "jdbc:sqlite:abrigo.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void criarTabelas() {
        String sqlAnimais = "CREATE TABLE IF NOT EXISTS animais ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT, "
                + "especie TEXT, "
                + "raca TEXT, "
                + "idade INTEGER, "
                + "porte TEXT, "
                + "estado_saude TEXT, "
                + "data_resgate TEXT, "
                + "status_adocao TEXT"
                + ");";

        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "cpf TEXT PRIMARY KEY, "
                + "nome TEXT, "
                + "idade INTEGER, "
                + "genero TEXT, "
                + "email TEXT, "
                + "senha TEXT, "
                + "tipo TEXT"
                + ");";

        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sqlAnimais);
            stmt.execute(sqlUsuarios);
            System.out.println("Tabelas criadas com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}