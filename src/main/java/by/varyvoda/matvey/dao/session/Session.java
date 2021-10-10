package by.varyvoda.matvey.dao.session;

import by.varyvoda.matvey.dao.session.exception.SessionCommittedException;
import by.varyvoda.matvey.entity.criteria.Query;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public class Session<V> {

    private final File source;

    private final XmlMapper xmlMapper;

    private Scanner scanner;

    private Query query;

    private List<V> result;

    private boolean isCommitted;

    public Session(File source) {
        this.source = source;
        this.isCommitted = false;
        this.xmlMapper = new XmlMapper();
    }

    /**
     * @param value - value for saving
     * @throws SessionCommittedException if session is already committed
     * @throws JsonProcessingException   if value cannot be mapped
     */
    public void save(Object value) throws IOException {
        if (isCommitted)
            throw new SessionCommittedException("Unable to write: session is committed");

        Files.write(
                Path.of(source.getAbsolutePath()),
                (xmlMapper.writeValueAsString(value) + "\n").getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.APPEND
        );
    }

    /**
     * @param query - query for searching
     * @return instance of this session
     * @throws FileNotFoundException if file not found
     */
    public Session<V> specifyQuery(Query<? extends V> query) throws FileNotFoundException {
        if (query == null)
            throw new IllegalArgumentException("Query is not specified.");

        this.query = query;
        this.scanner = new Scanner(source);
        return this;
    }

    /**
     * @return instance of this session
     * @throws SessionCommittedException if session is already committed
     */
    public Session<V> commit() throws SessionCommittedException {
        if (isCommitted)
            throw new SessionCommittedException("Unable to commit: session is committed");

        result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            try {
                String xmlValue = scanner.nextLine();
                Object value = xmlMapper.readValue(xmlValue, query.getTargetClass());
                if (query.isSuitable(value))
                    result.add((V) value);
            } catch (JsonProcessingException ignored) {
            }
        }

        scanner.close();
        isCommitted = true;
        return this;
    }

    /**
     * @return instance of this session
     * @throws SessionCommittedException if session not committed
     */
    public List<V> getResult() throws SessionCommittedException {
        if (!isCommitted)
            throw new SessionCommittedException("Unable to get result: session isn't committed");

        return result;
    }
}
