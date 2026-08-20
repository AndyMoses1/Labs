package exceptions;

/**
 * Thrown when the factory has issued every plate in its pool.
 *
 * Extends Exception rather than RuntimeException, which makes it a CHECKED
 * exception: the compiler forces every caller to either catch it or declare
 * it. That is what we want here, because running out of plates is a
 * foreseeable business condition the caller can sensibly react to - not a
 * programming bug.
 */
public class OutOfRegistrationPlatesException extends Exception {

	private static final long serialVersionUID = 1L;

	public OutOfRegistrationPlatesException(String message) {
		super(message);
	}

}
