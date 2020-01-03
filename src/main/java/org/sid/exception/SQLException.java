package org.sid.exception;

public class SQLException extends RuntimeException {

    public SQLException() {
        super();
    }

    public SQLException( final String message ) {
        super( message );
    }

}
