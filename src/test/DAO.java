package test;

import java.sql.*;

public class DAO {
    private Connection connection;
    // This method set the attribute for the statement to complete de SQL command.
    // I don't understand very well this.

    // method that include what
    public int include(String sql, Object...args){ // I don't understand why the method need to be int and return the id generated from that inclusion.
        try{
            PreparedStatement pstmt = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            addAttribute(pstmt,args);

            if(pstmt.executeUpdate() > 0){
                ResultSet result = pstmt.getGeneratedKeys();
                if(result.next()){
                    return result.getInt(1);
                }
            }
            return -1;
        } catch (SQLException e){    // understand now, it stores the primary key generated from de database.
            throw new RuntimeException(e);
        }
    }

    // Set the attribute in include() for the SQL command
    private void addAttribute(PreparedStatement stmt, Object[] attributes){
        try {
            int index = 1; // Pass for all attributes -> correspond the index of the parameter.
            for(Object atrb: attributes){
                index++;
                if(atrb instanceof String){  //
                    stmt.setString(index,(String) atrb);
                } else if(atrb instanceof Integer){
                    stmt.setInt(index,(int) atrb);
                } else if(atrb instanceof Double){
                    stmt.setDouble(index, (double) atrb);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection(){ // It's seem that this is for more safety in the code.
        // The order of the condition matter:
        // if isClosed() comes first -> NullPointerException
        try {
            if(this.connection != null && !this.connection.isClosed() ){
                return connection;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connection = FabricConnection.getConnection();
        return connection;
    }
}
