package test;

public class Teste{
    public static void main(String[] args) {
       DAO2 dao = new DAO2();

       String sql = "INSERT INTO pessoas (nome) VALUES (?);";
       dao.execute(sql,"João da Silva Pedro");
       dao.execute(sql,"Pedro Henrique");
       dao.execute(sql,"Julia Ribeiro");


    }
}
