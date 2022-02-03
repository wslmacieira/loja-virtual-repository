import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import modelo.Produto;

public class TestaInsercaoEListagemComProduto {

    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("comoda2", "comoda2 vertical");

        try (Connection connection = new Connectionfactory().recuperarConexao()) {
            ProdutoDAO produtoDAO =   new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.stream().forEach(System.out::println);
        }
    }
}