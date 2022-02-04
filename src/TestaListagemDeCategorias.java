import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import modelo.Categoria;

public class TestaListagemDeCategorias {

    public static void main(String[] args) throws SQLException {
        
        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDecaCategorias = categoriaDAO.listar();
            listaDecaCategorias.stream().forEach(c -> System.out.println(c.getNome()));
        }
    }
}