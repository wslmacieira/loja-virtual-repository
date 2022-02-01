import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionfactory {

    public Connection recuperarConexao() throws SQLException {
        return DriverManager
                .getConnection("jdbc:mysql://localhost:3307/loja_virtual?useTimezone=true&serverTimezone=UTC", "root",
                        "root");
    }
}
