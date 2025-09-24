public class Teste{
    public static void main(String[] args) {
       DAOPessoa daoPessoa = new DAOPessoa();

       daoPessoa.save(new Pessoa(7, "Gustavo Augusto"));
       System.out.println("Salvo com sucesso!");
    }
}
