/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.HashMap;
import java.util.List;

public interface DAOInterface<T> {
    public abstract boolean add(T entity);
    
    public abstract boolean update(int id, HashMap<String, String> columnValuePair);
    
    public abstract boolean delete(int id);
    
    public abstract T getOne(String column, String value);
    
    public abstract List<T> getList();
}
