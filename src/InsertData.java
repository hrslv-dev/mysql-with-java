import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu nome: ");
        String nome = sc.nextLine();

        Connection con = FabricConnection.getConnection();

        String sql = "INSERT INTO pessoas (nome) " +
                "VALUES (?)";
        PreparedStatement pSt = con.prepareStatement(sql);
        pSt.setString(1, nome);
        pSt.execute();

        System.out.println("Comando realizado com sucesso");

        con.close();
        sc.close();
    }
}
