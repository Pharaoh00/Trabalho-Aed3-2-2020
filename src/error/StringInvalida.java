package error;

public class StringInvalida extends Exception{
    public StringInvalida(String msg) {
        super("String " + "'" + msg + "'" + " não é valida.");
    }
}
