package petriNet.semantics;

/**
 * Created by Mihai on 3/9/2017.
 */
public class Place extends PetriObject {
    /**
     * Marks if there is a token or not in this place
     */
    private boolean token;

    /**
     * Constructor
     *
     * @param token
     */
    public Place(boolean token) {
        this.token = token;
    }

    /**
     * Checks token
     *
     * @return boolean
     */
    public boolean isToken() {
        return token;
    }

    public void setToken(boolean token) {
        this.token = token;
    }
}
