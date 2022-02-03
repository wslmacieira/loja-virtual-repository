import java.sql.Connection;
import java.sql.SQLException;

import dao.ProdutoDAO;
import modelo.Produto;

public class TestaInsercaoComProduto {

    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("comoda2", "comoda2 vertical");

        try (Connection connection = new Connectionfactory().recuperarConexao()) {
            ProdutoDAO produtoDAO =   new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
        }
    }
}