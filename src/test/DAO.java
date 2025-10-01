package test;

import java.sql.*;

public class DAO {
    private Connection c;
    // The difference between the DAO and the Active Record is that DAO have one class for the persistence, and the AR have everything together.  


    //this method is just for commands that don't return some result in SQL (INSERT, DELETE, UPDATE).
    public int execute(String sql, Object ...args){
                        // SQL command | Values
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            setAtr(ps,args); // set the attributes for the statement like setString(1,s)
            if(ps.executeUpdate() > 0){
                ResultSet r = ps.getGeneratedKeys();
                if(r.next()){
                    return r.getInt(1);
                }
            }
            ps.close();
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // this method will return a resultSet from the Query (SELECT)
    public ResultSet query(String sql, Object... args){
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            setAtr(ps, args); // set the attributes for the statement like setString(1,s)
            ResultSet rs = ps.executeQuery();   
              
            return rs; // returning the resultSet to do some things with it 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // closes the connection 
    public void close(){
        try {
            getConnection().close();

        } catch (SQLException e) {
            throw new RuntimeException (e); 
        }finally{
            this.c = null;
        }

    }

    // set the type and the attribute for the prepraredStatement
    private void setAtr(PreparedStatement ps, Object[] args){
        // index of the parameter in the SQL command
        try {
            int index = 1;
            // need to pass for all the args
            for(Object arg: args){ //
                if(arg instanceof String){ // confers if is the arg is a String, a Double or Int
                    ps.setString(index,(String) arg);
                } else if(arg instanceof Integer){
                    ps.setInt(index,(int) arg);
                } else if(arg instanceof Double){
                    ps.setDouble(index, (double) arg);
                }
                index++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //method to get the connection and if it's null, generate one.
    private Connection getConnection(){
        try {
            if(this.c != null && !this.c.isClosed()){
                return this.c;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        c = FabricConnection.getConnection();
        return c;
    }
}
