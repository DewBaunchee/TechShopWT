package by.varyvoda.matvey.dao.session;

import by.varyvoda.matvey.dao.session.exception.SessionCommittedException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Session<V> {

    private final File source;

    private final XmlMapper xmlMapper;

    private Scanner scanner;

    private Class<V> vClass;

    private List<V> result;

    private boolean isCommitted;

    private INextEntityCallback<V> callback;

    public Session(File source) {
        this.source = source;
        this.isCommitted = false;
        this.xmlMapper = new XmlMapper();
    }

    public void save(V value) throws IOException {
        if(isCommitted)
            throw new SessionCommittedException("Unable to write: session is committed");

        Files.write(Path.of(source.getAbsolutePath()), xmlMapper.writeValueAsBytes(value), StandardOpenOption.APPEND);
    }

    public Session<V> createQuery(INextEntityCallback<V> callback, Class<V> vClass) throws FileNotFoundException {
        if (callback == null)
            throw new IllegalArgumentException("Query is not specified.");
        if (vClass == null)
            throw new IllegalArgumentException("Value class is not specified.");

        this.callback = callback;
        this.vClass = vClass;
        this.scanner = new Scanner(source);
        return this;
    }

    public Session<V> commit() throws JsonProcessingException, SessionCommittedException {
        if(isCommitted)
            throw new SessionCommittedException("Unable to commit: session is committed");

        result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String xmlValue = scanner.nextLine();
            V value = xmlMapper.readValue(xmlValue, vClass);
            if (callback.isSuitable(value))
                result.add(value);
        }

        scanner.close();
        isCommitted = true;
        return this;
    }

    public List<V> getResult() throws SessionCommittedException {
        if(!isCommitted)
            throw new SessionCommittedException("Unable to get result: session isn't committed");

        return result;
    }
}
