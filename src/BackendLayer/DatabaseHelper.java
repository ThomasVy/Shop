package BackendLayer;

public interface DatabaseHelper {
    void insert(Object object);
    void delete(Object object);
    Object select(Object object);
    void modify(Object object);
}
