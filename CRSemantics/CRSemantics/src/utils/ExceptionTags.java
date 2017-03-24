package utils;

public enum ExceptionTags {
    EmptyListException("Cannot execute empty action lists"),
    BlockingConditionException("Blocking condition relation"),
    InvalidActionException("Cannot execute invalid actions"),
    InvalidCRGraphException("This is not a valid CR graph"),
    NoNestedGraphException("There is no nested graph for the given id"),
    GenricException("Generic semantics exception");

    private final String name;

    private ExceptionTags(String s) {
        name = s;
    }

    /**
     * Function used to check if a given string is equal to the name of this
     * exception
     *
     * @param otherName
     * @return
     */
    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null)
        // returns false
        return name.equals(otherName);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
