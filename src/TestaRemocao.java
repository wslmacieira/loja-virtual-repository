import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {

        Connectionfactory factory = new Connectionfactory();
        Connection connection = factory.recuperarConexao();

        Statement stm = connection.createStatement();
        stm.execute("delete from produto where ID > 2");

        int count = stm.getUpdateCount();
        System.out.println("Quantidade de linhas que foram modificadas: " + count);
    }
}
