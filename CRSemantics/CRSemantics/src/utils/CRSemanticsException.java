package utils;

public class CRSemanticsException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public CRSemanticsException() {
		super();
	}

	public CRSemanticsException(String message) {
		super(message);
	}
	
	public CRSemanticsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CRSemanticsException(Throwable ex) {
		super(ex);
	}
}
