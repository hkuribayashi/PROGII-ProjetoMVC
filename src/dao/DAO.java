package dao;

import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {

    public DAO(){

    }

    public abstract void add(T t);

    public abstract List<T> getAll();

}
