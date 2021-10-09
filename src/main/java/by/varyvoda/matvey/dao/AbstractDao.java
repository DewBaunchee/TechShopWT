package by.varyvoda.matvey.dao;

import by.varyvoda.matvey.dao.iface.IDao;
import by.varyvoda.matvey.dao.session.Session;

import java.io.File;
import java.io.FileNotFoundException;

public abstract class AbstractDao<V> implements IDao<V> {

    private final File source;

    public AbstractDao(String path) {
        source = new File(path);
    }

    public Session<V> getSession() throws FileNotFoundException {
        return new Session<>(source);
    }
}
