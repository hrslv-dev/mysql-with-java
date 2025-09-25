package test;

public class Teste{
    public static void main(String[] args) {
       DAO dao = new DAO();

       String sql = "INSERT INTO pessoas (nome) VALUES (?);";
       dao.include(sql,"João da Silva Pedro");
       dao.include(sql,"Pedro Henrique");
       dao.include(sql,"Julia Ribeiro");


    }
}
