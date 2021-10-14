
package Main.Classe.DAO;
import javax.swing.*;

public interface DAO<T>
{   
    void add(T t);
    void update(T t, int id, String type, String value);
    void delete(T t, int id);
    T getById(T t, int value, JLabel message);
    T getByString(T t, String type, String value, JLabel message);
}
