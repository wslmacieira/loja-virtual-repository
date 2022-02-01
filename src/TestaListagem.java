import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
    public static void main(String[] args) throws SQLException{
        
        Connectionfactory criaConexao = new Connectionfactory();
        Connection con = criaConexao.recuperarConexao();
       
        Statement stm = con.createStatement();
        stm.execute("SELECT ID, NOME, DESCRICAO FROM produto");

        ResultSet rst = stm.getResultSet();

        while (rst.next()) {
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String nome = rst.getString("NOME");
            System.out.println(nome);
            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);
        }

        
        con.close();
    }
}
