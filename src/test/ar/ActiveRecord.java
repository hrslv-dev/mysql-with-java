package test.ar;




// How the AR works? 
// Simple responsibility. 
// the class that will inherit the AC interface needs to have responsibility for the persistence and the mapping. 

/*interface ActiveRecord{
 *  void save()
 *  void delete()
 * 
 * class Produto implements ActiveRecord{ 
 *      private String name; 
 *      private double value; 
 *    
 *     @Override: 
 *      void save(){
 *          sql = "INSERT INTO Produtos (name) VALUES (?)"; 
 *          PreparedStatement ps = getConnection().prepareStatement(sql);
 *          ps.setString(1, this.getName());
 *
 * }
 * } 
}       I GET IT*/


public interface  ActiveRecord {
    void save();
    void delete();
    void update();
}