package test.ar;

import java.sql.*;
import test.FabricConnection;


public class Produto implements ActiveRecord{
    private double value; 
    private String name;
    private int id; 

    private Connection connection; 

    public Produto(String name, double value) {
        this.name = name;
        this.value = value;
    }
    
    private Connection getConnection(){
        try {
            if(connection!=null && !connection.isClosed()){
                return connection;
            } else{
                connection = FabricConnection.getConnection();
                return connection;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(){
       try {
           PreparedStatement ps = getConnection().prepareStatement("INSERT INTO Produtos (nome,valor) VALUES (?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setString(1, this.getName());
           ps.setDouble(2, this.getValue());
                                // Returns a int that corresponds to the affected rows in the table
           int affectedRows = ps.executeUpdate();
            System.out.println(affectedRows);
            // output = ?         
           // If the affected rows are bigger than 0 -> result receive the generatedkey from the id in the table  
           if(affectedRows > 0){
                try (ResultSet generatedKeys = ps.getGeneratedKeys()){
                    // if have a generated key -> id from the object receive the value from the collumn 1
                    if(generatedKeys.next()){
                        this.id = generatedKeys.getInt(1);
                    }
                }
           }

           ps.close();
           getConnection().close();

       } catch (SQLException e) {
            throw new RuntimeException(e); 
       }
    }
    @Override
    public void delete(){
        try {
            PreparedStatement ps = getConnection().prepareStatement("DELETE FROM Produtos WHERE nome=?;");
            ps.setString(1, this.getName());
            ps.executeUpdate();
            ps.close();
            getConnection().close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(){
        try{
            PreparedStatement ps = getConnection().prepareStatement("UPDATE Produtos SET nome=?,valor=? WHERE id=?;");
            ps.setString(1, this.getName());
            ps.setDouble(2, this.getValue()); 
            ps.setInt(3,this.getId());

            ps.executeUpdate();
            ps.close();
            getConnection().close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    
}
