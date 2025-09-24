import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
    private Connection connection;
    // I'm not understanding this.
    public int include(String sql, Object...args){ // I don't understand why the method need to be int and return the id generated from that inclusion.
        try{
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
        }catch (SQLException e){
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
