package test.ar;

public class ProdutoTeste {
    public static void main(String[] args) {
        Produto book = new Produto("book", 20);
        //book.save();

        Produto notebook = new Produto("Notebook", 3000);
        //notebook.save();
        //System.out.println(notebook.getId());
        // output = 0   
        // why is worthing 0? 
        
        Produto caderno = new Produto("Caderno", 10);
        //caderno.save();
        // correct id = 7 
        // getid() -> 0

        System.out.println(caderno.getId());


    }
}
