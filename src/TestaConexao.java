import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        Connectionfactory criaConexao = new Connectionfactory();
        Connection connection = criaConexao.recuperarConexao();

        System.out.println("Fechando conexão!");
        connection.close();
    }
}
