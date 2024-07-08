package exception;

public class ListEmptyException extends Exception{

    String msg;

    public ListEmptyException(String msg){
        super(msg);
        this.msg = msg;
    }
}
