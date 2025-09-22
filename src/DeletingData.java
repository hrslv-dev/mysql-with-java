import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletingData {
    public static void deleteData(int codigo) throws SQLException {
        Connection con = FabricConnection.getConnection();
        String sql = "DELETE FROM pessoas WHERE codigo = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codigo);

        ps.executeUpdate();
    }

    public static void main(String[] args)throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Que dado deseja deletar, responda pelo código?");
        AlterData.consultData();

        int codigo = sc.nextInt();
        deleteData(codigo);
        System.out.println("Deletado com sucesso!");
    }
}
