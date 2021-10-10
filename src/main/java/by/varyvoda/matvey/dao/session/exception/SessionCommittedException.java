package by.varyvoda.matvey.dao.session.exception;

import java.io.IOException;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 * */
public class SessionCommittedException extends IOException {

    public SessionCommittedException(String message) {
        super(message);
    }
}
