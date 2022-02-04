import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("delete from produto where ID > ?");
        stm.setInt(1, 2);
        stm.execute();

        int count = stm.getUpdateCount();
        System.out.println("Quantidade de linhas que foram modificadas: " + count);
    }
}
