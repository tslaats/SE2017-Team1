package petriNet.visualization.utils;

/**
 * BookStoreConstants declares the constants used in the CertainBookStore (by
 * both servers and clients).
 */
public final class petriNetConstants {

    // Constants used when creating exception messages

    /** The Constant INVALID. */
    public static final String INVALID_POSITION = "'s position is invalid";
    
    /** The Constant INVALID. */
    public static final String INVALID_ID = " is an invalid id";
    
    /** The Constant INVALID. */
    public static final String INVALID_NAME = " is an invalid name";
    
    /** The Constant NULL_INPUT. */
    public static final String NULL_INPUT = "null input parameters";
    
    /** The Constant DUPLICATED when the place or transition is already in the petrinet,
     * or a place is already in the list of outgoing or incoming places for a transition. */
    public static final String DUPLICATED = " is duplicated";
    
    /** The Constant NOT_AVAILABLE when place or transition does not exists in the petrinet. */
    public static final String NOT_AVAILABLE = " is not available";

    /**
     * Prevents the instantiation of a new {@link petriNetConstants}.
     */
    private petriNetConstants() {
        // Prevent instantiation.
    }
}

