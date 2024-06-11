package votingvoter.Exceptions;

public class FileNotFoundException extends RuntimeException{
    public FileNotFoundException(String msg){
        super(msg);
    }

    public FileNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
