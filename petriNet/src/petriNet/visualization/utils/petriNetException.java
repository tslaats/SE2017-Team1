package petriNet.visualization.utils;

/**
 * {@link petriNetException} signals a petri net error.
 */
public class petriNetException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new petriNetException.
     */
    public petriNetException() {
        super();
    }

    /**
     * Instantiates a new petriNetException.
     *
     * @param message
     *            the message
     */
    public petriNetException(String message) {
        super(message);
    }

    /**
     * Instantiates a new petriNetException.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public petriNetException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new petriNetException.
     *
     * @param ex
     *            the exception
     */
    public petriNetException(Throwable ex) {
        super(ex);
    }
}
