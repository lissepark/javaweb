package exeptions;

/**
 * @author Sergii Varenyk
 */
public class WebtasksDataException extends WebtasksException {

	public WebtasksDataException(String message) {
		super(message);
	}

	public WebtasksDataException(Throwable cause) {
		super(cause);
	}

	public WebtasksDataException(String message, Throwable cause) {
		super(message, cause);
	}

}
