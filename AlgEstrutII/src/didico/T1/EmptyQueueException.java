package didico.T1;

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException() {
        super("EmptyQueueException");
    }
    
    public EmptyQueueException(String message) {
        super(message);
    }
    
}
