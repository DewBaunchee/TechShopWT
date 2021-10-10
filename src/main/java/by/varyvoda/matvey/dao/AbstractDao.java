package by.varyvoda.matvey.dao;

import by.varyvoda.matvey.dao.iface.IDao;
import by.varyvoda.matvey.dao.session.Session;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public abstract class AbstractDao<V> implements IDao<V> {

    private final File source;

    public AbstractDao(String path) {
        source = new File(path);
    }

    /**
     * Method creates an instance of session
     *
     * @return new session from source
     * @throws FileNotFoundException if file was not found
     */
    public Session<V> getSession() throws FileNotFoundException {
        return new Session<>(source);
    }
}
