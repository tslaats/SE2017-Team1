package utils;

public enum ExceptionTags {
    EmptyListException("Cannot execute empty action lists!"),
    InvalidActionException("Cannot execute invalid actions!"),
    GenricException("Generic semantics exception");

    private final String name;

    private ExceptionTags(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    @Override
	public String toString() {
       return this.name;
    }
}
