package error;

public class DataNegativa extends Exception{
    public DataNegativa(int data, String msg) {
        super("'" + msg + "'" + " " + data + " não é aceito. Somente" + " " +msg + " maiores ou iguais a 1.");
    }
}
