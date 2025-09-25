import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO2 {
    private Connection c;

    // don't make sense to name it include.
    // because it don't do just inserts.
    public int execute(String sql, Object ...args){
                        // SQL command | Values
        try {
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            setAtr(ps,args); // set the attributes for the statement like setString(1,s)
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setAtr(PreparedStatement ps, Object[] args){
        // index of the parameter in the SQL command
        try {
            int index = 0;
            // need to pass for all the args
            for(Object arg: args){ //
                if(arg instanceof String){ // confers if is the arg is a String, a Double or Int
                    ps.setString(index,(String) arg);
                } else if(arg instanceof Integer){
                    ps.setInt(index,(int) arg);
                } else if(arg instanceof Double){
                    ps.setDouble(index, (double) arg);
                }
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
            this.c = FabricConnection.getConnection();
            return this.c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
