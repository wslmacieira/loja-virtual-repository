import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Connectionfactory {

    public DataSource dataSource;

    public Connectionfactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3307/loja_virtual?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");

        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() throws SQLException {
        
        return this.dataSource.getConnection();
    }
}
