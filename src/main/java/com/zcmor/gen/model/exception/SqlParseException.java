package com.zcmor.gen.model.exception;

public class SqlParseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286662091865281718L;

	public SqlParseException() {
	super();
    }

   
    public SqlParseException(String message) {
	super(message);
    }

   
    public SqlParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlParseException(Throwable cause) {
        super(cause);
    }
	
}
