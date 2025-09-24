import java.util.List;

// it's the interface of the DAO -> Data Access Object
public interface DAOInterface <T>{
    // All the objects that implements that interface are DAO's.
    public void save(T entity);
    public void delete(T entity);
    public List<T> listAll();
    public T searchId(long id);
}