package by.varyvoda.matvey.dao.session.exception;

import java.io.IOException;

public class SessionCommittedException extends IOException {

    public SessionCommittedException(String message) {
        super(message);
    }
}
