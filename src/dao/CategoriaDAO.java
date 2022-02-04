package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listarComProdutos() throws SQLException {
        Categoria ultima = null;
        List<Categoria> categorias = new ArrayList<>();

        String sql = "select c.id, c.nome, p.id, p.nome, p.descricao from categoria c inner join"
                + " produto p on c.id = p.categoria_id";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    if (ultima == null || !ultima.getNome().equals(rst.getString(2))) {
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                        ultima = categoria;
                        categorias.add(categoria);
                    }
                    Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
                    ultima.adiciona(produto);
                }
            }
        }
        return categorias;
    }
}