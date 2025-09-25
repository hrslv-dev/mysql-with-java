package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// That's an example of how works a DAO class:

public class DAOPessoa implements DAOInterface<Pessoa> {

    // it's better to user the connection like this for encapsulation
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String sql;

    private Connection getConnection(){ // It's seem that this is for more safety in the code.
       // The order of the condition matter:
        // if isClosed() comes first -> NullPointerException
        try {
            if(!this.connection.isClosed() &&this.connection != null){
                return connection;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connection = FabricConnection.getConnection();
        return connection;
    }
    // implementation of the interface DAO ->

    // An example using Pessoa as entity
    @Override
    public void save(Pessoa entity){
        try {
            sql = "INSERT INTO pessoas (nome) VALUES (?);";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, entity.getNome());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(Pessoa entity){ // Just changing the value of "sql"
        try {
            sql = "DELETE FROM pessoas WHERE nome=?;";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Pessoa> listAll(){
        try {
            List<Pessoa> pessoas = new ArrayList<>();

            getConnection();
            sql = "SELECT * FROM pessoas;";
            preparedStatement = getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                pessoas.add(new Pessoa(resultSet.getInt("codigo"), resultSet.getString("nome")));
            }
            preparedStatement.close();
            getConnection().close();

            return pessoas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Pessoa searchId(long id){
        try {
            getConnection();
            sql = "SELECT * FROM pessoas WHERE id=?;";
            preparedStatement = getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            return new Pessoa(resultSet.getInt("codigo"),resultSet.getString("nome"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
