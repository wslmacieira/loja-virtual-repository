import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory criaConexao = new ConnectionFactory();
        Connection connection = criaConexao.recuperarConexao();

        System.out.println("Fechando conexão!");
        connection.close();
    }
}
