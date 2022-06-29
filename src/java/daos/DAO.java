package daos;

import java.util.HashMap;
import java.util.List;

public interface DAO<T> {
    public abstract boolean add(T entity);
    
    public abstract boolean update(int id, HashMap<String, String> columnValuePair);
    
    public abstract boolean delete(int id);
    
    public abstract T getOne(String column, String value);
    
    public abstract List<T> getList();
    
    public abstract List<T> getList(String column, String value);
}
