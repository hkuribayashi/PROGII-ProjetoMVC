package dao;

import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {

    protected final List<T> dados;

    public DAO(){
        this.dados = new ArrayList<>();
    }

    public abstract void add(T t);

    public abstract List<T> getAll();

}
